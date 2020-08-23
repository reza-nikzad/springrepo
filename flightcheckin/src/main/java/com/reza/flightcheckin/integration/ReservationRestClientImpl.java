package com.reza.flightcheckin.integration;

import com.reza.flightcheckin.integration.ReservationRestClient;
import com.reza.flightcheckin.integration.dto.Reservation;
import com.reza.flightcheckin.integration.dto.UpdateReservationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    private static final String RESERVATION_REST_URL =  "http://localhost:8181/flightreservation/reservations/";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id , Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(UpdateReservationRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL,request, Reservation.class);
        return reservation;
    }
}
