package com.zanchenko.alexey.sfgDependencyInjetion.controllers;

import com.zanchenko.alexey.sfgDependencyInjetion.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
    PropertyInjectedController controller;
    @BeforeEach // i am setting ip the test conditions
    void setUp(){
        controller = new PropertyInjectedController();

        controller.greetingService = new ConstructorGreetingService();
    }
    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}