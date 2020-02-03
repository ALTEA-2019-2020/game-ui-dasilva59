package com.miage.altea.game_ui.pokemonTypes.service;
import com.miage.altea.game_ui.config.RestConfiguration;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    RestTemplate restTemplate;
    String url;



        public List<PokemonType> listPokemonsTypes() {
      return Arrays.asList(restTemplate.getForObject(
             this.url+"/pokemon-types/", PokemonType[].class));
        }

        @Autowired
        void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;

        }

        @Value("${pokemonType.service.url}")
        void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
            this.url=pokemonServiceUrl;

        }
    }

