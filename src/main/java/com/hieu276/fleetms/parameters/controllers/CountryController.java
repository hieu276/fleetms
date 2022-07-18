package com.hieu276.fleetms.parameters.controllers;

import com.hieu276.fleetms.parameters.models.Country;
import com.hieu276.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class CountryController {

    @Autowired private CountryService countryService;

    @GetMapping("/countries")
    public String  findAll(Model model){
        List<Country> countriesList = countryService.findAll();
        model.addAttribute("countries", countriesList);
        return "parameters/countries";
    }

    @GetMapping("/countryAdd")
    public String addCountry(){
        return "parameters/countryAdd";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry(@PathVariable Integer id,Model model){
        Country country = countryService.findById(id);
        model.addAttribute("country",country);
        return "parameters/countryEdit";
    }

    @GetMapping("/countryEdit2")
    public String editCountry2(Integer id,Model model){
        Country country = countryService.findById(id);
        model.addAttribute("country",country);
        return "parameters/countryEdit";
    }

    @PostMapping("/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value="/countries/delete",method = {RequestMethod.GET, RequestMethod.DELETE} )
    public String delete(Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }


}
