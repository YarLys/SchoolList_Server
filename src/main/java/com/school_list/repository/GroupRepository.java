package com.school_list.repository;

import com.school_list.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    public Optional<Group> findById(String id);
    //public void deleteById(String id);

    void delete(Group group);
}
