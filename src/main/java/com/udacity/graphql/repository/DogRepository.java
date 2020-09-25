package com.udacity.graphql.repository;

import com.udacity.graphql.model.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query(value = "SELECT d.breed FROM dog d", nativeQuery = true)
    List<String> findDogBreeds();

    @Query(value = "SELECT d.id, d.breed FROM dog d WHERE d.id = :id", nativeQuery = true)
    String findDogBreedById(Long id);

    @Query(value = "SELECT d.name FROM dog d", nativeQuery = true)
    List<String> findAllDogNames();

    @Query(value = "UPDATE dog d SET d.name = :newName WHERE d.id = :id", nativeQuery = true)
    Dog updateDogName(Long id, String newName);

    @Query(value = "DELETE FROM dog d WHERE d.breed = :breed", nativeQuery = true)
    void deleteDogBreed(String breed);

}
