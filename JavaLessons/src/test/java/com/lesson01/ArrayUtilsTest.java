package com.lesson01;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by admin on 05.12.2015.
 */
public class ArrayUtilsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final static char[] charArray = {'1', '2', '3', '4', '5', '6', '7'};
    private final static String[] stringArray1d = {"1", "2", "3", "4", "5", "6"};
    private final static String[][] stringArray2d = {{"1", "2", "3"}, {"4", "5"}, {"6", "7", "8", "9", "10"}};
    public static int[]intArray1d = {65, 66, 67, 68, 69, 70, 71};
    public static int[][] intArray2d = {{65, 66},{67, 68, 69},{70, 71}};
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testPrintArray1d() throws Exception {
        ArrayUtils.printArray(charArray);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]\r\n", outContent.toString());
    }

    @Test
    public void testPrintArray2d() throws Exception {
        ArrayUtils.printArray(stringArray2d);
        assertEquals("[1, 2, 3]\r\n[4, 5]\r\n[6, 7, 8, 9, 10]\r\n", outContent.toString());
    }

    @Test
    public void testDecodeASCIIArray() throws Exception {
        char[][] result;
        char[][] expected = {{'A', 'B'}, {'C', 'D', 'E'}, {'F', 'G'}};
        result = ArrayUtils.decodeASCIIArray(intArray2d);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInvertArraySign() throws Exception {
        int[][] expected = {{-65, -66}, {-67, -68, -69}, {-70, -71}};
        ArrayUtils.invertArraySign(intArray2d);
        assertArrayEquals(expected, intArray2d);
    }

    @Test
    public void testMax() throws Exception {
        assertEquals(0,  ArrayUtils.max(0, 0));
        assertEquals(-1, ArrayUtils.max(-2, -1));
        assertEquals(1,  ArrayUtils.max(0, 1));
        assertEquals(2,  ArrayUtils.max(1, 2));
    }

    @Test
    public void testMaxThree() throws Exception {
        assertEquals(1, ArrayUtils.max(-1, 0, 1));
        assertEquals(0, ArrayUtils.max(-2, -1, 0));
        assertEquals(3, ArrayUtils.max(1, 2, 3));
        assertEquals(0, ArrayUtils.max(0, 0, 0));
    }

    @Test
    public void testMaxFive() throws Exception {
        assertEquals(1, ArrayUtils.max(-1, 0, 1, 1, -2));
        assertEquals(0, ArrayUtils.max(-2, -1, -10, 0, 0));
        assertEquals(3, ArrayUtils.max(1, 2, 3, 0, -11));
        assertEquals(0, ArrayUtils.max(0, 0, 0, 0, 0));
    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testContainsArray() throws Exception {

    }

    @Test
    public void testIndexOf() throws Exception {

    }

    @Test
    public void testLastIndexOf() throws Exception {

    }

    @Test
    public void testFactorial() throws Exception {

    }

    @Test
    public void testIsLeapYear() throws Exception {

    }

    @Test
    public void testFilterStringArray() throws Exception {

    }

    @Test
    public void testFilterArrayByMutiplicity() throws Exception {

    }

    @Test
    public void testRoundDouble() throws Exception {

    }

    @Test
    public void testIsDuplicatesExists() throws Exception {

    }

    @Test
    public void testToString1() throws Exception {

    }
}