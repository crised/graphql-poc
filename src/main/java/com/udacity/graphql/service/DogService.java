package com.udacity.graphql.service;

import com.udacity.graphql.model.Dog;

import java.util.List;


/*
Currently implementing only READ/SELECT
queries.
 */
public interface DogService {

    List<Dog> findAllDogs();
    List<String> findDogBreeds();
    String findDogBreedById(Long id);
    List<String> findAllDogNames();

}
