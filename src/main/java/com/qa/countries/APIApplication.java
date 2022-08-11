package com.qa.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.countries.CountryController;
import com.qa.countries.CountryService;

@SpringBootApplication
public class APIApplication {

	public static void main(String[] args) {
		// THIS IS FOR DEMO PURPOSES ONLY
		ApplicationContext context = SpringApplication.run(APIApplication.class, args);
		System.out.println("SERVICE: " + context.getBean(CountryService.class));
		System.out.println("CONTROLLER: " + context.getBean(CountryController.class));

		//works like this:
//		BiscuitController controller = new BiscuitController(new BiscuitServiceDB());
	}
}
