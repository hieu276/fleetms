package com.hieu276.fleetms.parameters.services;

import com.hieu276.fleetms.parameters.models.State;
import com.hieu276.fleetms.parameters.repositories.StateRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired private StateRepositories stateRepository;

    public List<State> findAll(){
        return stateRepository.findAll();
    }

    public  void save(State State){
        stateRepository.save(State);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }

    public  State findById(Integer id){
        return stateRepository.findById(id).orElse(null);
    }

}
