package com.school_list.services;

import com.school_list.models.WorkLoad;
import com.school_list.repository.WorkloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkloadService {
    @Autowired
    WorkloadRepository workloadRepository;

    public Optional<WorkLoad> deleteById(Integer id) {
        Optional<WorkLoad> workLoad = workloadRepository.findById(id);
        workloadRepository.deleteById(id);
        return workLoad;
    }

    public void save(WorkLoad workLoad) { workloadRepository.save(workLoad); }

    public Optional<WorkLoad> getworkloadById(Integer id) { return workloadRepository.findById(id); }

    public List<WorkLoad> getAllworkloads() {
        List<WorkLoad> workloads = new ArrayList<>();
        Streamable.of(workloadRepository.findAll())
                .forEach(workload -> {
                    workloads.add(workload);
                });
        return workloads;
    }
}
