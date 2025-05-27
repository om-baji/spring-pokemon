package com.example.controller;

import com.example.models.PokemonModel;
import com.example.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired PokemonService pokemonService;

    @GetMapping("/pokemons")
    public List<PokemonModel> getPokemons() {
        return pokemonService.getAllPokemon();
    }


}
