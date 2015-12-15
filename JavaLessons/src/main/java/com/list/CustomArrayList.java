package com.list;

import java.util.Arrays;

/**
 * Created by admin on 15.12.2015.
 */
public class CustomArrayList implements List {

    private static final int chunkSize = 3;
    private int listSize = 0;
    private Object[] array;

    public CustomArrayList() {
        array = new Object[chunkSize];
    }

    public CustomArrayList(int initial) {
        array = new Object[initial];
    }

    private void extend() {
        if (listSize + 1 > array.length) {
            array = Arrays.copyOf(array, array.length + chunkSize);
        }
    }

    public void add(Object value) {
        extend();
        array[listSize++] = value;
    }

    public void add(int index, Object value) {
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

    public Object set(int index, Object value) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        Object old = array[index];
        array[index] = value;
        return old;
    }

    public Object remove(int index) {
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        Object old = array[index];
        System.arraycopy(array, index + 1, array, index, listSize - index - 1);
        array[--listSize] = null;
        return old;
    }

    public int size() {
        return listSize;
    }

    public boolean isEmpty() {
        return listSize == 0;
    }

    public void clear() {
        for (int index = 0; index < listSize; index++) {
            array[index] = null;
        }
        listSize = 0;
    }

    public Object get(int index) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index [" + index + "] is out of bound");
        }
        return array[index];
    }

    public int indexOf(Object value) {
        for (int index = 0; index < listSize; index++){
            if (array[index].equals(value))
                return index;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int index = listSize - 1; index >= 0; index--){
            if (array[index].equals(value))
                return index;
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }
}
