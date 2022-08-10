package com.qa.countries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.countries.Country;

@Service
@Primary
public class CountryServiceList implements CountryService {

	private List<Country> countries;
	
	public CountryServiceList() {
		super();
		this.countries = new ArrayList<>();
		this.countries.add(new Country("France", "Paris", 80000000));
		
	}
	
	
	@Override
	public Country makeCountry(Country country) {
		return null;	
	}

	@Override
	public List<Country> getAllCountries() {
		return this.countries;
	}

	@Override
	public Country getById(int id) {
		return this.countries.get(id);
	}

	@Override
	public Country updateCountry(int id, String name, String capital, Integer population) {
		Country toUpdate = this.getById(id);

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (capital != null)
			toUpdate.setCapital(capital);
		if (population != null)
			toUpdate.setPopulation(population);

		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.countries.remove(id);

	}
	


}
