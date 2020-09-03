package com.mentormate.devcamp.util.datastructure;

import com.mentormate.devcamp.util.interfaces.Deque;
import com.mentormate.devcamp.util.interfaces.List;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements List<E>, Deque<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void linkFirst(E element) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f==null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next==null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l==null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev==null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private void unlink(Node<E> x) {
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev==null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next==null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
    }

    private void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred==null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    @Override
    public void addFirst(E var1) {
        linkFirst(var1);
    }

    @Override
    public void addLast(E var1) {
        linkLast(var1);
    }

    @Override
    public boolean offerFirst(E var1) {
        addFirst(var1);
        return true;
    }

    @Override
    public boolean offerLast(E var1) {
        addLast(var1);
        return true;
    }

    @Override
    public E removeFirst() {
        final Node<E> f = first;
        if (f==null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    @Override
    public E removeLast() {
        final Node<E> l = last;
        if (l==null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    @Override
    public E pollFirst() {
        final Node<E> f = first;
        return (f==null) ? null:unlinkFirst(f);
    }

    @Override
    public E pollLast() {
        final Node<E> l = last;
        return (l==null) ? null:unlinkLast(l);
    }

    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (f==null)
            throw new NoSuchElementException();
        return f.item;
    }

    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l==null)
            throw new NoSuchElementException();
        return l.item;
    }

    @Override
    public boolean add(E value) {
        linkLast(value);
        return true;
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        checkPositionIndex(index); //Throws the exception
        if (index==size)
            linkLast(value);
        else
            linkBefore(value, node(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException();
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);
        unlink(node(index));
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        checkElementIndex(index);
        Node<E> x = node(index);
        x.item = value;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    @Override
    public boolean delete(E value) {
        if (value==null) {
            for (Node<E> x = first; x!=null; x = x.next) {
                if (x.item==null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x!=null; x = x.next) {
                if (value.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;
        if (value==null) {
            for (Node<E> x = first; x!=null; x = x.next) {
                if (x.item==null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x!=null; x = x.next) {
                if (value.equals(x.item))
                    return index;
                index++;
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
        for (Node<E> x = first; x!=null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public boolean offer(E var1) {
        return add(var1);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        final Node<E> f = first;
        return (f==null) ? null:unlinkFirst(f);
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        final Node<E> f = first;
        return (f==null) ? null:f.item;
    }
}
