package com.example.magazin.controller.REST;

import com.example.magazin.service.ComandaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/comenzi")
public class ComandaController {

    ComandaService comandaService;


}
