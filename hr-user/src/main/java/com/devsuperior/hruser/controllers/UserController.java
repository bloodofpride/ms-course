package com.devsuperior.hruser.controllers;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "Usuário não encontrado com o id informado"));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException(User.class, "Usuário não encontrado com o email informado"));
        return ResponseEntity.ok().body(user);
    }
}
