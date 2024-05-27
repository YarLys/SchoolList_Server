package com.school_list.services;

import com.school_list.models.Group;
import com.school_list.models.Subject;
import com.school_list.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public Optional<Subject> deleteById(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        subjectRepository.deleteById(id);
        return subject;
    }

    public void save(Subject subject) { subjectRepository.save(subject); }

    public Optional<Subject> getSubjectById(Integer id) { return subjectRepository.findById(id); }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        Streamable.of(subjectRepository.findAll())
                .forEach(subject -> {
                    subjects.add(subject);
                });
        return subjects;
    }
}
