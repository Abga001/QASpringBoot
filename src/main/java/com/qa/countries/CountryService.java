package com.qa.countries;

import java.util.List;

import com.qa.countries.Country;

public interface CountryService {
	
	Country getById(int id);
	
	List<Country> getAllCountries();

	
	Country makeCountry(Country country);
	
	Country updateCountry(int id, String name, String capital, Integer population);
	
	void delete(int id);

}
