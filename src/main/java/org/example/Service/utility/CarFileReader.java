package org.example.Service.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.example.Model.Car;

import java.util.List;

public class CarFileReader {
    public List<Car> getAllCars() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cars.json")) {

            if (inputStream == null) {
                throw new IOException("File not found");
            }

            List<Car> cars = mapper.readValue(inputStream, new TypeReference<List<Car>>() {
            });

            return cars;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
