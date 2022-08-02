package com.zanchenko.alexey.sfgDependencyInjetion.services;

import org.springframework.stereotype.Service;

@Service // so npw by annotating that as a service, Spring knows to bring an instance of this into its context
public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor ";
    }
}

// @Service tells Spring that this is a Spring managed component and bring it into the Spring Context
// we are never actually askig for that, for an instance of that in main class. but we added in to where
// we are calling on the context to give us a bean  of property injected controller, the setter injected controller and
// the constructor injected controller
