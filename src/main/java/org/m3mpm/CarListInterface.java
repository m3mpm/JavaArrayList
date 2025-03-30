package org.m3mpm;

public interface CarListInterface {
    Car get(int index);
    void add(Car car);
    void add(Car car, int index);
    void addFirst(Car car);
    void addLast(Car car);
    boolean remove(Car car);
    boolean remove(int index);
    int size();
    void clear();
}
