package com.Spring.took;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class AnnotationImp {


    @After("@annotation(TimeMonitor )")
    public void timeShow(){
        System.out.println("time ho gaya");
    }
}
