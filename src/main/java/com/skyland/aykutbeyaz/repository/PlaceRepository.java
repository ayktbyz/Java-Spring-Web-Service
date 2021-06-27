package com.skyland.aykutbeyaz.repository;

import com.skyland.aykutbeyaz.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaceRepository extends JpaRepository<Place,Integer> {
    List<Place> findByName(String name);
    List<Place> findByCountryid(int countryid);

}
