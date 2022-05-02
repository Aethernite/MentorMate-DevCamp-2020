package com.mentormate.devcamp.util.interfaces;

/**
 * The interface Deque.
 *
 * @param <E> the type parameter
 */
public interface Deque<E> extends Queue<E> {

    /**
     * Add element to the first position of the deque.
     *
     * @param var1 the element
     */
    void addFirst(E var1);

    /**
     * Add element to the last position of the deque.
     *
     * @param var1 the element
     */
    void addLast(E var1);

    /**
     * Offers element at the first position of the deque.
     *
     * @param var1 the element
     * @return the boolean
     */
    boolean offerFirst(E var1);

    /**
     * Offers element at the last position of the deque.
     *
     * @param var1 the element
     * @return the boolean
     */
    boolean offerLast(E var1);

    /**
     * Removes first element in the deque.
     *
     * @return the removed element
     */
    E removeFirst();

    /**
     * Remove last element in the deque.
     *
     * @return the removed element
     */
    E removeLast();

    /**
     * Poll first element.
     *
     * @return the element
     */
    E pollFirst();

    /**
     * Poll last element.
     *
     * @return the element
     */
    E pollLast();

    /**
     * Gets first element in the deque.
     *
     * @return the first element
     */
    E getFirst();

    /**
     * Gets last.
     *
     * @return the last element in the deque
     */
    E getLast();
}
