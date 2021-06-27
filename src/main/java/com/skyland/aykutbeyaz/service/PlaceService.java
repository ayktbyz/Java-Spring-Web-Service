package com.skyland.aykutbeyaz.service;

import com.skyland.aykutbeyaz.entity.Place;
import com.skyland.aykutbeyaz.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository repo;

    public List<Place> getFullList(){
        return repo.findAll();
    }

    public List<Place> getByNameFullList(String name){
        return repo.findByName(name);
    }

    public List<Place> getByCountryIdFullList(int id){
        return repo.findByCountryid(id);
    }

    public Place get(int id){
        return repo.findById(id).get();
    }

    public void save(Place place){
         repo.save(place);
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
