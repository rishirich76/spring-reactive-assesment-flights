/**
 * 
 */
package com.emirates.flights.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.emirates.flights.entity.FlightEntity;

import reactor.core.publisher.Flux;

/**
 * @author LENOVO
 *
 */
@Repository
@ConditionalOnProperty(prefix = "app", value = "isDBDisabled", havingValue = "false", matchIfMissing = true)
public interface FlightsRepository extends ReactiveMongoRepository<FlightEntity, String>{

	public Flux<FlightEntity> findByFromAndTo(String from, String to);
}
