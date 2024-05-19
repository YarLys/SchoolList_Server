package com.school_list.rest_controllers;

import com.school_list.models.Teacher;
import com.school_list.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegisterApiController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/user/register")
    public Teacher registerNewUser(@RequestBody Teacher teacher) {
        teacher.setPassword(BCrypt.hashpw(teacher.getPassword(), BCrypt.gensalt())); // храним хэш пароля
        teacherService.save(teacher);
        return teacher;
    }

    @GetMapping("/user/get")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/user/get/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable("id") Integer teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @DeleteMapping("/user/delete/{id}")
    public Optional<Teacher> deleteTeacherById(@PathVariable("id") int teacherId) {
        return teacherService.deleteTeacherById(teacherId);
    }

    /*
    @PostMapping("/user/register")
    public ResponseEntity registerNewUser(@RequestParam("first_name") String first_name,
                                          @RequestParam("surname") String surname,
                                          @RequestParam("last_name") String last_name,
                                          @RequestParam("phone") String phone,
                                          @RequestParam("email") String email,
                                          @RequestParam("password") String password) {
        if (first_name.isEmpty() || surname.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Please enter all necessary fields.", HttpStatus.BAD_REQUEST);
        }
        // Encrypt password
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // Register a new user
        int result = teacherService.registerNewUserServiceMethod(first_name, surname, last_name, phone, email, hashed_password);

        if (result != 1) {
            return new ResponseEntity<>("Register a user is Failed.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User registered successfully.", HttpStatus.OK);
    }

    */
}
