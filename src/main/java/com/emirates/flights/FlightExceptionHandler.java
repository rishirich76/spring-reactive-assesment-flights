package com.emirates.flights;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emirates.flights.exception.NoFlightInfoFoundException;
import com.emirates.flights.model.FlightError;

@RestControllerAdvice
public class FlightExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public FlightError missingQueryParam(MissingServletRequestParameterException ex) {
		return FlightError.builder().code(FlightErrorMessages.MISSING_QUERY_PARAM.getCode())
				.message(FlightErrorMessages.MISSING_QUERY_PARAM.getMessage()).build();
	}
	
	@ExceptionHandler(NoFlightInfoFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public FlightError noFlightFound(NoFlightInfoFoundException ex) {
		return FlightError.builder().code(FlightErrorMessages.NO_FLT_FOUND.getCode())
				.message(FlightErrorMessages.NO_FLT_FOUND.getMessage()).build();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public FlightError genericError(Exception ex) {
		return FlightError.builder().code(FlightErrorMessages.GENERIC_ERROR.getCode())
				.message(FlightErrorMessages.GENERIC_ERROR.getMessage()).build();
	}
}
