package com.miage.altea.game_ui.pokemonTypes.service;


import com.miage.altea.game_ui.trainers.bo.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> listTrainer();
    Trainer trainer(String name);
}