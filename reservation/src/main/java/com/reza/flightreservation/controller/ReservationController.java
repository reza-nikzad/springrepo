package com.reza.flightreservation.controller;

import com.reza.flightreservation.dto.ReservationRequest;
import com.reza.flightreservation.entity.Flight;
import com.reza.flightreservation.entity.Reservation;
import com.reza.flightreservation.repos.FlightRepository;
import com.reza.flightreservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

//    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @RequestMapping("/bookFlight")
    public String reserveFlight(@RequestParam("id") Long id, Model model,
                                @ModelAttribute("request") ReservationRequest request){
        Optional<Flight> optional = flightRepository.findById(id);
        Flight flight = optional.get();
//        LOGGER.info("reserveFlight(): id: {} - request: {} - flight: {} ",id,request,flight);
        model.addAttribute("flight",  flight);
        return "reservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String bookTicketForPassenger(@ModelAttribute("request") ReservationRequest request,
                                         Model model ){
        Reservation reservation = reservationService.bookFlight(request);
//        String msg = request.getFlightId()+request.getPassengerFirstName();
//        LOGGER.info("bookTicketForPassenger(): request: {} - reservation: {}",request,reservation);

        model.addAttribute("msg", "the flight is booked and the id is " + reservation.getId() );
        return "reservationConfirmation";
    }
}
