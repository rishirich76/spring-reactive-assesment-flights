/*
 * package com.emirates.flights.controller;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.context.annotation.Import; import
 * org.springframework.test.context.junit.jupiter.SpringExtension; import
 * org.springframework.test.web.reactive.server.WebTestClient;
 * 
 * import com.emirates.flights.client.FlightSystemFirst; import
 * com.emirates.flights.client.FlightSystemFourth; import
 * com.emirates.flights.client.FlightSystemSecond; import
 * com.emirates.flights.client.FlightSystemThird; import
 * com.emirates.flights.command.handler.AddFlightsHandler; import
 * com.emirates.flights.entity.FlightEntity; import
 * com.emirates.flights.query.handler.GetFlightsHandler; import
 * com.emirates.flights.repository.FlightsRepository;
 * 
 * @ExtendWith(SpringExtension.class)
 * 
 * @WebFluxTest(controllers = FlightsController.class)
 * 
 * @Import({ GetFlightsHandler.class, AddFlightsHandler.class }) public class
 * FlightsControllerTest {
 * 
 * @MockBean FlightsRepository repository;
 * 
 * @MockBean private FlightSystemFirst flightSystemFirst;
 * 
 * @MockBean private FlightSystemSecond flightSystemSecond;
 * 
 * @MockBean private FlightSystemThird flightSystemThird;
 * 
 * @MockBean private FlightSystemFourth flightSystemFourth;
 * 
 * @Autowired private WebTestClient webClient;
 * 
 * public void setUp(FlightEntity fe) { //
 * ReflectionTestUtils.setField(webClient, "isDBSystemDisabled", true); //
 * Mockito.when(repository.deleteAll()).thenReturn(Mono.empty()); // // fe = fe
 * == null // ?
 * FlightEntity.builder().carrier("EK").durationInMinutes(Long.valueOf("556")).
 * number("056").from("DXB") // .to("DEL").build() // : fe; // //
 * Flux<FlightEntity> data = Flux.just(fe); //
 * Mockito.when(repository.findByFromAndTo(Mockito.any(),
 * Mockito.any())).thenReturn(data);
 * 
 * }
 * 
 * @Test void testGetFlights_Success() { setUp(null); // webClient.get() //
 * .uri(ur -> ur.path("/flight").queryParam("depAirport",
 * "DXB").queryParam("arrAirport", "DEL") // .queryParam("date",
 * "20Dec2021").build()) // .header(HttpHeaders.ACCEPT,
 * "application/json").exchange().expectStatus().isOk().expectBody() //
 * .jsonPath("$").isArray();
 * 
 * } }
 */