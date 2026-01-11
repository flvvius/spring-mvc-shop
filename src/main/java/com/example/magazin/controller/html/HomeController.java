package com.example.magazin.controller.html;

import com.example.magazin.dto.ComandaDto;
import com.example.magazin.entity.enums.Stare;
import com.example.magazin.service.ComandaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final ComandaService comandaService;

    public HomeController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping()
    public String index(@RequestParam(required = false)Stare stareFiltru, Model model) {

        List<ComandaDto> comenzi = comandaService.getToateComenzile(stareFiltru);

        model.addAttribute("listaComenzi", comenzi);

        model.addAttribute("toateStarile", Stare.values());

        model.addAttribute("stareSelectata", stareFiltru);

        return "index";
    }

    @PostMapping("/schimba-stare/{id}")
    public String schimbaStare(@PathVariable Long id, @RequestParam Stare stareNoua) {
        comandaService.modificaStare(id, stareNoua);
        return "redirect:/home";
    }

    @PostMapping("/anuleaza/{id}")
    public String anuleaza(@PathVariable Long id) {
        comandaService.anuleazaComanda(id);
        return "redirect:/home";
    }

}
