package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {


    @GetMapping("/greeting/")
    public Greeting greetingForName(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName == null && lastName == null) {
            return new Greeting(counter.incrementAndGet(), String.format(template, "World"));
        }
        if (firstName == null) {
            return new Greeting(counter.incrementAndGet(), String.format(template, lastName));
        }
        if (lastName == null) {
            return new Greeting(counter.incrementAndGet(), String.format(template, firstName));
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
    }


    private static final String template = "Hello, %s !!!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/addgreeting")
    public Greeting addGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping(" ")
    public String blankGreeting() {
        return "Hello Stranger!!!";
    }

    @Autowired
    public IGreetingService greetingService;

    @GetMapping("/allgreetings")
    public ResponseEntity<List<Greeting>> allGreetings() {
        List<Greeting> messageList = greetingService.getGreetings();
        return new ResponseEntity<>(messageList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findgreeting/{id}")
    public Greeting findGreeting(@PathVariable(name = "id") long id) {
        return greetingService.findGreeting(id);

    }
    @PutMapping("editgreeting/{id}")
    public Greeting editGreeting(@RequestBody User user, @PathVariable(name = "id") long id) {
        Greeting greeting = greetingService.findGreeting(id);
        if(greeting == null) {
            return null;
        }
        user.setFirstName(user.getFirstName());
        return greetingService.updateGreeting(user, id);
    }
    @DeleteMapping("/deletegreeting/{id}")
    public void deleteGreeting(@PathVariable(name = "id") long id) {
        greetingService.deleteGreetingById(id);
    }
}