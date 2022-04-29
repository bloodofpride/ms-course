package com.devsuperior.hrworker.controllers;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.services.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    private WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok().body(workerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(workerService.findById(id));
    }
}
