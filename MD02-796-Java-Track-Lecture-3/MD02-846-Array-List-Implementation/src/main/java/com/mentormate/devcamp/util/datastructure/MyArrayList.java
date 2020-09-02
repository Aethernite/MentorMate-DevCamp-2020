package com.mentormate.devcamp.util.datastructure;

import com.mentormate.devcamp.util.exception.IteratorOutOfBoundsException;
import com.mentormate.devcamp.util.interfaces.Iterable;
import com.mentormate.devcamp.util.interfaces.Iterator;
import com.mentormate.devcamp.util.interfaces.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Generic Class MyArrayList.
 *
 * @param <T> the type parameter
 */
public class MyArrayList<T> implements List<T>, Iterable<T> {
    /**
     * The size of the elements inside the T[] array but not the capacity.
     */
    int size;                    // keeps track of the number of elements
    private T[] array;           // stores the elements
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Instantiates a new MyArrayList with inital capacity of 10 elements.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Instantiates a new My array list with the given size.
     *
     * @param capacity the initial capacity and size for the array.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
        size = capacity;
    }

    /**
     * Instantiates a new MyArrayList.
     *
     * @param list the input list to be copied/created as a new MyArrayList object
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(List<T> list) {
        T[] temp = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        array = temp;
        size = list.size();
    }

    @SuppressWarnings("unchecked")
    private Object[] grow() {
        T[] bigger = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, bigger, 0, array.length);
        return bigger;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(T value) {
        if (size >= array.length) {
            array = (T[]) grow();
        }
        array[size] = value;
        size++;
    }

    @Override
    public void insert(int index, T value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        final int s;
        Object[] elementData;
        if ((s = size)==(elementData = this.array).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = value;
        size = s + 1;
    }

    @Override
    public void delete(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size() - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size() - 1 - index);
            size--;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public boolean delete(T value) {
        final Object[] es = array;
        final int s = this.size;
        int i = 0;
        found:
        {
            if (value==null) {
                for (; i < s; i++)
                    if (es[i]==null)
                        break found;
            } else {
                for (; i < s; i++)
                    if (value.equals(es[i]))
                        break found;
            }
            return false;
        }
        delete(i);
        return true;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        return indexOfRange(value, size);
    }

    private int indexOfRange(Object o, int end) {
        Object[] es = array;
        if (o==null) {
            for (int i = 0; i < end; i++) {
                if (es[i]==null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        final Object[] es = array;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator();
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, size));
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o==this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        List<T> temp = (MyArrayList<T>) o;
        if (size!=temp.size()) {
            return false;
        }


        for (int i = 0; i < size; i++) {
            if (!(array[i].equals(temp.get(i)))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * The nested class ArrayIterator.
     */
    class MyArrayIterator implements Iterator<T> {
        private int index;

        /**
         * Instantiates a new ArrayIterator.
         */
        public MyArrayIterator() {
            this.index = 0;
        }

        @Override
        public void next() {
            index++;
        }

        @Override
        public void first() {
            index = 0;
        }

        @Override
        public void last() {
            index = size - 1;
        }

        @Override
        public boolean isDone() {
            return index==size;
        }

        @Override
        public void previous() {
            index--;
        }

        @Override
        public T current() throws IteratorOutOfBoundsException {
            if (size <= 0 || index >= size) {
                throw new IteratorOutOfBoundsException();
            } else return array[index];
        }
    }
}


