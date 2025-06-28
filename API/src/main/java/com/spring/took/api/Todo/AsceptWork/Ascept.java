package com.spring.took.api.Todo.AsceptWork;

import com.spring.took.api.Todo.Entity.Todo;
import com.spring.took.api.Todo.TodoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Ascept {


    @Pointcut("execution(* com.spring.took.api.Todo.TodoApp.getTodos() )")
    public void CustomPoint(){

    }
    @Around("CustomPoint()")
    public Object aroundWork(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();
//        System.out.println("Yarr : " +System.currentTimeMillis());
        Object result =  proceedingJoinPoint.proceed();
//        System.out.println("Gaya : "+System.currentTimeMillis());
        long end = System.currentTimeMillis();
        System.out.println("Time Take to execute : "+(start - end));
    return result;
    }

    @Before("execution(* com.spring.took.api.Todo.TodoApp.addTodo(..))")
    public void BeforeWork(){
        System.out.println("Call");
    }

    @AfterReturning(value = "execution(* com.spring.took.api.Todo.TodoApp.getTodo(..))" ,returning = "result")
    public void AfterWork(JoinPoint joinPoint ,Object result){
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getTarget());
        System.out.println(result);
    }
}
