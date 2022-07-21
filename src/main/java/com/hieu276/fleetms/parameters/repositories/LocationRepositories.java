package com.hieu276.fleetms.parameters.repositories;

import com.hieu276.fleetms.parameters.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositories extends JpaRepository<Location, Integer> {
}
