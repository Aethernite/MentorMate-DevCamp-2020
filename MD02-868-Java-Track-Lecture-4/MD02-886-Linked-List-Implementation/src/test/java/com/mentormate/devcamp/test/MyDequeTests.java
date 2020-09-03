package com.mentormate.devcamp.test;

import com.mentormate.devcamp.util.datastructure.MyLinkedList;
import com.mentormate.devcamp.util.interfaces.Deque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MyDequeTests {
    private Deque<Integer> deque;

    @BeforeEach
    public void init() {
        deque = new MyLinkedList<Integer>();
    }

    @Test
    public void addFirstMethod_shouldAddElementAtTheBeginning_validElement() {
        deque.addFirst(1);
        Assertions.assertEquals(Integer.valueOf(1), deque.getFirst());
    }

    @Test
    public void addLastMethod_shouldAddElementAtTheEnd_validElement() {
        deque.add(1);
        deque.add(2);
        deque.addLast(3);
        Assertions.assertEquals(Integer.valueOf(3), deque.getLast());
    }

    @Test
    public void offerFirstMethod_shouldAddElementAtTheBeginningAndReturnTrue_validElement() {
        deque.add(4);
        deque.add(5);
        Assertions.assertTrue(deque.offerFirst(1));
        Assertions.assertEquals(Integer.valueOf(1), deque.getFirst());
    }

    @Test
    public void offerLastMethod_shouldAddElementAtTheEndAndReturnTrue_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertTrue(deque.offerLast(1));
        Assertions.assertEquals(Integer.valueOf(1), deque.getLast());
    }

    @Test
    public void removeFirstMethod_shouldRemoveElementAtTheBeginningAndReturnIt_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertEquals(Integer.valueOf(5), deque.removeFirst());
    }

    @Test
    public void removeLastMethod_shouldRemoveElementAtTheEndAndReturnIt_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertEquals(Integer.valueOf(4), deque.removeLast());
    }

    @Test
    public void removeFirstMethod_shouldThrowException_emptyDeque() {
        Assertions.assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
    }

    @Test
    public void removeLastMethod_shouldThrowException_emptyDeque() {
        Assertions.assertThrows(NoSuchElementException.class, () -> deque.removeLast());
    }

    @Test
    public void pollFirstMethod_shouldRemoveElementAtTheBeginningAndReturnIt_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertEquals(Integer.valueOf(5), deque.pollFirst());
    }

    @Test
    public void pollLastMethod_shouldRemoveElementAtTheEndAndReturnIt_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertEquals(Integer.valueOf(4), deque.pollLast());
    }

    @Test
    public void getFirstMethod_shouldGetTheFirstElementAndReturnItWithoutRemove_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertEquals(Integer.valueOf(5), deque.getFirst());
    }

    @Test
    public void getLastMethod_shouldGetTheLastElementAndReturnItWithoutRemove_validElement() {
        deque.add(4);
        deque.addFirst(5);
        Assertions.assertEquals(Integer.valueOf(4), deque.getLast());
    }

    @Test
    public void getFirstMethod_shouldThrowException_zeroElements() {
        Assertions.assertThrows(NoSuchElementException.class, () -> deque.getFirst());
    }

    @Test
    public void getLastMethod_shouldThrowException_zeroElements() {
        Assertions.assertThrows(NoSuchElementException.class, () -> deque.getLast());
    }

}
