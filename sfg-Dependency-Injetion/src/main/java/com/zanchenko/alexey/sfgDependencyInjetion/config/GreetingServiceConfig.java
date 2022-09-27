package com.zanchenko.alexey.sfgDependencyInjetion.config;

import com.zanchenko.alexey.sfgDependencyInjetion.repositories.EnglishGreetingRepository;
import com.zanchenko.alexey.sfgDependencyInjetion.repositories.EnglishGreetingRepositoryImpl;
import com.zanchenko.alexey.sfgDependencyInjetion.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration // we're going to be doing a component scan to find this configuration class and this tells Spring
//Hey, look in this class, this is going to be a Spring configuration class.
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
    // propertyInjectedGreetingServiceFooBar baecome the name of the Bean inside SpringContext
    // But obviously, we don't want to do that. Good habit just to have the class name with the lowercase name
    //there.
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
    //So now we've defined three Spring Beans in our configuration class

    // So just to recap what I did on these three greeting services, I took these stereotype annotation off
    //of them.(@Service)
    //  I've removed the service annotations so that these are no longer
    //Spring managed components.
    //We're not declaring that via annotations.
    //Rather, we've introduced a new configuration class annotated top level class annotation @configuration
    //and then each bean, we are defining three different Spring Beans here with the @bean annotation.
    //And just to reiterate the beans in the Spring Context, get their name from the method name.
    //И просто чтобы повторить bean-компоненты в контексте Spring, получите их имя из имени метода.

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    // we have removed annotations from the classes

    @Profile("EN")
    @Bean
    I18EnglishGreetingService I18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18EnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean("I18nService") // declare the bean name
    I18SpanishGreetingService i18SpanishGreetingService(){
        return new I18SpanishGreetingService();
    }
    // So, you know, I want to reiterate, by default, Spring is going to use the method name unless you
    //override it.
    //So on line 53 there, by passing a string into the bean annotation, I am overriding that and giving
    //that bean a specific name.
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
}
