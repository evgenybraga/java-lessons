package com.list;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<E> implements List<E> {

    private static final int chunkSize = 3;
    private int listSize = 0;
    private E[] array;

    public CustomArrayList() {
        array = (E[]) new Object[chunkSize];
    }

    public CustomArrayList(int initial) {
        array = (E[]) new Object[initial];
    }

    private void extend() {
        if (listSize + 1 > array.length) {
            array = Arrays.copyOf(array, array.length + chunkSize);
        }
    }

    @Override
    public void add(E value) {
        extend();
        array[listSize++] = value;
    }

    @Override
    public void add(int index, E value) {
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        if (index < listSize) {
            extend();
            System.arraycopy(array, index, array, index + 1, listSize - index + 1);
            array[index] = value;
            listSize++;
        } else {
            add(value);
        }
    }

    @Override
    public E set(int index, E value) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        E old = array[index];
        array[index] = value;
        return old;
    }

    @Override
    public E remove(int index) {
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        E old = array[index];
        System.arraycopy(array, index + 1, array, index, listSize - index - 1);
        array[--listSize] = null;
        return old;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public void clear() {
        for (int index = 0; index < listSize; index++) {
            array[index] = null;
        }
        listSize = 0;
    }

    @Override
    public E get(int index) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        return array[index];
    }

    @Override
    public int indexOf(E value) {
        for (int index = 0; index < listSize; index++) {
            if (array[index].equals(value))
                return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int index = listSize - 1; index >= 0; index--) {
            if (array[index].equals(value))
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
