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

    private List list;
    private ListFactory factory;

    public CustomListTest(ListFactory factory){
        this.factory = factory;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new ArrayListFactory()},
                {new LinkedListFactory()}
        });
    }

    private static interface ListFactory{
        public List createNewList();
    }

    private static class ArrayListFactory implements ListFactory{
        public List createNewList() {
            return new CustomArrayList();
        }
    }

    private static class LinkedListFactory implements ListFactory{
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
        assertEquals(1, list.size());
    }

    @Test
    public void testAddByIndex() throws Exception {
        list.add("String 0");
        list.add(1, "String 0");
        assertEquals(2, list.size());
    }

    @Test
    public void testSet() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testIndexOf() throws Exception {

    }

    @Test
    public void testLastIndexOf() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }
}