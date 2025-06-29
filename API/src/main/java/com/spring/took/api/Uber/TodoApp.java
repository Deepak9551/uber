package com.spring.took.api.Uber;

import com.spring.took.api.Uber.Entity.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoApp {

    List<Todo> list = new ArrayList<>();

    public TodoApp() {
       list.add(new Todo("1","new title",true,"123"));
        list.add(new Todo("1","new man",false,"321"));
    }

    @GetMapping
    public List<Todo> getTodos(){
        return list;
    }

    @PostMapping
    public Todo  addTodo(@RequestBody Todo todo){
        list.add(todo);
       return todo;
    }
    @GetMapping("/{id}")
        public ResponseEntity<?> getTodo(@PathVariable String id){
       for (Todo todo : list){
           if (todo.getId().equals(id)){
               return ResponseEntity.status(HttpStatus.OK).body(todo);
           }
           break;
       }
       return ResponseEntity.notFound().build();
    }
}
