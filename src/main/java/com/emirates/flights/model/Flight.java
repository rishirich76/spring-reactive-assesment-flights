/**
 * 
 */
package com.emirates.flights.model;

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
public class Flight {

	private String carrier;

	private String number;

	private String from;

	private String to;

	private Long durationInMinutes;

}
