package org.m3mpm;

import java.util.Arrays;

public class MyArrayList<E> implements JavaList<E> {

    private Object[] array = new Object[10];
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
    public E get(int index) {
        checkIndex(index);
        return (E)array[index];
    }

    @Override
    public void add(E element) {
        increasArray();
        array[size] = element;
        size += 1;
    }

    @Override
    public void add(E element, int index) {
        checkIndex(index);
        increasArray();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size += 1;
    }

    @Override
    public void addFirst(E element) {
        add(element, 0);
    }

    @Override
    public void addLast(E element) {
        add(element, size - 1);
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
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
        array = new Object[10];
        size = 0;
    }
}
