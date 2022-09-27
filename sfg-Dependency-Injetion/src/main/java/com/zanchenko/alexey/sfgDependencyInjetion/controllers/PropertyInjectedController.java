package com.zanchenko.alexey.sfgDependencyInjetion.controllers;

import com.zanchenko.alexey.sfgDependencyInjetion.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Qualifier("propertyInjectedGreetingService") // Now if I take this away I delete that and I run this again you'll see that we'll get the primary bean
    //injected into the constructor injected controller as well.
    @Autowired
    public GreetingService greetingService; // Spring is going to be able to find an instance of the greeting service and
    // execute properly

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}

// on the property injected controller, we have to tell Spring explicitly that we want Spring to go ahead and manage
//the injection of a greeting service.