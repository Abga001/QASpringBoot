package com.qa.countries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.countries.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}
