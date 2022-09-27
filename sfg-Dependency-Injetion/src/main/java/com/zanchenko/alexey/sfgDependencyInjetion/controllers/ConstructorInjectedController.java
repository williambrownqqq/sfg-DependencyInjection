package com.zanchenko.alexey.sfgDependencyInjetion.controllers;

import com.zanchenko.alexey.sfgDependencyInjetion.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private final GreetingService greetingService;
    //@Autowired // The autowired annotation on the constructor that is optional.
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    // Now if I take this away I delete that and I run this again you'll see that we'll get the primary bean
    //injected into the constructor injected controller as well.

    public String getGreetingService() {
        return greetingService.sayGreeting();
    }


}
//And then finally on the constructor, since that constructor is only way to instantiate this, we don't
//
//have to tell Spring explicitly to utilize the constructor. Here it's automatically going to autowire.
//
//So we don't have to provide the autowire annotation.