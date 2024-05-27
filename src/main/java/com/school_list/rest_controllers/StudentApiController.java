package com.school_list.rest_controllers;

import com.school_list.models.Student;
import com.school_list.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {
    @Autowired
    StudentService studentService;
    @PostMapping("/save/{id_class}")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student, @PathVariable("id_class") String id_class) {
        List<Student> students = studentService.getAllStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirst_name().equals(student.getFirst_name()) &&
            students.get(i).getSurname().equals(student.getSurname()) && students.get(i).getPhone().equals(student.getPhone())
            && students.get(i).getClass_id().equals(id_class)) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        student.setClass_id(id_class);
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    /*@PostMapping("/{id}/set_class/{id_class}")
    public ResponseEntity<Student> setStudentClass(@PathVariable("id") Integer studentId, @PathVariable("id_class") String id_class) {
        Optional<Student> student = studentService.getStudentById(studentId);
        student.get().setClass_id(id_class);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }*/
    @GetMapping("/get")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/get_class/{id}")
    public List<Student> getStudentsByClass(@PathVariable("id") String class_id) {
        return studentService.getStudentsByClass(class_id);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer studentId) {
        Optional<Student> student = studentService.getStudentById(studentId);
        if (!student.isPresent()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public Optional<Student> deleteStudentById(@PathVariable("id") Integer studentId) {
        return studentService.deleteById(studentId);
    }
}
