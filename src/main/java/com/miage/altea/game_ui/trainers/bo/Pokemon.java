package com.miage.altea.game_ui.trainers.bo;


public class Pokemon {

    private int pokemonTypeId;

    private int level;


    public Pokemon() {
    }


    public Pokemon(int pokemonTypeId, int level, String name) {
        this.pokemonTypeId = pokemonTypeId;
        this.level = level;

    }

    public int getPokemonTypeId() {
        return pokemonTypeId;
    }

    public void setPokemonTypeId(int pokemonTypeId) {
        this.pokemonTypeId = pokemonTypeId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
