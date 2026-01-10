package com.example.magazin.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homepage(Model model) {

        model.addAttribute("numeClient", "Flavius");

        model.addAttribute("mesaj", "EXAMEN asd");

        return "home";
    }

    @GetMapping("/health")
    @ResponseBody
    public String healthCheck() {
        return "REST controller working";
    }
}
