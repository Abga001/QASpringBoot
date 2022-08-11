package com.qa.countries;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.countries.Country;
import com.qa.countries.CountryRepo;
import com.qa.countries.CountryService;

@SpringBootTest
@ActiveProfiles("test")
public class CountryServiceUnitTest {

	@Autowired
	private CountryService service;
	
	@MockBean
	private CountryRepo repo;
	
	@Test
	void testUpdate() {
		
		final int id = 1;

		final String name = "Japan";
		final String capital = "Tokyo";
		final int population = 65000000;
		
		
		Country expected = new Country(id, name, capital, population);
		
		assertEquals(null, this.service.updateCountry(1, "Japan","Tokyo", 65000000));
		Mockito.when(this.repo.findById(1)).thenReturn(Optional.of(new Country(1, "Japan", "Osaka", 70000000)));
		Mockito.when(this.repo.save(new Country(1, "Japan", "Tokyo", 65000000))).thenReturn(expected);
		Country actual = this.service.updateCountry(1, null, "Tokyo", 65000000);
		
		assertEquals(expected, actual);
	}
}
