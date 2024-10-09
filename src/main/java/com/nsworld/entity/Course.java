package com.nsworld.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "newRegister_id")
    @JsonBackReference
    private NewRegister newRegister;

    // Constructors, getters, and setters
    public Course() {}

    public Course(String name, NewRegister newRegister) {
        this.name = name;
        this.newRegister = newRegister;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewRegister getNewRegister() {
        return newRegister;
    }



    public void setNewRegister(NewRegister newRegister) {
        this.newRegister = newRegister;
    }
}
