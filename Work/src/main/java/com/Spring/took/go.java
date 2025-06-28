package com.Spring.took;


public class go {

    @TimeMonitor
    public static void service(){
        System.out.println("Service method is executed");
    }

    public static void main(String[] args) {
service();
    }
}
