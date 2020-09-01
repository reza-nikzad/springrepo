package com.rezaniki.parkinglot.controllers;

import com.rezaniki.parkinglot.entity.Car;
import com.rezaniki.parkinglot.repo.CarsRepository;
import com.rezaniki.parkinglot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ParkingController {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    ParkingService parkingService;

    @RequestMapping("/")
    public String showHomePage(@ModelAttribute("car") Car car, Model model){
        List<Car> carList = carsRepository.findAll();
        model.addAttribute("carList", carList);
        return "homePage";
    }

    @RequestMapping("/reserveLot")
    public String reserveLot(@ModelAttribute("car") Car car, Model model){
        car.setEntertime(System.currentTimeMillis());
        Car savedCar = carsRepository.save(car);
        List<Car> carList = carsRepository.findAll();
        model.addAttribute("carList", carList);
        return "homePage";
    }

    @RequestMapping("/exitCar")
    public String exitCar(@RequestParam("id")int id,Model model){
        Optional<Car> optionalCar = carsRepository.findById(id);
        Car car = optionalCar.get();
        model.addAttribute("car", car);
        double time = parkingService.calculatePrice(car);
        model.addAttribute("time", time);
        return "exit";
    }

    @RequestMapping("/paid")
    public String exitCar(@RequestParam("id")int id){
        carsRepository.deleteById(id);
        return "homePage";
    }
}
