package com.reza.flightreservation.service;

import com.reza.flightreservation.dto.ReservationRequest;
import com.reza.flightreservation.entity.Flight;
import com.reza.flightreservation.entity.Passenger;
import com.reza.flightreservation.entity.Reservation;
import com.reza.flightreservation.repos.FlightRepository;
import com.reza.flightreservation.repos.PassengerRepository;
import com.reza.flightreservation.repos.ReservationRepository;
import com.reza.flightreservation.util.EmailSender;
import com.reza.flightreservation.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReservationServicImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailSender emailSender;

    @Transactional
    @Override
    public Reservation bookFlight(ReservationRequest request) {
        // Make Payment
        Long flightId = request.getFlightId();

        Optional<Flight> optional = flightRepository.findById(flightId);
        Flight flight = optional.get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setMiddleName(request.getPassengerMiddleName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);
        reservation.setNumberOfBags(0);
        reservation.setTimestamp(flight.getEstimatedDepartureTime());

        Reservation savedReservation = reservationRepository.save(reservation);

        String filePath = "C:/Users/reza/Desktop/Java-Courses/Java Code Bank/Thymeleaf+Spring/reservation/src/main/resources/reservationConfirmationpdfs/"+savedReservation.getId()+".pdf";
        pdfGenerator.generateItinerary(savedReservation, filePath);
        emailSender.sendEmail(savedReservation.getPassenger().getEmail(),filePath);

        return savedReservation;
    }
}
