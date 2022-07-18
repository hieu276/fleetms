package com.hieu276.fleetms.parameters.repositories;

import com.hieu276.fleetms.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositories extends JpaRepository<Country, Integer> {
}
