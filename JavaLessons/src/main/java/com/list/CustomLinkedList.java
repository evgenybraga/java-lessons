package com.list;

public class CustomLinkedList implements List {

    private static class Node {
        Object item;
        Node next;
        Node previous;

        Node(Node previous, Object element, Node next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size = 0;
    private Node first;
    private Node last;


    public CustomLinkedList() {
    }

    Node getNode(int index) {
        Node current = first;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    public void add(Object value) {
        Node backupLast = last;
        Node newNode = new Node(backupLast, value, null);
        last = newNode;
        if (backupLast == null)
            first = newNode;
        else
            backupLast.next = newNode;
        size++;
    }

    public void add(int index, Object value) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");
        //if add to and then just add
        if (index == size)
            add(value);
        else {
            // Node from right to re-link previous
            Node right = getNode(index);

            // Node from left to re-link next
            Node left = right.previous;

            Node newNode = new Node(left, value, right);
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

    public Object set(int index, Object value) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");
        Node node = getNode(index);
        Object oldValue = node.item;
        node.item = value;
        return oldValue;
    }

    public Object remove(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");

        Node trash = getNode(index);
        Object content = trash.item;

        //Save next prev references
        Node next = trash.next;
        Node previous = trash.previous;

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.item = null;
            current.next = null;
            current.previous = null;
            current = next;
            size--;
        }
    }

    public Object get(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException("Index = [" + index + "]");
        return getNode(index).item;
    }

    public int indexOf(Object value) {
        int index = 0;
        for (Node element = first; element != null; element = element.next) {
            if ((value != null && value.equals(element.item)) || (value == null && element.item == null))
                return index;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        int index = size;
        for (Node x = last; x != null; x = x.previous) {
            index--;
            if ((value == null && x.item == null) || (value != null && value.equals(x.item)))
                return index;
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }
}
