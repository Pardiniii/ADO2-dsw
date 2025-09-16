package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CarServiceImpl service;

    public HomeController(CarServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(@Valid CarDTO carDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("carDTO", carDTO);
            return "index";
        }

        service.save(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<CarDTO> allCars = service.findAll();
        model.addAttribute("cars", allCars);
        System.out.println("Carros carregados: " + allCars.size());
        return "dashboard";
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/cars/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        CarDTO car = service.findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        model.addAttribute("carDTO", car);
        return "index";
    }
}