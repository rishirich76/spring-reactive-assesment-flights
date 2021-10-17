/**
 * 
 */
package com.emirates.flights.query.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.emirates.flights.client.FlightSystemFirst;
import com.emirates.flights.client.FlightSystemSecond;
import com.emirates.flights.exception.NoFlightInfoFoundException;
import com.emirates.flights.model.Flight;
import com.emirates.flights.repository.FlightsRepository;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

/**
 * @author LENOVO
 *
 */
@Service
@Log4j2
public class GetFlightsHandler {

	@Value("${app.isDBDisabled}")
	boolean isDBSystemDisabled;

	@Autowired
	@Lazy
	private FlightsRepository flightsRepository;

	@Autowired
	private FlightSystemFirst flightSystemFirst;

	@Autowired
	private FlightSystemSecond flightSystemSecond;

	public Flux<Flight> getFlights(String from, String to, String date) {
		// can add date filter later depends on biz logic

		// get data from db, say one of the backend system
		Flux<Flight> dbResults = Flux.empty();
		if (!isDBSystemDisabled) {
			dbResults = flightsRepository.findByFromAndTo(from, to)
					.map(f -> Flight.builder().carrier(f.getCarrier()).number(f.getNumber())
							.durationInMinutes(f.getDurationInMinutes()).from(f.getFrom()).to(f.getTo()).build());
		}

		// get data from system 1
		Flux<Flight> flightResults1 = flightSystemFirst.getFlightsInfo(from, to, date);

		// get data from system 2
		Flux<Flight> flightResults2 = flightSystemSecond.getFlightsInfo(from, to, date);

		Flux<Flight> mergedFlux = Flux.merge(dbResults, flightResults1, flightResults2)
				.sort((f1, f2) -> f1.getDurationInMinutes().compareTo(f2.getDurationInMinutes()))
				.switchIfEmpty(Flux.error(new NoFlightInfoFoundException()));

		log.info("Flux merge done with all endsystems, now op will be performed. ");

		return mergedFlux;
	}

}
