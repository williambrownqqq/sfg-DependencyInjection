package com.zanchenko.alexey.sfgDependencyInjetion.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello(){
        System.out.println("Hello World!!");
        return "What's up, buddy";
    }
}
