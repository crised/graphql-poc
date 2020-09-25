package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.model.Dog;
import com.udacity.graphql.model.Location;
import com.udacity.graphql.service.DogService;
import com.udacity.graphql.service.LocationService;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    // Fun fact: The implementation (not the interface) is injected
    private LocationService locationService;
    private DogService dogService;

    public Query(LocationService locationService, DogService dogService) {
        this.locationService = locationService;
        this.dogService = dogService;
    }

    public Iterable<Location> findAllLocations() {
        return locationService.retrieveLocations();
    }

    public List<Dog> findAllDogs(){return dogService.findAllDogs();}

    public Iterable<String> findDogBreeds() {
        return dogService.findDogBreeds();
    }

    public String findDogBreedById(Long id) {
        return dogService.findDogBreedById(id);
    }

    public Iterable<String> findAllDogNames(){
        return dogService.findAllDogNames();
    }


}
