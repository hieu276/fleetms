package com.hieu276.fleetms.parameters.services;

import com.hieu276.fleetms.parameters.models.Country;
import com.hieu276.fleetms.parameters.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired private CountryRepositories countryRepository;

    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    public  void save(Country country){
        countryRepository.save(country);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

    public  Country findById(Integer id){
        return countryRepository.findById(id).orElse(null);
    }

}
