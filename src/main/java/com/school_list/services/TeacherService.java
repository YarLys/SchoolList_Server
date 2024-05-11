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

    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    /*public Teacher deleteTeacherById(int teacherId) { // удаление учителя по id
        Teacher temp = teacherRepository.findTeacherById(teacherId);
        teacherRepository.delete(temp);
        return temp;
    }*/

    public Optional<Teacher> getTeacherById(Integer teacherId) {
        return teacherRepository.findById(teacherId);
    }
    /*public Teacher getTeacherById(int teacherId) {
        List<Teacher> teachers = getAllTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == teacherId) {
                return teachers.get(i);
            }
        }
        return null;
    }*/

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Streamable.of(teacherRepository.findAll())
                .forEach(teacher -> {
                    teachers.add(teacher);
                });
        return teachers;
    }

    /*public int registerNewUserServiceMethod(String first_name, String surname, String last_name, String phone, String email, String password) {
        return teacherRepository.registerNewUser(first_name, surname, last_name, phone, email, password);
    }*/
}
