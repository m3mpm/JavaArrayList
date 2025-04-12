package org.m3mpm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaListTest {

    private JavaList<Cat> javaList;

    @BeforeEach
    void setUp() {
        javaList = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            javaList.add(new Cat("kitty" + i, 3));
        }
    }

    @Test
    void getElementByCorrectIndex(){
        Cat cat = javaList.get(0);
        assertEquals("kitty0", cat.getName());
    }

    @Test
    void getElementByIncorrectIndexThenThrowException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            javaList.get(20);
        });
    }

    @Test
    void addElement(){
        assertEquals(10, javaList.size());
    }

    @Test
    void addElementWithCorrectIndexIntoMiddle(){
        Cat cat = new Cat("Luna", 5);
        javaList.add(cat,5);
        Cat catFromArray = javaList.get(5);
        assertEquals("Luna", catFromArray.getName());
    }

    @Test
    void addElementWithIncorrectIndexThenThrowException(){
        Cat cat = new Cat("Oliver", 5);
        assertThrows(IndexOutOfBoundsException.class, () -> javaList.add(cat,20));
    }

    @Test
    void addElementIntoFirstPosition(){
        Cat cat = new Cat("Bella", 5);
        javaList.addFirst(cat);
        Cat catFromArray = javaList.get(0);
        assertEquals("Bella", catFromArray.getName());
    }

    @Test
    void addElementIntoLastPosition(){
        Cat cat = new Cat("Charlie", 5);
        javaList.addLast(cat);
        Cat catFromArray = javaList.get(9);
        assertEquals("Charlie", catFromArray.getName());
    }

    @Test
    void removeByElementTrue(){
        Cat cat = new Cat("Lucy", 5);
        javaList.add(cat);
        assertEquals(11, javaList.size());
        assertTrue(javaList.remove(cat));
        assertEquals(10, javaList.size());
    }

    @Test
    void removeByElementFalse(){
        Cat cat = new Cat("Max", 5);
        assertFalse(javaList.remove(cat));
        assertEquals(10, javaList.size());
    }

    @Test
    void removeByCorrectIndex(){
        assertTrue(javaList.remove(2));
        assertEquals(9, javaList.size());
    }

    @Test
    void removeByIncorrectIndexThenThrowException(){
        assertEquals(10, javaList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> javaList.remove(20));
    }

    @Test
    void removeAll(){
        javaList.clear();
        assertEquals(0, javaList.size());
    }
}
