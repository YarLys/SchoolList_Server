package com.school_list.rest_controllers;

import com.school_list.models.Group;
import com.school_list.models.Teacher;
import com.school_list.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupApiController {
    @Autowired
    GroupService groupService;

    @PostMapping("/save")
    public ResponseEntity<Group> saveNewGroup(@RequestBody Group group) {
        List<Group> groups = groupService.getAllGroups();
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId().equals(group.getId())) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        groupService.save(group);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @GetMapping("/get")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Group>> getGroupById(@PathVariable("id") String groupId) {
        Optional<Group> group = groupService.getGroupById(groupId);
        if (group.isPresent()) return new ResponseEntity<>(group, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Group>> deleteGroupById(@PathVariable("id") String groupId) {
        Optional<Group> group = groupService.getGroupById(groupId);
        if (group.isPresent()) return new ResponseEntity<>(groupService.deleteById(groupId), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
