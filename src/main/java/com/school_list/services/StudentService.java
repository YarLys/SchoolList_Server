package com.school_list.services;

import com.school_list.models.Student;
import com.school_list.models.Subject;
import com.school_list.models.Teacher;
import com.school_list.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Getall, getByid, save, update?, deleteById
    public void save(Student student) { studentRepository.save(student); }
    public Optional<Student> getStudentById(Integer studentId) { return studentRepository.findById(studentId); }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Streamable.of(studentRepository.findAll())
                .forEach(student -> {
                    students.add(student);
                });
        return students;
    }
    public List<Student> getStudentsByClass(String id_class) {
        List<Student> students = new ArrayList<>();
        Streamable.of(studentRepository.findAll())
                .forEach(student -> {
                    if (student.getClass_id().equals(id_class))
                        students.add(student);
                });
        return students;
    }

    public Optional<Student> deleteById(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        studentRepository.deleteById(studentId);
        return student;
    }
}
