package com.truelayer.pokemon.controller;

import com.truelayer.pokemon.beans.PokemonShakespeare;
import com.truelayer.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PokemonController {
    @Autowired
    private PokemonService service;
    @GetMapping("/pokemon/{name}")
    public PokemonShakespeare getShakespeareanDesc(@PathVariable("name") String name) throws Exception{
        return service.getPokemonShakespeareDescription(name);
    }
}
