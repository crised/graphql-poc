package com.udacity.graphql.service;

import com.udacity.graphql.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();
}
