/**
 * 
 */
package com.emirates.flights.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.emirates.flights.model.Flight;

import reactor.core.publisher.Flux;

/**
 * @author LENOVO
 *
 */
@Service
public class FlightSystemSecond {

	@Value("${endsystem.flights.system2.baseUrl}")
	private String baseUrl;
	
	@Value("${endsystem.flights.system2.uri}")
	private String uri;
	
	public Flux<Flight> getFlightsInfo(String from, String to, String date) {
		
		WebClient webClient = WebClient.create(baseUrl);
		return webClient.get()
                .uri(ur -> ur
                        .path(uri)
                        .queryParam("from", from)
                        .queryParam("to", to)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToFlux(Flight.class);
                //.delaySubscription(Duration.ofMillis(5000));
	}

}
