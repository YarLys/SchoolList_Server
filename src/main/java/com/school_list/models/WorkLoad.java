package com.school_list.models;

import jakarta.persistence.*;

@Entity
@Table(name = "workload")
public class WorkLoad {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name_workload")
    private String name_workload;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name_workload;
    }

    public void setName(String name) {
        this.name_workload = name;
    }

    public WorkLoad() {}

    public WorkLoad(Integer id, String name_workload) {
        this.id = id;
        this.name_workload = name_workload;
    }

    public WorkLoad(String name_workload) {
        this.name_workload = name_workload;
    }
}
