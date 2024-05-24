package com.school_list.services;

import com.school_list.models.Group;
import com.school_list.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;
    public Optional<Group> deleteById(String id) {
        Optional<Group> group = groupRepository.findById(id);
        //groupRepository.deleteById(id);
        groupRepository.delete(group.get());
        return group;
    }

    public void save(Group group) { groupRepository.save(group); }

    public Optional<Group> getGroupById(String id) { return groupRepository.findById(id); }

    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        Streamable.of(groupRepository.findAll())
                .forEach(group -> {
                    groups.add(group);
                });
        return groups;
    }
}
