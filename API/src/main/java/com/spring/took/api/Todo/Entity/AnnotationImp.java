package com.spring.took.api.Todo.Entity;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AnnotationImp {


    @Around("@annotation(TimeMonitor)")
    public void timeShow(){
        long start = System.currentTimeMillis();
        System.out.println("time ho gaya");

        long end = System.currentTimeMillis();
        System.out.println("Total Time = "+(start - end));
    }
}
