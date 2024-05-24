package com.school_list.rest_controllers;

import com.school_list.models.WorkLoad;
import com.school_list.services.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workloads")
public class WorkloadApiController {
    @Autowired
    WorkloadService workloadService;

    @PostMapping("/save/{name}")
    public ResponseEntity<WorkLoad> saveNewWorkLoad(@PathVariable("name") String name) {
        /*System.out.println(WorkLoad.getName());
        if (!WorkLoad.getName().isEmpty()) {
            workloadService.save(WorkLoad);
            return new ResponseEntity<>(WorkLoad, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);*/
        if (!name.isEmpty()) {
            WorkLoad WorkLoad = new WorkLoad(name);
            workloadService.save(WorkLoad);
            return new ResponseEntity<>(WorkLoad, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get")
    public List<WorkLoad> getAllWorkLoads() {
        return workloadService.getAllworkloads();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<WorkLoad>> getWorkLoadById(@PathVariable("id") Integer WorkLoadId) {
        Optional<WorkLoad> WorkLoad = workloadService.getworkloadById(WorkLoadId);
        if (WorkLoad.isPresent()) return new ResponseEntity<>(WorkLoad, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<WorkLoad>> deleteWorkLoadById(@PathVariable("id") Integer WorkLoadId) {
        Optional<WorkLoad> WorkLoad = workloadService.getworkloadById(WorkLoadId);
        if (WorkLoad.isPresent()) return new ResponseEntity<>(workloadService.deleteById(WorkLoadId), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
