package com.projeto.projeto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/recebimentodenotas")
    public String recebimentodenotas() {
        return "recebimentodenotas";
    }

    @GetMapping("/calcular")
    public String calcular(
            @RequestParam String nome,
            @RequestParam Double nota1,
            @RequestParam Double nota2,
            Model model) {

        model.addAttribute("nome", nome);
        model.addAttribute("nota1", nota1);
        model.addAttribute("nota2", nota2);

        double media = (nota1 + nota2) / 2;
        model.addAttribute("media", media);

        if (media >= 6.0) {
            return "notasboas";
        } else {
            return "notasruins";
        }
    }
}
