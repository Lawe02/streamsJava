package org.example.Service;

import org.example.Model.Car;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    public final CarService carService = new CarService();

    @Test
    void carsByMakeShouldReturnCarsAsExpected() throws IOException {
        // Arrange
        String make = "BMW";
        Integer expectedAmount = 2;

        List<Car> expected = new LinkedList<Car>() {
            {
                add(new Car("BMW", "X5", 2020, "Black"));
                add(new Car("BMW", "3 Series", 2019, "White"));
            }
        };

        // Act
        List<Car> result = carService.getAllCarsByMake(make);

        // Assert
        assertEquals(expectedAmount, result.size(), "The number of cars returned should match the expected amount.");
    }

    @Test
    void mostPopularColorShouldReturRed(){
        //Arrange
        String Expectedresult = "Black";
        //Act
        String result = carService.mostPopularColor();
        //Assert
        assertEquals(Expectedresult, result);
    }

    @Test
    void searchCarShouldReturnBlackMazdaWhenColorInputIsBlaAndMakeInputIsMaz(){
        //Arrange
        String makeSearchParam = "Maz";
        String colorSearchParam = "Bla";
        List<Car> expected = new LinkedList<Car>() {
            {
                add(new Car("Mazda", "CX-3", 2020, "Black"));
            }
        };
        //Act
        var result = carService.searchCars(colorSearchParam, 0, makeSearchParam, null);
        //Assert
        assertEquals(expected, result);
    }
}