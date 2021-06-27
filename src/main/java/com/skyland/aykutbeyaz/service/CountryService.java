package com.skyland.aykutbeyaz.service;

import com.skyland.aykutbeyaz.entity.Country;
import com.skyland.aykutbeyaz.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repo;

    public List<Country>  getFullList(){
        return repo.findAll();
    }

    public Country get(int id){
        return repo.findById(id).get();
    }

    public void save(Country country){
        repo.save(country);
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
