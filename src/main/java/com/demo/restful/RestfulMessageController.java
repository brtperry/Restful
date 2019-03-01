package com.demo.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestfulMessageController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Call using this url http://localhost:8080/message?name=Brett
     * @param name
     * @return
     */
    @RequestMapping("/message")
    public Message getMessage(@RequestParam(value="name", defaultValue="World") String name) {
        return new Message(counter.incrementAndGet(), String.format(template, name));
    }
}
