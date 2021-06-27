package com.skyland.aykutbeyaz.controller;

import com.skyland.aykutbeyaz.entity.Country;
import com.skyland.aykutbeyaz.entity.Place;
import com.skyland.aykutbeyaz.service.CountryService;
import com.skyland.aykutbeyaz.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;
    @Autowired
    private PlaceService serviceTwo;

    @GetMapping("/countrys")
    public List<Country> list(){
      return service.getFullList();
    }

    @GetMapping("/country/{id}")
    public Country get(@PathVariable int id){
     return service.get(id);
    }

    @GetMapping("/removeCountry/{id}")
    public String delete(@PathVariable int id){
        try {
            Country country = service.get(id);
            List<Place> placeList = serviceTwo.getByCountryIdFullList(country.getId());
            for (Place var : placeList){
                serviceTwo.delete(var.getId());
            }
            service.delete(id);
            return "Ülke Silindi. Silinen Ülke : " + country.getName();
        }
        catch (Exception ex){
            return "Ülke Silinmedi. Hata: " + ex.getMessage();
        }
    }

    @GetMapping("/createCountry")
    public String createCountry(@RequestParam(value="name") String name){
        try {
            Country country = new Country();
            country.setName(name);
            service.save(country);
            return "Ülke Eklendi. Eklenen Ülke : " + name;
        }
        catch (Exception ex){
            return "Ülke Eklenmedi. Hata: " + ex.getMessage();
        }
    }

}
