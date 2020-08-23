package com.reza.flightreservation.repos;

import com.reza.flightreservation.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "select * from Flight where departure_City=:departureCity and arrival_City=:arrivalCity and DATE_OF_DEPARTURE=:date ", nativeQuery = true)
    List<Flight> findFlights(@Param("departureCity") String departureCity,
                             @Param("arrivalCity") String arrivalCity,
                             @Param("date") Date date);

}
