package com.qa.countries;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.countries.Country;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerIntTest {
	
@Autowired
private MockMvc mvc;

@Autowired
private ObjectMapper mapper;

@Test
void testCreate() throws Exception {
	Country testCountry = new Country("Egypt", "Cairo", 30000000);
	RequestBuilder req = post("/createCountry").content(this.mapper.writeValueAsString(testCountry))
			.contentType(MediaType.APPLICATION_JSON);
	
	ResultMatcher checkStatus = status().isCreated();
	Country testSavedCountry = new Country("Egypt", "Cairo", 30000000);
	ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedCountry));
	
	this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}

@Test
void testCreateButHardToRead() throws Exception {
	this.mvc.perform(
			post("/createCountry").content(this.mapper.writeValueAsString(new Country("Egypt", "Cairo", 30000000)))
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(this.mapper.writeValueAsString(new Country("Egypt", "Cairo", 30000000))));
}
}
