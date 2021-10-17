package com.emirates.flights;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;
import java.util.PrimitiveIterator.OfLong;
import java.util.Random;

import com.emirates.flights.entity.FlightEntity;
import com.emirates.flights.model.Flight;

public class FlightsUtils {

	private final static int TOTAL_NUM_OF_RECORDS_DB = 20;
	private final static int TOTAL_NUM_OF_RECORDS_API = 5;
	private final static String[] carrier = { "EK", "FZ" };

	private final static String[] destinations = { "DEL", "CDG", "BOM" };


	/**
	 * generate random flight records
	 * @return
	 */
	public static List<FlightEntity> generateRandomFlightDataDB() {
		List<FlightEntity> list = new ArrayList<FlightEntity>();
		OfInt ran = new Random().ints(2, 9999).iterator();
		Random ranC = new Random();
		OfLong ranDuration = new Random().longs(240, 660).iterator();
		for (int i = 0; i < TOTAL_NUM_OF_RECORDS_DB; i++) {
			list.add(new FlightEntity(carrier[ranC.nextInt(carrier.length)], String.format("%04d", ran.nextInt()),
					"DXB", destinations[ranC.nextInt(destinations.length)], ranDuration.nextLong(), new Date()));

		}
		return list;
	}
	
	/**
	 * generate random flight records
	 * @return
	 */
	public static List<Flight> generateRandomFlightDataAPI() {
		List<Flight> list = new ArrayList<Flight>();
		OfInt ran = new Random().ints(2, 9999).iterator();
		Random ranC = new Random();
		OfLong ranDuration = new Random().longs(240, 660).iterator();
		for (int i = 0; i < TOTAL_NUM_OF_RECORDS_API; i++) {
			list.add(new Flight(carrier[ranC.nextInt(carrier.length)], String.format("%04d", ran.nextInt()),
					"DXB", destinations[ranC.nextInt(destinations.length)], ranDuration.nextLong()));
		}
		return list;
	}
}
