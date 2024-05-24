package com.school_list.models;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group { // Группа учеников.
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "id_teacher")
    private Integer id_teacher;
    @Column(name = "count")
    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
