package com.zanchenko.alexey.sfgDependencyInjetion.services;

import com.zanchenko.alexey.sfgDependencyInjetion.repositories.EnglishGreetingRepository;

//@Profile("EN")
//@Service("I18nService")
public class I18EnglishGreetingService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18EnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return this.englishGreetingRepository.getGreeting(); // method take data from repository
//        return "Hello - EN";
    }
}
