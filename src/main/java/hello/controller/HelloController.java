package hello.controller;

import hello.config.ApplicationConfig;
import hello.entity.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private ApplicationConfig config;

    @Autowired
    private UserRepository repository;

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/config/name")
    public String name() {
        return config.getName();
    }

    @RequestMapping("/config/email")
    public String email() {
        return config.getEmail();
    }

    @RequestMapping("/users")
    public Iterable<User> users() {
        return repository.findAll();
    }
}
