package com.school_list.rest_controllers;

import com.school_list.models.Mark;
import com.school_list.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marks")
public class MarkApiController {
    @Autowired
    MarkService markService;
    @PostMapping("/save")
    public ResponseEntity<Mark> saveMark(@RequestBody Mark mark) {
        markService.save(mark);
        return new ResponseEntity<>(mark, HttpStatus.OK);
    }

    @GetMapping("/get")
    public List<Mark> getAllMarks() { return markService.getAllMarks(); }
    @GetMapping("/get/{id}")
    public ResponseEntity<Mark> getMarkById(@PathVariable("id") Integer markId) {
        Optional<Mark> mark = markService.getMarkById(markId);
        if (!mark.isPresent()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(mark.get(), HttpStatus.OK);
    }
    @GetMapping("/get_student_marks/{id}")
    public ResponseEntity<List<Mark>> getStudentMarks(@PathVariable("id") Integer studentId) {
        List<Mark> marks = markService.getStudentMarks(studentId);
        if (marks.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(marks, HttpStatus.OK);
    }
    @GetMapping("/get_student_subject_marks/{student_id}/{subject_id}")
    public ResponseEntity<List<Mark>> getStudentSubjectMarks(@PathVariable("student_id") Integer studentId, @PathVariable("subject_id") Integer subjectId) {
        System.out.println(studentId);
        System.out.println(subjectId);
        List<Mark> marks = markService.getStudentSubjectMarks(studentId, subjectId);
        if (marks.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(marks, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public Mark deleteMarkById(@PathVariable("id") Integer markId) {
        return markService.deleteMarkById(markId);
    }
    @PutMapping("/update")
    public ResponseEntity<Mark> updateMark(@RequestBody Mark mark) {
        Optional<Mark> mark1 = markService.getMarkById(mark.getId());
        if (!mark1.isPresent()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else {
            return new ResponseEntity<>(markService.updateMark(mark), HttpStatus.OK);
        }
    }
}
