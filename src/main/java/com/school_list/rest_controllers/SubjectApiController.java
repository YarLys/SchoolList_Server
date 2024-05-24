package com.school_list.rest_controllers;

import com.school_list.models.Subject;
import com.school_list.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectApiController {
    @Autowired
    SubjectService subjectService;

    @PostMapping("/save/{name}")
    public ResponseEntity<Subject> saveNewSubject(@PathVariable("name") String name /*@RequestBody Subject subject*/) {
        /*System.out.println(subject.getName());
        if (!subject.getName().equals("")) {
            subjectService.save(subject);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);*/
        if (!name.isEmpty()) {
            Subject subject = new Subject(name);
            subjectService.save(subject);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        }
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Subject>> getSubjectById(@PathVariable("id") Integer subjectId) {
        Optional<Subject> subject = subjectService.getSubjectById(subjectId);
        if (subject.isPresent()) return new ResponseEntity<>(subject, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Subject>> deleteSubjectById(@PathVariable("id") Integer subjectId) {
        Optional<Subject> subject = subjectService.getSubjectById(subjectId);
        if (subject.isPresent()) return new ResponseEntity<>(subjectService.deleteById(subjectId), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
