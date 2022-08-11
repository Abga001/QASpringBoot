package com.qa.countries;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.countries.Country;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:country-schema.sql",
"classpath:country-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CountryControllerIntTest {
	
@Autowired
private MockMvc mvc;

@Autowired
private ObjectMapper mapper;

@Test
void testCreate() throws Exception {
	Country testCountry = new Country(1, "Egypt", "Cairo", 30000000);
	RequestBuilder req = post("/createCountry").content(this.mapper.writeValueAsString(testCountry))
			.contentType(MediaType.APPLICATION_JSON);
	
	ResultMatcher checkStatus = status().isCreated();
	Country testSavedCountry = new Country(1, "Egypt", "Cairo", 30000000);
	ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testSavedCountry));
	
	this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
}

@Test
void testCreateButHardToRead() throws Exception {
	this.mvc.perform(
			post("/createCountry").content(this.mapper.writeValueAsString(new Country(1, "Egypt", "Cairo", 30000000)))
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(this.mapper.writeValueAsString(new Country(1, "Egypt", "Cairo", 30000000))));
}

@Test
void testGet() throws Exception {
	List<Country> countries = List.of(new Country(1, "Egypt", "Cairo", 30000000),
			new Country(1, "Egypt", "Cairo", 30000000));

	ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(countries));
	this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);
}

@Test
void testGetById() throws Exception {
	ResultMatcher checkBody = content()
			.json(this.mapper.writeValueAsString(new Country(1, "Egypt", "Cairo", 30000000)));

	this.mvc.perform(get("/get/1")).andExpect(status().isOk()).andExpect(checkBody);
}

}
