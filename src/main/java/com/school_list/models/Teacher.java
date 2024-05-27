package com.school_list.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "teachers")
public class Teacher { // Класс сущности учитель. Является пользователем приложения (может регистрироваться)
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
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
   /* @Column(name = "created_at")
    private Date created_at;
    @Transient // изначально будет NULL, поэтому нужна эта аннотация, чтобы работал select и тд
    @Column(name = "updated_at")
    private Date updated_at;*/

    public Teacher(Integer id, String first_name, String surname, String last_name, String phone, String email, String password, Date created_at, Date updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        /*this.created_at = created_at;
        this.updated_at = updated_at;*/
    }

    public Teacher() {}

    public Teacher(Integer id, String first_name, String surname, String last_name, String phone, String email, String password/*, Date created_at*/) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        //this.created_at = created_at;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }*/

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
               /* ", created_at=" + created_at +
                ", updated_at=" + updated_at +*/
                '}';
    }
}
