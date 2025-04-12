package org.m3mpm;

public interface JavaList<E> {
    E get(int index);
    void add(E element);
    void add(E element, int index);
    void addFirst(E element);
    void addLast(E element);
    boolean remove(E element);
    boolean remove(int index);
    int size();
    void clear();
}
