package com.school_list.rest_controllers;

import com.school_list.models.Teacher;
import com.school_list.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginApiController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/user/login")
    public Teacher loginUser(@RequestBody Teacher teacher) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getEmail().equals(teacher.getEmail()) &&
                    BCrypt.checkpw(teacher.getPassword(), teachers.get(i).getPassword())) {
                return teachers.get(i);
            }
        }
        return null;
    }
}
