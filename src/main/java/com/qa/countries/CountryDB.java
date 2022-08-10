package com.qa.countries;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.qa.countries.Country;
import com.qa.countries.CountryRepo;


@Service
@Primary
public class CountryDB implements CountryService {

	
	private CountryRepo repo;
	
	public CountryDB(CountryRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	@Override
	public Country makeCountry(Country country) {
		return null;	
	}

	@Override
	public List<Country> getAllCountries() {
		return this.repo.findAll();
	}

	@Override
	public Country getById(int id) {
		return this.repo.findById(id).get();
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

		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);

	}
	

}