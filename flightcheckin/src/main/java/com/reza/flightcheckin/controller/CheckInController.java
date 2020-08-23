package com.reza.flightcheckin.controller;

import com.reza.flightcheckin.integration.ReservationRestClient;

import com.reza.flightcheckin.integration.dto.Reservation;
import com.reza.flightcheckin.integration.dto.UpdateReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient reservationRestClient;

    @RequestMapping("/showStartCheckIn")
    public String startCheckIn(){
        return "startCheckIn";
    }

    @RequestMapping("/showFlightInfo")
    public String showFlightInfo(@RequestParam("id") Long id,Model model){
        Reservation reservation = reservationRestClient.findReservation(id);
        model.addAttribute("reservation", reservation);
        return "displayFlightInfo";

    }

    @RequestMapping("/confirmCheckIn")
    public String doCheckIn(@RequestParam("id") Long id,
                            @RequestParam("noOfBags") int numberOfBags,
                            Model model){
        UpdateReservationRequest reservationRequest = new UpdateReservationRequest();
        reservationRequest.setCheckedIn(true);
        reservationRequest.setNumberOfBags(numberOfBags);
        reservationRequest.setId(id);
        reservationRestClient.updateReservation(reservationRequest);
        model.addAttribute("msg", "Flight is Checked In.");
        return "confirmationCheckIn";
    }

}
