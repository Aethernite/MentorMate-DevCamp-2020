package com.mentormate.devcamp.test;

import com.mentormate.devcamp.util.datastructure.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyListTests {
    private MyLinkedList<Integer> list;

    @BeforeEach
    public void init() {
        list = new MyLinkedList<Integer>();
    }

    @Test
    public void addMethod_shouldAddSuccessfullyAndReturnTrue_validElement() {
        Assertions.assertTrue(list.add(1));
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void insertMethod_shouldInsertSuccessfullyAtIndex_validElement() {
        list.add(1);
        list.add(3);
        list.insert(1, 2);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(2, list.get(1));
    }

    @Test
    public void deleteByIndexMethod_shouldDeleteSuccessfullyAtIndex_validElement() {
        list.add(1);
        list.add(3);
        list.delete(1);
        Assertions.assertEquals(1, list.size());
        Assertions.assertFalse(list.contains(3));
    }

    @Test
    public void getMethod_shouldGetSuccessfullyTheElementAtIndex_validElement() {
        list.add(1);
        list.add(3);
        Assertions.assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void sizeMethod_shouldGetSuccessfullyTheSizeOfTheList() {
        list.add(1);
        list.add(3);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void setMethod_shouldSetSuccessfullyTheValueAtIndex_validElementAndIndex() {
        list.add(1);
        list.add(3);
        list.set(0, 7);
        Assertions.assertEquals(7, list.get(0));
    }

    @Test
    public void deleteByElementMethod_shouldDeleteSuccessfullyAtIndex_validElement() {
        list.add(1);
        list.add(3);
        Assertions.assertTrue(list.delete(Integer.valueOf(1)));
        Assertions.assertEquals(1, list.size());
        Assertions.assertFalse(list.contains(1));
    }

    @Test
    public void containsMethod_shouldReturnTrue_containedElement() {
        list.add(1);
        Assertions.assertTrue(list.contains(1));
    }

    @Test
    public void containsMethod_shouldReturnFalse_nonExistentElement() {
        Assertions.assertFalse(list.contains(99));
    }

    @Test
    public void indexOfMethod_shouldReturnTheIndexOfElement_validElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(1, list.indexOf(2));
    }

    @Test
    public void isEmptyMethod_shouldReturnTrue() {
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyMethod_shouldReturnFalse() {
        list.add(1);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void clearMethod_shouldClearTheList() {
        list.add(1);
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void indexOfMethod_shouldReturnTheIndexOfNullElement_nullElement() {
        list.add(1);
        list.add(null);
        list.add(3);
        Assertions.assertEquals(1, list.indexOf(null));
    }

}
