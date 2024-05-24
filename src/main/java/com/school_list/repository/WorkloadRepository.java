package com.school_list.repository;

import com.school_list.models.WorkLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkloadRepository extends JpaRepository<WorkLoad, Integer> {

}
