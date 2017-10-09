package com.mvc.controller;

import com.mvc.entity.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Spencer.hong on 2017/6/16.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        File file  = new File("C:/RHDSetup.log");
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name)+"path exist: " + file.exists());
    }
}
