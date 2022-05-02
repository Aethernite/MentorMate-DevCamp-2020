package com.mentormate.devcamp.util.interfaces;

import com.mentormate.devcamp.util.exception.IteratorOutOfBoundsException;

/**
 * The interface Iterator.
 *
 * @param <T> the type parameter
 */
public interface Iterator<T> {

    /**
     * Sets the inner index of the iterator at 0
     */
    void first();

    /**
     * Sets the inner index of the iterator at the last index of it's size
     */
    void last();

    /**
     * Is done checks if the inner index of the iterator is set at the last index
     *
     * @return the boolean
     */
    boolean isDone();

    /**
     * Increments the inner index by one
     */
    void next();

    /**
     * Decrements the inner index by one
     */
    void previous();

    /**
     * @return the current element the inner index is pointing at
     * @throws IteratorOutOfBoundsException if the inner index is out of the array's bounds
     */
    T current() throws IteratorOutOfBoundsException;
}
