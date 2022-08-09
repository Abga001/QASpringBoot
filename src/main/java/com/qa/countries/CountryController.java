package com.qa.countries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.websocket.server.PathParam;
import com.qa.countries.Country;

@RestController
public class CountryController {

	private List<Country> countries = List.of(new Country("Brazil", "Brasilia", 214000000));
	
	//public CountryController() {
	//super();
	//this.country = new ArrayList<>();
	//this.country.add(new Country("Brazil", 214000000));
	//}
	
	
	//@GetMapping("/getAll")
	//public List<Country> getAllCountries(){
		//return this.;
	//}
	

	@GetMapping("/get/{id}")
	public void findById(@PathVariable int id) {	
		System.out.println("ID: " + id);
	}

	@PostMapping("/createCountry")
	public void makeCountry(@RequestBody Country country) {
		 System.out.println("Body: " + country);
	}
	
	@PatchMapping("/update/{id}")
	public void updateCountry(@PathVariable int id, @PathParam("name") String name, @PathParam("capital") String capital, @PathParam("population") int population) {
		 System.out.println("COUNTRY: " + name);
	}
	
	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {	
		System.out.println("ID: " + id);
		
	}
	
	@GetMapping("/anthem")
	public String nationalAnthem() {
		return "Stand up for the national anthem";
	}
	
}