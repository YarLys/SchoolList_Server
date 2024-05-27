package com.school_list.services;

import com.school_list.models.Teacher;
import com.school_list.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    public Optional<Teacher> deleteTeacherById(Integer teacherId) { // удаление учителя по id
        Optional<Teacher> temp = teacherRepository.findById(teacherId);
        teacherRepository.deleteById(teacherId);
        return temp;
    }
    public Optional<Teacher> getTeacherById(Integer teacherId) {
        return teacherRepository.findById(teacherId);
    }
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Streamable.of(teacherRepository.findAll())
                .forEach(teacher -> {
                    teachers.add(teacher);
                });
        return teachers;
    }
}
