package org.m3mpm;

import java.util.Arrays;

public class CarArrayList implements CarListInterface {

    private Car[] array = new Car[10];
    private int size = 0;

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increasArray() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        increasArray();
        array[size] = car;
        size += 1;
    }

    @Override
    public void add(Car car, int index) {
        checkIndex(index);
        increasArray();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = car;
        size += 1;
    }

    @Override
    public void addFirst(Car car) {
        add(car, 0);
    }

    @Override
    public void addLast(Car car) {
        add(car, size - 1);
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return remove(i);
            }
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1 ; i++) {
            array[i] = array[i + 1];
        }
        size -= 1;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }
}
