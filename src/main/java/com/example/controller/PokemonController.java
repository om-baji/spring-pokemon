package com.example.controller;

import com.example.models.PokemonModel;
import com.example.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired PokemonService pokemonService;

    @GetMapping("/pokemons")
    public List<PokemonModel> getPokemons() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/pokemon/{id}")
    public<id> Optional<PokemonModel> getPokemonbyId(@PathVariable String id) {
        return pokemonService.getPokemonById(id);
    }

    @PostMapping("/pokemon")
    public PokemonModel postPokemon(@RequestBody PokemonModel pokemonModel) {
        return pokemonService.setPokemon(pokemonModel);
    }

    @GetMapping("/pokemon/byName")
    public PokemonModel getByName(@RequestParam String name) {
        return pokemonService.getPokemonByName(name);
    }

    @GetMapping("/pokemon/byType")
    public List<PokemonModel> getByType(@RequestParam String type) {
        return pokemonService.getPokemonByType(type);
    }

}
