package org.m3mpm;

public interface CarListInterface {
    Car get(int index);
    void add(Car car);
    boolean remove(Car car);
    boolean remove(int index);
    int size();
    void clear();
}
