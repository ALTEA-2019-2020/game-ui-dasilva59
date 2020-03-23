package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeServiceImpl;
import com.miage.altea.game_ui.pokemonTypes.service.TrainerService;
import com.miage.altea.game_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;
    @Autowired
    PokemonTypeServiceImpl pokemonTypeService;


    public void setPokemonTypeService(TrainerService p) {
        this.trainerService = p;
    }

    @GetMapping("/trainers")
    public ModelAndView trainer() {
        List<Trainer> train = trainerService.listTrainer();
        for(Trainer t : train)
            t.setTeamType(pokemonTypeService.listPokemon(t));
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainer",train );
            return modelAndView;
    }

    @GetMapping(value="/trainers/{name}")
    public ModelAndView trainerByName(@PathVariable String name) {
        Trainer t=trainerService.trainer(name);
        t.setTeamType(pokemonTypeService.listPokemon(t));
        var modelAndView = new ModelAndView("trainerSolo");
        modelAndView.addObject("trainerSolo", t);
        return modelAndView;

    }
    @GetMapping(value="/profile")
    public ModelAndView getProfile() {
        var modelAndView = new ModelAndView("trainerSolo");
        UserDetails t=  (UserDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Trainer tt=trainerService.trainer(t.getUsername());
        tt.setTeamType(pokemonTypeService.listPokemon(tt));
        modelAndView.addObject("trainerSolo",tt);
        return modelAndView;
    }
}
