package com.skyland.aykutbeyaz.controller;

import com.skyland.aykutbeyaz.entity.Place;
import com.skyland.aykutbeyaz.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {

    @Autowired
    private PlaceService service;

    @GetMapping("/places")
    public List<Place> list(){
        return service.getFullList();
    }

    @GetMapping("/place/{id}")
    public Place get(@PathVariable int id){
        return service.get(id);
    }

    @GetMapping("/removePlace/{id}")
    public String delete(@PathVariable int id){
        try {
            Place place = service.get(id);
            service.delete(id);
            return "Şehir Silindi. Silinen Şehir : " + place.getName();
        }
        catch (Exception ex){
            return "Şehir Silinmedi. Hata: " + ex.getMessage();
        }
    }

    @GetMapping("/listPlaces/{name}")
    public List<Place> getByNamePlaceList(@PathVariable String name){
        return service.getByNameFullList(name);
    }

    @GetMapping("/getListPlaces/{id}")
    public List<Place> getByIdPlaceList(@PathVariable int id){
        return service.getByCountryIdFullList(id);
    }

}
