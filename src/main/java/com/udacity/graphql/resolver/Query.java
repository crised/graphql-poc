package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.model.Location;
import com.udacity.graphql.service.LocationService;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private LocationService locationService;

    public Query(LocationService locationService) {
        this.locationService = locationService;
    }

    public Iterable<Location> findAllLocations() {
        return locationService.retrieveLocations();
    }

}
