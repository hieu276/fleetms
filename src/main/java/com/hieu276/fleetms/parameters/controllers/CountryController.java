package com.hieu276.fleetms.parameters.controllers;

import com.hieu276.fleetms.parameters.models.Country;
import com.hieu276.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@Controller
public class CountryController {

    @Autowired private CountryService countryService;

//    @GetMapping("/countries")
//    public String  getAll(Model model, String keyword){
//        List<Country> countries;
//        countries = keyword == null? countryService.findAll():countryService.findByKeyword(keyword);
//        model.addAttribute("countries", countries);
//        return "/parameters/countries";
//    }

    @GetMapping("/parameters/countries")
    public String getAllPages(Model model){
        return getOnePage(model, 1);
    }

    @GetMapping("/parameters/countries/page/{pageNumber}/{field}")
    public String getPageWithSort(Model model,
                                  @PathVariable("pageNumber") int currentPage,
                                  @PathVariable String field,
                                  @PathParam("sortDir") String sortDir){

        Page<Country> page = countryService.findAllWithSort(field, sortDir, currentPage);
        List<Country> countries = page.getContent();
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
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
        return "redirect:/parameters/countries";
    }

    @RequestMapping(value="/countries/delete",method = {RequestMethod.GET, RequestMethod.DELETE} )
    public String delete(Integer id){
        countryService.delete(id);
        return "redirect:/parameters/countries";
    }

    @RequestMapping(value="/countries/update/{id}",method = {RequestMethod.PUT, RequestMethod.GET} )
    public String update(Country country){
        countryService.save(country);
        return "redirect:parameters/countries";
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

    @GetMapping("/parameters/countries/page/{pageNumber}")
    public String  getOnePage(Model model, @PathVariable("pageNumber") int currentPage){
        Page<Country> page = countryService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Country> countries = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("countries", countries);

        return "/parameters/countries";
    }
}
