package fi.softala.vote.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainCtrl {

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

}