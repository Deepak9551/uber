package com.spring.took.api.Uber.Entity;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
