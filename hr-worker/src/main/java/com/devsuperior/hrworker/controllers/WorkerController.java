package com.devsuperior.hrworker.controllers;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.services.WorkerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {
    private static final Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private final WorkerService workerService;
    private final Environment env;

    @Value("${test.config}")
    private String testConfig;

    public WorkerController(WorkerService workerService,  Environment env){
        this.workerService = workerService;
        this.env = env;
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok().body(workerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
//        try{
//            Thread.sleep(3000L);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        logger.info("PORT = " + env.getProperty("local.server.port"));
        return ResponseEntity.ok().body(workerService.findById(id));
    }
}
