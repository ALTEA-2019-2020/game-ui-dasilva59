package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.game_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    public void setPokemonTypeService(TrainerService p) {
        this.trainerService = p;
    }

    @GetMapping("/trainers")
    public ModelAndView trainer() {
        var modelAndView = new ModelAndView("trainer");
        modelAndView.addObject("trainer", trainerService.listTrainer());
            return modelAndView;
    }

    @GetMapping(value="/trainers/{name}")
    public ModelAndView trainerByName(@PathVariable String name) {
        var modelAndView = new ModelAndView("trainerSolo");
        modelAndView.addObject("trainerSolo", trainerService.trainer(name));
        return modelAndView;

    }
}
