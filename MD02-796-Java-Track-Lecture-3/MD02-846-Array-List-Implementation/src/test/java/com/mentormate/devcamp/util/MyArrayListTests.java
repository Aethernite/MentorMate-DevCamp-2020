package com.mentormate.devcamp.util;

import com.mentormate.devcamp.util.datastructure.MyArrayList;
import com.mentormate.devcamp.util.interfaces.Iterator;
import com.mentormate.devcamp.util.interfaces.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayListTests {
    private List<String> list;
    private static final int INITIAL_SIZE = 0;

    @BeforeEach
    public void init() {
        list = new MyArrayList<>();
    }

    @Test
    public void addObject_successfulAdd_objectIsTheSameTypeAsList() {
        Assertions.assertEquals(INITIAL_SIZE, list.size());
        list.add("test");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void addObject_successfulAddAtTheEnd_objectIsTheSameTypeAsList() {
        list.add("test");
        list.add("test2");
        Assertions.assertEquals("test2", list.get(1));
    }

    @Test
    public void getObjectByIndex_successfulGet_index() {
        list.add("test");
        list.add("test2");
        list.add("test3");
        Assertions.assertEquals("test3", list.get(2));
    }

    @Test
    public void insertObject_successfulInsertAtIndex_indexAndValidObject() {
        list.add("1");
        list.add("2");
        list.add("4");
        list.insert(2, "3");
        Assertions.assertEquals("3", list.get(2));
    }

    @Test
    public void insertObject_exceptionThrown_invalidIndexAndValidObject() {
        list.add("1");
        list.add("2");
        list.add("4");
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(10, "3"));
    }

    @Test
    public void deleteObjectByIndex_successfulDeletion_validIndex() {
        list.add("1");
        list.add("2");
        list.add("4");
        list.delete(1);
        Assertions.assertEquals(list.size(), 2);
        Assertions.assertFalse(list.contains("2"));
    }

    @Test
    public void deleteObjectByIndex_exceptionThrown_invalidIndex() {
        list.add("1");
        list.add("2");
        list.add("4");
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(102));
    }

    @Test
    public void deleteObjectByObject_successfulDeletion_validObject() {
        list.add("1");
        list.add("2");
        list.add("4");
        Assertions.assertTrue(list.contains("2"));
        Assertions.assertTrue(list.delete("2"));
        Assertions.assertFalse(list.contains("2"));
    }

    @Test
    public void deleteObjectByObject_falseBooleanToBeReturned_validObject() {
        list.add("1");
        list.add("2");
        list.add("4");
        Assertions.assertFalse(list.contains("5"));
        Assertions.assertFalse(list.delete("5"));
    }

    @Test
    public void deleteObjectByObject_shouldReturnFalse_nullObject() {
        Assertions.assertFalse(list.delete(null));
    }

    @Test
    public void deleteObjectByObject_shouldReturnTrue_nullObject() {
        list.add(null);
        Assertions.assertTrue(list.delete(null));
    }

    @Test
    public void sizeMethod_trueBooleanToBeReturned() {
        Assertions.assertEquals(0, list.size());
        list.add("test");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void isEmptyMethod_trueBooleanToBeReturned() {
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void clearMethod_listShouldClearAllItems() {
        list.add("1");
        list.add("1");
        list.add("1");
        Assertions.assertEquals(3, list.size());
        list.clear();
        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void iteratorMethod_returnNewIteratorInstance() {
        Iterator iterator = list.iterator();
        Assertions.assertNotNull(iterator);
    }

    @Test
    public void setMethod_newValueToBeSetAtIndex_validIndex() {
        list.add("123");
        list.set(0, "5");
        Assertions.assertEquals("5", list.get(0));
    }

    @Test
    public void toString_validStringToBeReturned() {
        list.add("1");
        list.add("2");
        Assertions.assertEquals("[1, 2]", list.toString());
    }

    @Test
    public void listConstructor_shouldCreateValidArrayFromList_validList() {
        list.add("1");
        list.add("2");
        List<String> copy = new MyArrayList<>(list);
        Assertions.assertEquals(list, copy);
    }

    @Test
    public void initialCapacityConstructor_shouldCreateValidArray_validSize() {
        List<String> copy = new MyArrayList<>(10);
        Assertions.assertEquals(10, copy.size());
    }

    @Test
    public void initialCapacityConstructor_shouldCreateValidArray_invalidSize() {
        Assertions.assertThrows(NegativeArraySizeException.class, () -> {
            List<String> copy = new MyArrayList<>(-2);
        });
    }

    @Test
    public void growSize_shouldDoubleItsSize() {
        List<String> test = new MyArrayList<>(1);
        Assertions.assertDoesNotThrow(() -> test.add("1"));
    }

    @Test
    public void indexOfMethod_shouldReturnTheIndexOfTheElement_validElement() {
        list.add("test");
        Assertions.assertEquals(0, list.indexOf("test"));
    }

    @Test
    public void indexOfMethod_shouldReturnMinusOne_nullElement() {
        Assertions.assertEquals(-1, list.indexOf(null));
    }

}
