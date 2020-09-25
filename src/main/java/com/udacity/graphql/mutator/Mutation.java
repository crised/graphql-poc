package com.udacity.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphql.exception.DogNotFoundException;
import com.udacity.graphql.exception.LocationNotFoundException;
import com.udacity.graphql.model.Dog;
import com.udacity.graphql.model.Location;
import com.udacity.graphql.repository.DogRepository;
import com.udacity.graphql.repository.LocationRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    /*
    Avoid using repository directly!
    A service should be used instead.
     */
    private LocationRepository locationRepository;
    private DogRepository dogRepository;

    public Mutation(LocationRepository locationRepository, DogRepository dogRepository) {
        this.locationRepository = locationRepository;
        this.dogRepository = dogRepository;
    }

    public Location newLocation(String name, String address) {
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public Location updateLocationName(String newName, Long id) {
        Optional<Location> optionalLocation =
                locationRepository.findById(id);
        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setName(newName);
            locationRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Location Not Found", id);
        }
    }

    public boolean deleteLocation(Long id) {
        if (locationRepository.existsById(id)){
            locationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Dog updateDogName(Long id, String newName){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;

        } else throw new DogNotFoundException("DogN Not Found", id);
    }


}
