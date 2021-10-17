/**
 * 
 */
package com.emirates.flights.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LENOVO
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flights {

	@JsonProperty("flightsInformation")
	private List<Flight> flights;
	
	
}
