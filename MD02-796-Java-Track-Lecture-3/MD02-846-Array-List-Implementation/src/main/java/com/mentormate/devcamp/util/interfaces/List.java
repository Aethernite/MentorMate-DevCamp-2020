package com.mentormate.devcamp.util.interfaces;

/**
 * The interface List.
 *
 * @param <T> the type parameter
 */
public interface List<T> extends Iterable<T> {

    /**
     * Adds an element at the end of the list
     *
     * @param value the element
     */
    void add(T value);

    /**
     * Inserts an element at the given index.
     *
     * @param index the index
     * @param value the element
     * @throws IndexOutOfBoundsException if the given index is out of the list's bounds
     */
    void insert(int index, T value) throws IndexOutOfBoundsException;

    /**
     * Delete.
     *
     * @param index the index
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    void delete(int index) throws IndexOutOfBoundsException;

    /**
     * Get t.
     *
     * @param index the index
     * @return the t
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Size int.
     *
     * @return the int
     */
    int size();

    /**
     * Sets the element at the given index to be equal to the given value
     *
     * @param index the index
     * @param value the new value
     * @throws IndexOutOfBoundsException if the index is out of the array's bounds
     */
    void set(int index, T value) throws IndexOutOfBoundsException;

    /**
     * Deletes an element by value.
     *
     * @param value the value
     * @return true if successfully found and deleted
     */
    boolean delete(T value);

    /**
     * Check is an element is contained in the list
     *
     * @param value the element
     * @return the boolean
     */
    boolean contains(T value);

    /**
     * Returns the index of the given element if exists
     *
     * @param value the value
     * @return the index or -1 if the element is not found
     */
    int indexOf(Object value);

    /**
     * Checks if the list is empty
     *
     * @return the boolean
     */
    boolean isEmpty();

    /**
     * Clears the whole list and sets it's size to zero
     */
    void clear();

}
