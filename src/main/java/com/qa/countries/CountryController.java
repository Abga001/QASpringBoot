package com.qa.countries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.countries.Country;
import com.qa.countries.CountryService;

@RestController

public class CountryController {

	private List<Country> countries = List.of(new Country("Brazil", "Brasilia", 214000000));
	
	//public CountryController() {
	//super();
	//this.Country = new ArrayList<>();
	//this.Country.add(new Country("Brazil", 214000000));
	//}
	
	private CountryService service;

	@Autowired
	public CountryController(CountryService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/getAll")
	public List<Country> getAllCountries(){
		return this.countries;
	}

	@GetMapping("/get/{id}")
	public void findById(@PathVariable int id) {	
		System.out.println("ID: " + id);
	}

	@PostMapping("/createCountry")
	public ResponseEntity<Country> makeCountry(@RequestBody Country country) {
		 System.out.println("Body: " + country);
		 return new ResponseEntity<Country>(this.service.makeCountry(country), HttpStatus.CREATED);
	}
	
	
	
	@PatchMapping("/update/{id}")
	public void updateCountry(@PathVariable int id, @PathParam("name") String name, @PathParam("capital") String capital, @PathParam("population") int population) {
		 System.out.println("COUNTRY: " + name);
	}
	
	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {	
		System.out.println("ID: " + id);
		
	}
	
}