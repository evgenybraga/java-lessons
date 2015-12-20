package com.utilities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ibraga on 20/12/2015.
 */
public class MergeSortTest {

    int[] direct;
    int[] invert;

    @Before
    public void setUp() throws Exception {
        direct = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        invert = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void testSortDirect() throws Exception {
        MergeSort sorter = new MergeSort(direct);
        sorter.sort(false);
        assertArrayEquals(invert, direct);
    }

    @Test
    public void testSortInvert() throws Exception {
        MergeSort sorter = new MergeSort(invert);
        sorter.sort(true);
        assertArrayEquals(direct, invert);
    }
}