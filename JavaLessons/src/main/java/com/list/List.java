package com.list;

import java.util.Iterator;

public interface List<E> {
    void add(E value);

    void add(int index, E value);

    E set(int index, E value);

    E remove(int index);

    int size();

    boolean isEmpty();

    void clear();

    E get(int index);

    int indexOf(E value);

    int lastIndexOf(E value);

    boolean contains(E value);

    Iterator iterator();
}