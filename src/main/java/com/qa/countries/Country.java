package com.qa.countries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI (optional)
	private Integer id;

	private String name;

	private String capital;
	
	private Integer population;
	
	public Country(String name, String capital, Integer population) {
		super();
		this.name = name;
		this.capital = capital;
		this.population = population;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getCapital() {
		return this.capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + ", population=" + population + "]";
	}


}
