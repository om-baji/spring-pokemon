package com.example.repository;

import com.example.models.PokemonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<PokemonModel, String> {

    List<PokemonModel> findAll();

    PokemonModel findByName(String name);

    Optional<PokemonModel> findById(String id);

    List<PokemonModel> findByTypesContaining(String type);
}
