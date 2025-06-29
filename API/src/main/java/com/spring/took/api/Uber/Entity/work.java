package com.spring.took.api.Uber.Entity;

import org.springframework.stereotype.Component;

@Component
public class work {


    @TimeMonitor
    public  void service(){
        System.out.println("service is executed");

    }

}
