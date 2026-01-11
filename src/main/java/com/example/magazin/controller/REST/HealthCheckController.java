package com.example.magazin.controller.REST;

import com.example.magazin.service.ComandaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping()
    public String healthCheck() {
        return "Spring app working!";
    }

}
