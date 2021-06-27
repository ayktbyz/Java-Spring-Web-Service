package com.skyland.aykutbeyaz.repository;

import com.skyland.aykutbeyaz.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
