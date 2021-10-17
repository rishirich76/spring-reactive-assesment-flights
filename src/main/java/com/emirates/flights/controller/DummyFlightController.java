/**
 * 
 */
package com.emirates.flights.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.flights.FlightsUtils;
import com.emirates.flights.model.Flight;

import lombok.extern.log4j.Log4j2;

/**
 * @author LENOVO
 *
 */
@RestController
@RequestMapping(value = "/data")
@Log4j2
public class DummyFlightController {

	@GetMapping("/first")
	public List<Flight> getFlightInfo(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("date") String date) {
		log.info("*********first system invoked **********");
		return FlightsUtils.generateRandomFlightDataAPI();
	}

	@GetMapping("/second")
	public List<Flight> getFlightInfo2(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("date") String date) {
		log.info("*********Second system invoked **********");
		return FlightsUtils.generateRandomFlightDataAPI();
	}

	@GetMapping("/third")
	public List<Flight> getFlightInfo3(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("date") String date) {
		log.info("*********third system invoked **********");
		return FlightsUtils.generateRandomFlightDataAPI();
	}

}
