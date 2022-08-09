package com.qa.countries;

public class Country {

	private String name;
	
	private String capital;
	
	private int population;
	
	public Country(String name, String capital, int population) {
		super();
		this.name = name;
		this.capital = capital;
		this.population = population;
	}
	
	
	public String getCapital() {
		return this.capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	
	
	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + ", population=" + population + "]";
	}

	public int getPopulation() {
		return this.population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
