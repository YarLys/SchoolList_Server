package com.school_list.models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "id_class")
    private String id_class;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_class() {
        return id_class;
    }

    public void setId_class(String id_class) {
        this.id_class = id_class;
    }

    public Student(Integer id, String first_name, String surname, String last_name, String phone, String id_class) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.last_name = last_name;
        this.phone = phone;
        this.id_class = id_class;
    }

    public Student(String first_name, String surname, String last_name, String phone, String id_class) {
        this.first_name = first_name;
        this.surname = surname;
        this.last_name = last_name;
        this.phone = phone;
        this.id_class = id_class;
    }
    public Student() {}
}
