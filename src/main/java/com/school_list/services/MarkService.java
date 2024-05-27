package com.school_list.services;

import com.school_list.models.Mark;
import com.school_list.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;
    public void save(Mark mark) { markRepository.save(mark); }
    public List<Mark> getAllMarks() {
        List<Mark> marks = new ArrayList<>();
        Streamable.of(markRepository.findAll())
                .forEach(mark -> {
                    marks.add(mark);
                });
        return marks;
    }
    public Optional<Mark> getMarkById(Integer markId) { return markRepository.findById(markId); }
    public List<Mark> getStudentMarks(Integer studentId) {
        List<Mark> marks = new ArrayList<>();
        Streamable.of(markRepository.findAll())
                .forEach(mark -> {
                    if (mark.getId_student() == studentId) marks.add(mark);
                });
        return marks;
    }
    public List<Mark> getStudentSubjectMarks(Integer studentId, Integer subjectId) {
        List<Mark> marks = new ArrayList<>();
        Streamable.of(markRepository.findAll())
                .forEach(mark -> {
                    if (mark.getId_student() == studentId && mark.getSubject_id() == subjectId)
                        marks.add(mark);
                });
        return marks;
    }
    public Mark deleteMarkById(Integer markId) {
        Mark mark = markRepository.findById(markId).get();
        markRepository.deleteById(markId);
        return mark;
    }
    public Mark updateMark(Mark mark) {
        Mark old_mark = markRepository.findById(mark.getId()).get();
        old_mark.setDate(mark.getDate());
        old_mark.setId_student(mark.getId_student());
        old_mark.setId_student(mark.getId_student());
        old_mark.setWorkload_id(mark.getWorkload_id());
        old_mark.setValue(mark.getValue());
        old_mark = markRepository.save(old_mark);
        return old_mark;
    }
}
