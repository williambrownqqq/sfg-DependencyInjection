package com.zanchenko.alexey.sfgDependencyInjetion.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
// get rid of bothe of these annotations(everything is in configuration class)
//@Primary //So that sets that up as the primary bean. The qualifier will take precedence over primary.
//// But when there isn't any situation where there is no qualifier, this is the situation that we want to control for.
//@Service
public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World from Primary Bean";
    }
}

//