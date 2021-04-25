package com.example.greetingapp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String message;
    private long gId;
    @javax.persistence.Id
    @GeneratedValue
    private Long id;

    public Greeting() {	   }

    public Greeting(long gId, String message) {
        this.gId = gId;
        this.message = message;
    }

    public long getgId() {
        return gId;
    }
    public String getMessage() {
        return message;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}