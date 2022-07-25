package com.hieu276.fleetms.parameters.controllers;

import com.hieu276.fleetms.parameters.models.Country;
import com.hieu276.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@Controller
public class CountryController {

    @Autowired private CountryService countryService;

    @GetMapping("/countries")
    public String  getAll(Model model, String keyword){
        List<Country> countries;
        countries = keyword == null? countryService.findAll():countryService.findByKeyword(keyword);
        model.addAttribute("countries", countries);
        return "/parameters/countries";
    }

    @GetMapping("/parameters/countries/{field}")
    public String  getAllWithSort(Model model, @PathVariable("field") String field, @PathParam("sortDir") String sortDir){
        List<Country> countries;
        countries = countryService.findAllWithSort(field,sortDir);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")? "desc":"asc");
        model.addAttribute("countries", countries);
        return "/parameters/countries";
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

    @RequestMapping(value="/countries/update/{id}",method = {RequestMethod.PUT, RequestMethod.GET} )
    public String update(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countryDetails/{id}")
    public String detailsCountry(@PathVariable Integer id,Model model){
        Country country = countryService.findById(id);
        model.addAttribute("country",country);
        return "parameters/countryDetails";
    }

    //The Get Country By Id
    @GetMapping("/parameters/country/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable Integer id){
        return countryService.findById(id);
    }

}
