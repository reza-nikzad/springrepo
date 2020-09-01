package com.rezaniki.parkinglot.service;

import com.rezaniki.parkinglot.entity.Car;
import com.rezaniki.parkinglot.repo.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    CarsRepository carsRepository;


    @Override
    public double calculatePrice(Car car) {
        double price = 5.5;
        return calculateTime(car)*price;
    }

    @Override
    public int calculateTime(Car car) {
        double diffHours =(double) (System.currentTimeMillis() - car.getEntertime())
                / (1000 * 60 * 60 );
        return (int)Math.ceil(diffHours);
    }
}
