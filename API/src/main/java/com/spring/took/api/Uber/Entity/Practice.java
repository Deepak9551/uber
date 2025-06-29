package com.spring.took.api.Uber.Entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Practice {


    Practice(@Qualifier("work") work work){
       work.service();
    }
}
