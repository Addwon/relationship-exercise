package com.example.relationshipexercise;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<Country,Long> {
    Country findByCountryname(String countryname);
}
