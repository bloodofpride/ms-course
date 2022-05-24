package com.devsuperior.hroauth.controllers;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.services.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserSevice userSevice;

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        try {
            User user = userSevice.findByEmail(email);
            return ResponseEntity.ok().body(user);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }
}
