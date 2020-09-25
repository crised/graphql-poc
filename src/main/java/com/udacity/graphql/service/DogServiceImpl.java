package com.udacity.graphql.service;

import com.udacity.graphql.model.Dog;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    private DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> findAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> findDogBreeds() {
        return dogRepository.findDogBreeds();
    }

    @Override
    public String findDogBreedById(Long id) {
        return dogRepository.findDogBreedById(id);
    }

    @Override
    public List<String> findAllDogNames() {
        return dogRepository.findAllDogNames();
    }
}
