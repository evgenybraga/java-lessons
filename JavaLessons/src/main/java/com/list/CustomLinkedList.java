package com.list;

public class CustomLinkedList implements List {

    private static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size = 0;
    private Node first;
    private Node last;


    public CustomLinkedList() {
    }


    public void add(Object value) {
    }

    public void add(int index, Object value) {
    }

    public Object set(int index, Object value) {
        return -1;
    }

    public Object remove(int index) {
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public Object get(int index) {
        return -1;
    }

    public int indexOf(Object value) {
        return -1;
    }

    public int lastIndexOf(Object value) {
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }
}
