package com.frantest.cascadingtypetesting;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CascadeMergeTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private SteeringWheelRepository steeringWheelRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void testSaveCarWithSteeringWheel() {
        // given
        Car carOne = new Car();
        carOne.setSeries("A1A");

        SteeringWheel steerOne = new SteeringWheel();
        steerOne.setDiameters(35);

        carOne.setSteeringWheel(steerOne);
        carRepository.save(carOne);
        steeringWheelRepository.save(steerOne);
    }

    @Test
    @Order(2)
    public void testCarIsSaved() {
        Car fromDb = carRepository.getCarBySeries("A1A");

        // then
        assertTrue("Error car not saved to db found null", fromDb != null);
        assertTrue("Error car not saved to db id is 0", fromDb.getId() > 0);
    }

    @Test
    @Order(3)
    public void testSteeringWheelIsSavedToo() {
        SteeringWheel fromDb = steeringWheelRepository.getSteeringWheelByDiameters(35);

        // then
        assertTrue("Error steering wheel not saved to db found null", fromDb != null);
        assertTrue("Error steering wheel not saved to db is is 0", fromDb.getId() > 0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void testMergeDataCar() {
        Car carDb = carRepository.getCarBySeries("A1A");
        carDb.setSeries("A1B");
        SteeringWheel steeringWheelDb = steeringWheelRepository.getSteeringWheelByDiameters(35);
        steeringWheelDb.setDiameters(30);
    }

    @Test
    @Order(5)
    public void testSteeringWheelSavedToo() {
        SteeringWheel fromDb = steeringWheelRepository.getSteeringWheelByDiameters(30);

        // then
        assertTrue("Error steering wheel not saved to db found null", fromDb != null);
        assertTrue("Error steering wheel not saved to db is is 0", fromDb.getId() > 0);
    }
}
