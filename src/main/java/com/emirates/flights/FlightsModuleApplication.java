package com.emirates.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.emirates.flights.repository.FlightsRepository;

import lombok.extern.log4j.Log4j2;

@EnableReactiveMongoRepositories
@SpringBootApplication
@Log4j2
public class FlightsModuleApplication implements CommandLineRunner {

	@Value("${app.isDBDisabled}")
	boolean isDBSystemDisabled;

	@Autowired
	@Lazy
	private FlightsRepository flightsRepository;

	public static void main(String[] args) {
		SpringApplication.run(FlightsModuleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!isDBSystemDisabled) {
			log.info("adding dummy data in DB.");
			flightsRepository.deleteAll().thenMany(flightsRepository.saveAll(FlightsUtils.generateRandomFlightDataDB()))
					.thenMany(flightsRepository.findAll()).subscribe();
		}
		else {
			log.info("DB is disabled.");
		}

	}

}
