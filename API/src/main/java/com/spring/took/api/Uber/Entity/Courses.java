package com.spring.took.api.Uber.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Courses extends BaseModel{
    private String name;


    @ManyToMany
    private List<Student> students;
}
