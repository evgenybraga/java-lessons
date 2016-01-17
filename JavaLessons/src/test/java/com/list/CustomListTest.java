package com.list;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by ibraga on 20/12/2015.
 */
@RunWith(Parameterized.class)
public class CustomListTest {

    private List<String> list;
    private ListFactory factory;

    public CustomListTest(ListFactory factory) {
        this.factory = factory;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new ArrayListFactory()},
                {new LinkedListFactory()}
        });
    }

    private static interface ListFactory {
        public List createNewList();
    }

    private static class ArrayListFactory implements ListFactory {
        public List createNewList() {
            return new CustomArrayList();
        }
    }

    private static class LinkedListFactory implements ListFactory {
        public List createNewList() {
            return new CustomLinkedList();
        }
    }


    @Before
    public void setUp() throws Exception {
        list = factory.createNewList();
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void testAdd() throws Exception {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        assertEquals(3, list.size());
    }

    @Test
    public void testAddByIndex() throws Exception {
        list.add("String 1");
        list.add(0, "String 0");
        assertEquals("String 0", list.get(0));
    }

    @Test
    public void testSet() throws Exception {
        list.add("String 1");
        list.set(0, "String 0");
        assertEquals("String 0", list.get(0));
    }

    @Test
    public void testRemove() throws Exception {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        assertEquals(3, list.size());
        list.remove(0);
        assertEquals(2, list.size());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(true, list.isEmpty());
        list.add("String 0");
        assertEquals(false, list.isEmpty());

    }

    @Test
    public void testClear() throws Exception {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        assertEquals(false, list.isEmpty());
        list.clear();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testGet() throws Exception {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        assertEquals("String 0", list.get(0));
        assertEquals("String 1", list.get(1));
        assertEquals("String 2", list.get(2));
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        assertEquals(0, list.indexOf("String 0"));
        assertEquals(-1, list.indexOf("String 9"));
    }

    @Test
    public void testLastIndexOf() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }
}