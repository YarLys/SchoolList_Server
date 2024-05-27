package com.school_list.models;

import jakarta.persistence.*;
@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_student")
    private Integer id_student;
    @Column(name = "subject_id")
    private Integer subject_id;
    @Column(name = "workload_id")
    private Integer workload_id;
    @Column(name = "date")
    private String date;
    @Column(name = "value")
    private Integer value;
    public Mark() {}
    public Mark(Integer id, Integer id_student, Integer subject_id, Integer workload_id, Integer value) {
        this.id = id;
        this.id_student = id_student;
        this.subject_id = subject_id;
        this.workload_id = workload_id;
        this.value = value;
    }

    public Mark(Integer id, Integer id_student, Integer subject_id, Integer workload_id, String date, Integer value) {
        this.id = id;
        this.id_student = id_student;
        this.subject_id = subject_id;
        this.workload_id = workload_id;
        this.date = date;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_student() {
        return id_student;
    }

    public void setId_student(Integer id_student) {
        this.id_student = id_student;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getWorkload_id() {
        return workload_id;
    }

    public void setWorkload_id(Integer workload_id) {
        this.workload_id = workload_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
