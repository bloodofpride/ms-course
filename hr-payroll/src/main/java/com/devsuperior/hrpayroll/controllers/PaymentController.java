package com.devsuperior.hrpayroll.controllers;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok().body(payment);
    }
}
