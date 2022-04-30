package com.devsuperior.hrworker.controllers;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.services.WorkerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private WorkerService workerService;
    private Environment env;
    

    public WorkerController(WorkerService workerService,  Environment env){
        this.workerService = workerService;
        this.env = env;
    }

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok().body(workerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        logger.info("PORT = " + env.getProperty("local.server.port"));
        return ResponseEntity.ok().body(workerService.findById(id));
    }
}
