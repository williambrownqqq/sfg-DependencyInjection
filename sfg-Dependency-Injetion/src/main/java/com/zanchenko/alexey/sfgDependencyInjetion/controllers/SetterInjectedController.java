package com.zanchenko.alexey.sfgDependencyInjetion.controllers;

import com.zanchenko.alexey.sfgDependencyInjetion.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    public String getGreetingService() {
        return greetingService.sayGreeting();
    }
    @Qualifier("setterInjectedGreetingService")
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}

// on the setter injected controller, we have to tell Spring explicitly that we want the setter to be used for that dependency