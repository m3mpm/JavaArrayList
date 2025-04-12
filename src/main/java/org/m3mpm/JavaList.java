package org.m3mpm;

public interface JavaList {
    Cat get(int index);
    void add(Cat cat);
    void add(Cat cat, int index);
    void addFirst(Cat cat);
    void addLast(Cat cat);
    boolean remove(Cat cat);
    boolean remove(int index);
    int size();
    void clear();
}
