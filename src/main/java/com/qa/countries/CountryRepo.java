package com.qa.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.countries.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

}
