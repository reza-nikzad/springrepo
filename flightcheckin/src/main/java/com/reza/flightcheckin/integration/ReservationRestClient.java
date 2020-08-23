package com.reza.flightcheckin.integration;

import com.reza.flightcheckin.integration.dto.Reservation;
import com.reza.flightcheckin.integration.dto.UpdateReservationRequest;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(UpdateReservationRequest request);

}
