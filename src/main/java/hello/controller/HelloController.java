package hello.controller;

import hello.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ApplicationConfig config;

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
}
