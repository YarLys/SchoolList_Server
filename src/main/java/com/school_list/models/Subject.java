package com.school_list.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject { // Класс для дисциплин.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name_subject")
    private String name_subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name_subject;
    }

    public void setName(String name) {
        this.name_subject = name;
    }

    public Subject() {}

    public Subject(Integer id, String name_subject) {
        this.id = id;
        this.name_subject = name_subject;
    }

    public Subject(String name_subject) {
        this.name_subject = name_subject;
    }
}
