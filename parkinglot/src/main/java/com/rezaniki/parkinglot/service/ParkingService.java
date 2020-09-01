package com.rezaniki.parkinglot.service;


import com.rezaniki.parkinglot.entity.Car;

import java.time.LocalTime;

public interface ParkingService {
    double calculatePrice(Car car);
    int calculateTime(Car car);

}
