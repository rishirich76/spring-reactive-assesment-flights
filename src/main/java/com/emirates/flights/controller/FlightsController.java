/**
 * 
 */
package com.emirates.flights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.flights.command.handler.AddFlightsHandler;
import com.emirates.flights.model.Flight;
import com.emirates.flights.query.handler.GetFlightsHandler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LENOVO
 *
 */
@RestController
public class FlightsController {

	@Autowired
	private AddFlightsHandler addFlightsHandler;

	@Autowired
	private GetFlightsHandler getFlightsHandler;

	@GetMapping
	public Flux<Flight> getFlightInfo(@RequestParam("depAirport") String from, @RequestParam("arrAirport") String to,
			@RequestParam("date") String date) {
		return getFlightsHandler.getFlights(from, to, date); 
	}

	//below doesn't work, only to show CQRS design
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Flight> createProduct(@RequestBody Flight flight) {
		return addFlightsHandler.add(flight);
	}

}
