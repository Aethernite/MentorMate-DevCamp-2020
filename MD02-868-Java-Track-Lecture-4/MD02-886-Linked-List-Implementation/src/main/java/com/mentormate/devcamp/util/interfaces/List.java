package com.mentormate.devcamp.util.interfaces;

/**
 * The interface List.
 *
 * @param <T> the type parameter
 */
public interface List<T> extends Deque<T> {

    /**
     * Adds a value at the end of the list.
     *
     * @param value the value
     */
    public boolean add(T value);

    /**
     * Insert a value at given index.
     *
     * @param index the index
     * @param value the value
     * @throws IndexOutOfBoundsException if index is out of the list's bounds
     */
    public void insert(int index, T value) throws IndexOutOfBoundsException;

    /**
     * Delete the element at the given index.
     *
     * @param index the index
     * @throws IndexOutOfBoundsException if index is out of the list's boundss
     */
    public void delete(int index) throws IndexOutOfBoundsException;

    /**
     * Get the element at the given index.
     *
     * @param index the index
     * @return the element
     * @throws IndexOutOfBoundsException if index is out of the list's bounds
     */
    public T get(int index) throws IndexOutOfBoundsException;

    /**
     * Gets the size of the list.
     *
     * @return the size
     */
    public int size();

    /**
     * Sets the value of the given index to the given value.
     *
     * @param index the index
     * @param value the value
     * @throws IndexOutOfBoundsException if index is out of the list's bounds
     */
    public void set(int index, T value) throws IndexOutOfBoundsException;

    /**
     * Delete element by value.
     *
     * @param value the value
     * @return boolean on deletion
     */
    public boolean delete(T value);

    /**
     * Checks if element is contained in the list.
     *
     * @param value the value
     * @return if the element is contained in the list
     */
    public boolean contains(T value);

    /**
     * Returns the index of given element.
     *
     * @param value the value
     * @return the index
     */
    public int indexOf(Object value);

    /**
     * Checks if list is empty.
     *
     * @return if the list is empty
     */
    public boolean isEmpty();

    /**
     * Clears the whole list and sets the size to zero.
     */
    public void clear();
}
