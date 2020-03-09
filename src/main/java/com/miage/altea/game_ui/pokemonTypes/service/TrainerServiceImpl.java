package com.miage.altea.game_ui.pokemonTypes.service;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class TrainerServiceImpl implements TrainerService {

    RestTemplate restTemplate;
    String url;

        @Autowired
        @Qualifier("trainerApiRestTemplate")
        void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;

        }

        @Value("${trainerType.service.url}")
        void setTrainerTypeServiceUrl(String pokemonServiceUrl) {
            this.url=pokemonServiceUrl;

        }

    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(restTemplate.getForObject(
                this.url+"/trainers/", Trainer[].class));
    }

    @Override
    public Trainer trainer(String name) {
        return restTemplate.getForObject(this.url+"/trainers/"+name, Trainer.class);
    }
}

