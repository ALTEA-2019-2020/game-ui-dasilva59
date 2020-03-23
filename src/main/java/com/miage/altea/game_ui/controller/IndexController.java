package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.service.TrainerService;
import com.miage.altea.game_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    TrainerService trainerService;

    @GetMapping("/")
    public ModelAndView index(){
        var modelAndView = new ModelAndView("index");
        UserDetails t=  (UserDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Trainer tt=trainerService.trainer(t.getUsername());
        modelAndView.addObject("name",tt);
        return modelAndView;
    }


    @PostMapping("/registerTrainer")
    ModelAndView registerNewTrainer( String trainerName){
        var modelAndView = new ModelAndView("register");
        modelAndView.addObject("name",trainerName);
        return modelAndView;
    }

}
