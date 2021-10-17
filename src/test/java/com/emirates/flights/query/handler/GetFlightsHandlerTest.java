package com.emirates.flights.query.handler;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;

import com.emirates.flights.client.FlightSystemFirst;
import com.emirates.flights.client.FlightSystemFourth;
import com.emirates.flights.client.FlightSystemSecond;
import com.emirates.flights.client.FlightSystemThird;
import com.emirates.flights.entity.FlightEntity;
import com.emirates.flights.exception.NoFlightInfoFoundException;
import com.emirates.flights.model.Flight;
import com.emirates.flights.repository.FlightsRepository;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class GetFlightsHandlerTest {

	@Mock
	FlightsRepository flightsRepository;

	@Mock
	FlightSystemFirst flightSystemFirst;

	@Mock
	FlightSystemSecond flightSystemSecond;

	@Mock
	FlightSystemThird flightSystemThird;

	@Mock
	FlightSystemFourth flightSystemFourth;

	@InjectMocks
	GetFlightsHandler getFlightsHandler;

	public void setup() {
		MockitoAnnotations.initMocks(this);

		Flux<FlightEntity> data = Flux
				.just(FlightEntity.builder().carrier("EK").durationInMinutes(256L).number("0564").build());
		Mockito.when(flightsRepository.findByFromAndTo(Mockito.anyString(), Mockito.anyString())).thenReturn(data);
		Mockito.when(flightSystemFirst.getFlightsInfo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Flux.empty());
		Mockito.when(flightSystemSecond.getFlightsInfo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Flux.empty());
		Mockito.when(flightSystemThird.getFlightsInfo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Flux.empty());
		Mockito.when(flightSystemFourth.getFlightsInfo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Flux.empty());
	}

	@Test
	public void testGetFlightHappyScenario_Success() {
		setup();
		Flux<Flight> result = getFlightsHandler.getFlights("DXB", "DEL", "20Jul2022");
		StepVerifier.create(result).assertNext(f -> {
			assertNotNull(f.getCarrier());
			assertNotNull(f.getNumber());
			assertNotNull(f.getDurationInMinutes());
		}).expectNextCount(3).verifyComplete();
		Mockito.verify(flightsRepository, VerificationModeFactory.atLeastOnce());
	}
	
	@Test
	public void testGetFlightHappyScenario_Failure() {
		setup();
		Flux<Flight> result = getFlightsHandler.getFlights("DXB", "DEL", "20Jul2022");
		StepVerifier.create(result).expectError().verifyThenAssertThat()
				.hasOperatorErrorOfType(NoFlightInfoFoundException.class);
		Mockito.verify(flightsRepository, VerificationModeFactory.atLeastOnce());
	}
}
