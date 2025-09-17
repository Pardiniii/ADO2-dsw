package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @GetMapping("/index")
    public String exibirFormulario(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/carros")
    public String salvarCarro(@Valid CarDTO carDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        System.out.println("Carro validado com sucesso: " + carDTO.getName() + ", " + carDTO.getColor());

        return "redirect:/sucesso";
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }

}