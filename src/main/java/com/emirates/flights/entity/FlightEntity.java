/**
 * 
 */
package com.emirates.flights.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Document("Flights")
public class FlightEntity {
	
	private String carrier; 
	
	private String number;
	
	private String from;
	
	private String to;
	
	private Long durationInMinutes;
	
	private Date createdTimeStamp;
	
	
}
