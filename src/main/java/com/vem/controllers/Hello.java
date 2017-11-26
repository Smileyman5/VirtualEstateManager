package com.vem.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 11/25/2017.
 */
@RestController
public class Hello {

    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi!";
    }

}
