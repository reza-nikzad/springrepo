package com.reza.flightreservation.service;

import com.reza.flightreservation.dto.ReservationRequest;
import com.reza.flightreservation.entity.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequest request);
}
