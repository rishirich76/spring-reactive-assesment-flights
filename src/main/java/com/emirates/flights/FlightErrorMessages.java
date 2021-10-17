/**
 * 
 */
package com.emirates.flights;

import lombok.Getter;

/**
 * @author LENOVO
 *
 */
@Getter
public enum FlightErrorMessages {

	MISSING_QUERY_PARAM("11001", "Invalid input criteria, missing query params."),
	GENERIC_ERROR("11002", "Internal server error, try after sometime."),
	NO_FLT_FOUND("11003", "No flight information found with given criteria."),;
	
	private String code;
	private String message;
	
	FlightErrorMessages(String code, String message) {
		this.code = code;
		this.message =message;
	}
	
	
	
	
	
}
