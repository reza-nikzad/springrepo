package com.reza.flightreservation.repos;

import com.reza.flightreservation.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
