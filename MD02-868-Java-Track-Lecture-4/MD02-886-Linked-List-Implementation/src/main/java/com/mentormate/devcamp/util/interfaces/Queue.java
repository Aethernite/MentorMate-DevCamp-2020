package com.mentormate.devcamp.util.interfaces;

/**
 * The interface Queue.
 *
 * @param <E> the type parameter
 */
public interface Queue<E> {
    /**
     * Add an element to the queue.
     *
     * @param var1 the element
     * @return boolean if successfully added
     */
    boolean add(E var1);

    /**
     * Offer an element to the queue.
     *
     * @param var1 the the element
     * @return boolean if successfully added
     */
    boolean offer(E var1);

    /**
     * Remove first element in the queue.
     *
     * @return the removed element
     */
    E remove();

    /**
     * Poll the first element in the queue.
     *
     * @return the removed element
     */
    E poll();

    /**
     * Element e.
     *
     * @return the next element in the queue
     */
    E element();

    /**
     * Peek the next element in the queue.
     *
     * @return the element without removing from queue
     */
    E peek();
}
