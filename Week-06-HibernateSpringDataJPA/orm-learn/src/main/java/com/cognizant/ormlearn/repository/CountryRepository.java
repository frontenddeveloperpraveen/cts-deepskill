package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // Method to find a list of countries matching partial country name, sorted by name
    List<Country> findByNameContainingOrderByNameAsc(String name);
}
