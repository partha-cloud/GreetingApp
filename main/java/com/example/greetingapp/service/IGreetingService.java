package com.example.greetingapp.service;


import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {
    public Greeting addGreeting(User user);

    public List<Greeting> getGreetings();
    public Greeting findGreeting(long id);
    public Greeting updateGreeting(User user, long id);
    public void deleteGreetingById(long id);
}