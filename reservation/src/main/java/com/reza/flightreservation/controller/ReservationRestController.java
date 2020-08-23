package com.reza.flightreservation.controller;

import com.reza.flightreservation.dto.UpdateReservationRequest;
import com.reza.flightreservation.entity.Reservation;
import com.reza.flightreservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

//    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
//        LOGGER.info("Find Reservation " + id);
        return reservationRepository.findById(id).get();
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public Reservation updateReservation(@RequestBody UpdateReservationRequest request ){
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setCheckedIn(request.getCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());

//        LOGGER.info("Find Reservation " + request);

        return reservationRepository.save(reservation);
    }

}
