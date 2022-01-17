package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecretController {
    @GetMapping("/zoo.html")
    public String secretPage() {
        return "zoo";
    }
}