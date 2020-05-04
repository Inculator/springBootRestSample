package com.mg.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping(value = "/hello")
    public Greetings helloWorld() {
        return new Greetings("Mohak", "Hello Mohak");
    }

}
