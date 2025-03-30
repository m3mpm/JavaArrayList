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
    void get(){
        Car car = carListInterface.get(0);
        assertEquals("brand0", car.getBrand());
    }

    @Test
    void add(){
        assertEquals(10, carListInterface.size());
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
    void removeByCorrectIndexThenTrue(){
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

    @Test
    void whenIndexOutOfBoundsThenThrowException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carListInterface.get(20);
        });
    }

}
