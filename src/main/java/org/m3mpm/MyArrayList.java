package org.m3mpm;

import java.util.Arrays;

public class MyArrayList implements JavaList {

    private Cat[] array = new Cat[10];
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
    public Cat get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Cat cat) {
        increasArray();
        array[size] = cat;
        size += 1;
    }

    @Override
    public void add(Cat cat, int index) {
        checkIndex(index);
        increasArray();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = cat;
        size += 1;
    }

    @Override
    public void addFirst(Cat cat) {
        add(cat, 0);
    }

    @Override
    public void addLast(Cat cat) {
        add(cat, size - 1);
    }

    @Override
    public boolean remove(Cat cat) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(cat)) {
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
        array = new Cat[10];
        size = 0;
    }
}
