package com.hieu276.fleetms.parameters.controllers;

import com.hieu276.fleetms.parameters.models.Location;
import com.hieu276.fleetms.parameters.services.CountryService;
import com.hieu276.fleetms.parameters.services.LocationService;
import com.hieu276.fleetms.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {

    @Autowired private LocationService locationService;

    @Autowired private CountryService countryService;

    @Autowired private StateService stateService;

    public  Model addModelAttribute(Model model){
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/locations")
    public String  findAll(Model model){
        addModelAttribute(model);
        return "parameters/locations";
    }

    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model){
        addModelAttribute(model);
        return "parameters/locationAdd";
    }

    @GetMapping("/parameters/location/{op}/{id}")
    public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("location", locationService.findById(id));
        return "/parameters/location" + op;
    }

    //Add Location
    @PostMapping(value="/parameters/locations")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    @RequestMapping(value="/parameters/location/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        locationService.delete(id);
        return "redirect:/parameters/locations";
    }
}
