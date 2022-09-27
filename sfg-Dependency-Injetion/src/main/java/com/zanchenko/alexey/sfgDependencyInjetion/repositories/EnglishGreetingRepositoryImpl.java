package com.zanchenko.alexey.sfgDependencyInjetion.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

    @Override
    public String getGreeting() {
        return "Hello - EN - repository implementtion";
    }
}
