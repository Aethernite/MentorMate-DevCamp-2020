package com.mentormate.devcamp.util;

import com.mentormate.devcamp.util.datastructure.MyArrayList;
import com.mentormate.devcamp.util.exception.IteratorOutOfBoundsException;
import com.mentormate.devcamp.util.interfaces.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListIteratorTests {
    private MyArrayList<String> list;
    private Iterator<String> iterator;

    @BeforeEach
    public void init() {
        list = new MyArrayList<>();
        iterator = list.iterator();
    }

    @Test
    public void currentObject_firstObjectToBeReturned_validIndex() {
        list.add("1");
        try {
            Assertions.assertEquals("1", iterator.current());
        } catch (IteratorOutOfBoundsException e) {
            assert false;
        }
    }

    @Test
    public void currentObject_exceptionToBeThrown_invalidIndex() {
        iterator.previous();
        Assertions.assertThrows(IteratorOutOfBoundsException.class, () -> iterator.current());

    }

    @Test
    public void nextMethod_secondObjectToBeReturned() {
        list.add("1");
        list.add("2");
        iterator.next();
        try {
            Assertions.assertEquals("2", iterator.current());
        } catch (IteratorOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void previousMethod_firstObjectToBeReturned() {
        list.add("1");
        list.add("2");
        iterator.next();
        iterator.previous();
        try {
            Assertions.assertEquals("1", iterator.current());
        } catch (IteratorOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void firstMethod_firstObjectToBeReturned() {
        list.add("1");
        list.add("2");
        iterator.next();
        iterator.next();
        iterator.first();
        try {
            Assertions.assertEquals("1", iterator.current());
        } catch (IteratorOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lastMethod_firstObjectToBeReturned() {
        list.add("1");
        list.add("2");
        list.add("3");
        iterator.last();
        try {
            Assertions.assertEquals("3", iterator.current());
        } catch (IteratorOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isDoneMethod_falseBooleanToBeReturned() {
        list.add("1");
        list.add("2");
        list.add("3");
        iterator.next();
        Assertions.assertFalse(iterator.isDone());
    }

    @Test
    public void isDoneMethod_trueBooleanToBeReturned() {
        list.add("1");
        list.add("2");
        list.add("3");
        iterator.last();
        iterator.next();
        Assertions.assertTrue(iterator.isDone());
    }

}
