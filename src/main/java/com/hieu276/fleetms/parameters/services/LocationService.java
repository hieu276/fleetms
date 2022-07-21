package com.hieu276.fleetms.parameters.services;

import com.hieu276.fleetms.parameters.models.Location;
import com.hieu276.fleetms.parameters.repositories.LocationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired private LocationRepositories locationRepository;

    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    public  void save(Location location){
        locationRepository.save(location);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    public  Location findById(Integer id){
        return locationRepository.findById(id).orElse(null);
    }

}
