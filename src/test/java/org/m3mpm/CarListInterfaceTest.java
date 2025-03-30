package org.m3mpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListInterfaceTest {

    private CarListInterface carListInterface;

    @BeforeEach
    void setUp() {
        carListInterface = new CarArrayList();

        for (int i = 0; i < 10; i++) {
            carListInterface.add(new Car("brand" + i, i));
        }
    }

    @Test
    void getElementByCorrectIndex(){
        Car car = carListInterface.get(0);
        assertEquals("brand0", car.getBrand());
    }

    @Test
    void getElementByIncorrectIndexThenThrowException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carListInterface.get(20);
        });
    }

    @Test
    void addElement(){
        assertEquals(10, carListInterface.size());
    }

    @Test
    void addElementWithCorrectIndexIntoMiddle(){
        Car car = new Car("LocalBrand", 100);
        carListInterface.add(car,5);
        Car carFromArray = carListInterface.get(5);
        assertEquals("LocalBrand", carFromArray.getBrand());
    }

    @Test
    void addElementWithIncorrectIndexThenThrowException(){
        Car car = new Car("LocalBrand", 100);
        assertThrows(IndexOutOfBoundsException.class, () -> carListInterface.add(car,20));
    }

    @Test
    void addElementIntoFirstPosition(){
        Car car = new Car("LocalBrand", 100);
        carListInterface.addFirst(car);
        Car carFromArray = carListInterface.get(0);
        assertEquals("LocalBrand", carFromArray.getBrand());
    }

    @Test
    void addElementIntoLastPosition(){
        Car car = new Car("LocalBrand", 100);
        carListInterface.addLast(car);
        Car carFromArray = carListInterface.get(9);
        assertEquals("LocalBrand", carFromArray.getBrand());
    }

    @Test
    void removeByElementTrue(){
        Car car = new Car("LocalBrand", 100);
        carListInterface.add(car);
        assertEquals(11, carListInterface.size());
        assertTrue(carListInterface.remove(car));
        assertEquals(10, carListInterface.size());
    }

    @Test
    void removeByElementFalse(){
        Car car = new Car("LocalBrand", 0);
        assertFalse(carListInterface.remove(car));
        assertEquals(10, carListInterface.size());
    }

    @Test
    void removeByCorrectIndex(){
        assertTrue(carListInterface.remove(2));
        assertEquals(9, carListInterface.size());
    }

    @Test
    void removeByIncorrectIndexThenThrowException(){
        assertEquals(10, carListInterface.size());
        assertThrows(IndexOutOfBoundsException.class, () -> carListInterface.remove(20));
    }

    @Test
    void removeAll(){
        carListInterface.clear();
        assertEquals(0, carListInterface.size());
    }

}
