package org.example.Service;

import org.example.Model.Car;
import org.example.Service.utility.CarFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarService {
    public final CarFileReader reader = new CarFileReader();

    public List<Car> getAllCarsByMake(String make) {
        List<Car> Cars = reader.getAllCars();
        List<Car> CarsByMake = Cars.stream().filter(car -> car.make().equals(make)).toList();
        return CarsByMake;
    }

    public String mostPopularColor(){
        List<Car> cars = reader.getAllCars();
        Map<String, Integer> colorCount = new HashMap<>();

        cars.stream()
                .map(Car::color)
                .forEach(color -> colorCount.compute(color, (key, value) -> (value == null) ? 1 : value + 1));

        return colorCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<Car> searchCars(String color, int year, String make, String model){
        List<Car> cars = reader.getAllCars();

        return cars.stream()
                .filter(car -> (make == null || car.make().contains(make)) &&
                        (model == null || car.model().contains(model)) &&
                        (year == 0 || car.year() == year) &&
                        (color == null || car.color().contains(color)))
                .collect(Collectors.toList());
    }

}
