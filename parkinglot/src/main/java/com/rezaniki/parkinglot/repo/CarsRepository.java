package com.rezaniki.parkinglot.repo;

import com.rezaniki.parkinglot.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {
}
