package com.spring.took.api.Todo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Courses extends BaseModel{
    private String name;


    @ManyToMany
    private List<Student> students;
}
