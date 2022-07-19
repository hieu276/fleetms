package com.hieu276.fleetms.parameters.controllers;

import com.hieu276.fleetms.parameters.models.Country;
import com.hieu276.fleetms.parameters.models.State;
import com.hieu276.fleetms.parameters.services.CountryService;
import com.hieu276.fleetms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired private StateService stateService;

    @Autowired private CountryService countryService;

    public  Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return model;
    }

    @GetMapping("/parameters/states")
    public String  findAll(Model model){
        addModelAttribute(model);
        return "parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }
//
//    @GetMapping("/stateEdit/{id}")
//    public String stateEdit(@PathVariable Integer id,Model model){
//        State state = stateService.findById(id);
//        List<Country> country = countryService.findAll();
//        model.addAttribute("state", state);
//        model.addAttribute("countries", country);
//        return "parameters/stateEdit";
//    }
//
//    @GetMapping("/stateDetails/{id}")
//    public String stateDetails(@PathVariable Integer id,Model model){
//        State state = stateService.findById(id);
//        List<Country> country = countryService.findAll();
//        model.addAttribute("state", state);
//        model.addAttribute("countries", country);
//        return "parameters/stateDetails";
//    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.findById(id));
        return "/parameters/state" + op;
    }

    //Add State
    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value="/states/delete/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete2(Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }
}
