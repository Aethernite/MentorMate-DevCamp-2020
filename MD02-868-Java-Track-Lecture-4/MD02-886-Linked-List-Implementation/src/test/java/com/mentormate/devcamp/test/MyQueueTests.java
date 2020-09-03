package com.mentormate.devcamp.test;

import com.mentormate.devcamp.util.datastructure.MyLinkedList;
import com.mentormate.devcamp.util.interfaces.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MyQueueTests {
    private Queue<Integer> queue;

    @BeforeEach
    public void init() {
        queue = new MyLinkedList<Integer>();
    }

    @Test
    public void addMethod_shouldReturnTrueAndAddSuccessfully_validElement() {
        queue.add(1);
        queue.add(2);
        Assertions.assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void offerMethod_shouldReturnTrueAndAddSuccessfully_validElement() {
        queue.offer(1);
        Assertions.assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void removeMethod_shouldReturnTheFirstElementAndRemoveIt_validElement() {
        queue.add(1);
        queue.add(2);
        Assertions.assertEquals(Integer.valueOf(1), queue.remove());
    }

    @Test
    public void removeMethod_shouldThrowException_emptyList() {
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.remove());
    }

    @Test
    public void pollMethod_shouldReturnTheFirstElementAndRemoveIt() {
        queue.add(1);
        queue.add(2);
        Assertions.assertEquals(Integer.valueOf(1), queue.poll());
    }

    @Test
    public void elementMethod_shouldReturnTheFirstElement() {
        queue.add(1);
        Assertions.assertEquals(Integer.valueOf(1), queue.element());
    }

}
