package com.reza.flightreservation.controller;

import com.reza.flightreservation.entity.Flight;
import com.reza.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping( value = "/showFlights", method = RequestMethod.POST)
    public String listOfAvailableFlights(@RequestParam("from") String from,
            @RequestParam("to") String to,@RequestParam("date") @DateTimeFormat(pattern = "MM-dd-yyyy") Date date,
            Model model){
        List<Flight> flights = flightRepository.findFlights(from, to, date);
//        List<Flight> flights = flightRepository.findAll();

        model.addAttribute("flights", flights);
        return "listOfFlights";
    }

    @RequestMapping("admin/showAddFlight")
    public String showAddFlight(){
        return "admin/addFlight";
    }

}
