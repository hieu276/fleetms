package com.hieu276.fleetms.parameters.services;

import com.hieu276.fleetms.parameters.models.Country;
import com.hieu276.fleetms.parameters.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepositories countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

    public Country findById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }

    public List<Country> findByKeyword(String keyword) {
        return countryRepository.findByKeyword(keyword);
    }

//    public Page<Country> findAllWithSort(String field, String direction, int pageNumber) {
//        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
//                Sort.by(field).ascending() : Sort.by(field).descending();
//
//        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
//
//        return countryRepository.findAll(pageable);
//    }

    public Page<Country> findAllWithSort(String field, String direction,int pageNum) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(field).ascending() : Sort.by(field).descending();
        Pageable pageable = PageRequest.of(pageNum - 1,5,sort);
        return countryRepository.findAll(pageable);
    }

    public Page<Country> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1,5);
        return countryRepository.findAll(pageable);
    }


}
