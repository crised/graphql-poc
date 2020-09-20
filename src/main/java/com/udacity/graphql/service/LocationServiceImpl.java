package com.udacity.graphql.service;

import com.udacity.graphql.model.Location;
import com.udacity.graphql.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> retrieveLocations(){
        return (List<Location>) locationRepository.findAll();
    }

}
