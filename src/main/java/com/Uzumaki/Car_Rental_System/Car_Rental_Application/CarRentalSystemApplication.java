package com.Uzumaki.Car_Rental_System.Car_Rental_Application;

import com.Uzumaki.Car_Rental_System.Car_Rental_System_Data.JsonDataMigration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEventListener;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CarRentalSystemApplication implements ApplicationReadyEventListener {

	@Bean
	private JsonDataMigration jsonDataMigration(ObjectMapper objectMapper) {
		return new JsonDataMigration(objectMapper);
	}

	@Autowired
	private CarRentalRepository carRentalRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalSystemApplication.class, args);
	}

	@Override
	public void onApplicationReady(org.springframework.context.ApplicationEvent event) {
		try {
			List<Car> cars = jsonDataMigration.migrateCarData("src/main/resources/cars.json");
			carRentalRepository.saveAll(cars);
		}
		catch (IOException e) {
			System.err.println("Error reading JSON file: " + e.getMessage());
		}

	}

	public void loadData() throws IOException {
		CarDataMigration.migrateData();
	}
}
