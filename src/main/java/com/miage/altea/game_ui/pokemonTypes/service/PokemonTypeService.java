package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.trainers.bo.Trainer;

import java.util.List;

public interface  PokemonTypeService {

    List<PokemonType> listPokemonsTypes();
    List<PokemonType> listPokemon(Trainer t);
    PokemonType getPokemonType(int id);

}
