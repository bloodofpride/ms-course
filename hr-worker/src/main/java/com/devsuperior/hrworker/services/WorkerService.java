package com.devsuperior.hrworker.services;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Worker findById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(Worker.class,"Worker Not Found with id: "+id));
    }
}
