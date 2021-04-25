package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

    @Service
    public class GreetingService implements IGreetingService{
        private static final String template = "Hello, %s !";
        private final AtomicLong counter = new AtomicLong();

        @Autowired
        private GreetingRepository greetingRepository;

        public Greeting addGreeting(User user) {
            String message = String.format(template, (user.getFirstName().isEmpty()) ? "Hello World" : user.getFirstName());
            return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
        }

        public List<Greeting> getGreetings(){
            return greetingRepository.findAll();

        }

    }