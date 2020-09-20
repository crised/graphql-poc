package com.udacity.graphql.repository;

import com.udacity.graphql.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
