package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
    private final NameService nameService;

    public WelcomeController(NameService nameService){
        this.nameService = nameService;
    }

    @GetMapping("/")
    public String loadIndex(Model model){
        model.addAttribute("name", "");
        return "hallo";
    }

    @GetMapping("/{name}")
    public String index(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "hallo";
    }

    @PostMapping("/name")
    public String name(Name name){
        nameService.addName(name);
        return "redirect:/" + name.getName();
    }
}
