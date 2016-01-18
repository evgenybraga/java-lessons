package com.list;

import java.util.Iterator;

public class CustomLinkedList<E> implements List<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        Node(Node<E> previous, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    Node<E> getNode(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    @Override
    public void add(E value) {
        Node<E> backupLast = last;
        Node<E> newNode = new Node<E>(backupLast, value, null);
        last = newNode;
        if (backupLast == null)
            first = newNode;
        else
            backupLast.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");
        //if add to end then just add
        if (index == size)
            add(value);
        else {
            // Node from right to re-link previous
            Node<E> right = getNode(index);

            // Node from left to re-link next
            Node<E> left = right.previous;

            Node<E> newNode = new Node<E>(left, value, right);
            // re-link previous
            right.previous = newNode;

            if (left == null)
                // if add to begin
                first = newNode;
            else
                // re-link next
                left.next = newNode;
            size++;
        }
    }

    @Override
    public E set(int index, E value) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");
        Node<E> node = getNode(index);
        E oldValue = node.item;
        node.item = value;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");

        Node<E> trash = getNode(index);
        E content = trash.item;

        //Save next prev references
        Node<E> next = trash.next;
        Node<E> previous = trash.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            trash.previous = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            trash.next = null;
        }
        trash.item = null;
        size--;
        return content;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Node<E> current = first;
        while (current != null) {
            Node<E> next = current.next;
            current.item = null;
            current.next = null;
            current.previous = null;
            current = next;
            size--;
        }
    }

    @Override
    public E get(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");
        return getNode(index).item;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        for (Node<E> element = first; element != null; element = element.next) {
            if ((value != null && value.equals(element.item)) || (value == null && element.item == null))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        int index = size;
        for (Node<E> x = last; x != null; x = x.previous) {
            index--;
            if ((value == null && x.item == null) || (value != null && value.equals(x.item)))
                return index;
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

}
