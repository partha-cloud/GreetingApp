package com.example.greetingapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.greetingapp.model.Greeting;
import org.springframework.stereotype.Repository;

    @Repository
    public interface GreetingRepository extends JpaRepository<Greeting, Long>{

    }

