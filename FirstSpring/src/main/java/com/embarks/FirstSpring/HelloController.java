package com.embarks.FirstSpring;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "hello "+name+"!";
    }
}
