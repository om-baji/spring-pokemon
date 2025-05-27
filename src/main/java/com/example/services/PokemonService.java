package com.example.services;

import com.example.models.PokemonModel;
import com.example.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired PokemonRepository pokemonRepository;

    public List<PokemonModel> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Optional<PokemonModel> getPokemonById(String id) {
        return pokemonRepository.findById(id);
    }

    public PokemonModel getPokemonByName(String name) {
        return pokemonRepository.findByName(name);
    }

    public List<PokemonModel> getPokemonByType(String type) {
        return pokemonRepository.findByTypesContaining(type);
    }

    public PokemonModel setPokemon(PokemonModel pokemonModel) {
        pokemonRepository.save(pokemonModel);

        return pokemonModel;
    }
}
