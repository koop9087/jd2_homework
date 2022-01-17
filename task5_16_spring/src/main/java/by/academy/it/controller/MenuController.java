package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping({"/", "/index.html"})
    public String homePage() {
        return "index";
    }
}