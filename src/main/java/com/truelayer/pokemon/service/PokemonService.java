package com.truelayer.pokemon.service;

import com.truelayer.pokemon.beans.pokemon.Pokemon;
import com.truelayer.pokemon.beans.PokemonShakespeare;
import com.truelayer.pokemon.beans.shakespeare.ShakespeareTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${pokemon.description.url}")
    private String pokemonDescriptionUrl;
    @Value("${shakespeare.translation.url}")
    private String shakespeareTranslationUrl;

    private Pokemon getPokemonDetails(String name) throws Exception{
        return restTemplate.getForObject(pokemonDescriptionUrl, Pokemon.class,name);
    }
    private ShakespeareTranslation getPokemonShakespeareTranslation(String text) throws Exception{
        return restTemplate.getForObject(shakespeareTranslationUrl,ShakespeareTranslation.class, text);
    }
    public PokemonShakespeare getPokemonShakespeareDescription(String name) throws Exception{
        Pokemon pokemon = getPokemonDetails(name);
        ShakespeareTranslation translation = getPokemonShakespeareTranslation(pokemon.getInfo().getDescription());
        return new PokemonShakespeare(pokemon.getName(), translation.getContents().getTranslated());
    }
}