package com.zanchenko.alexey.sfgDependencyInjetion.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile({"ES", "default"})
////@Profile("ES") // error
//@Service("I18nService")
public class I18SpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}


//So that is how you use the default profile. You just specify that Spring component is part of the default
//profile. When there is no active profile set, that bean will get picked up and used by the Spring
//context.