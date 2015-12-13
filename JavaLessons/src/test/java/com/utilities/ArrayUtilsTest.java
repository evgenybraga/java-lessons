package com.utilities;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertEquals("1234567", ArrayUtils.toString(charArray));
    }

    @Test
    public void testContainsArray() throws Exception {
        assertEquals(true, ArrayUtils.containsArray(charArray, charArray));
        assertEquals(true, ArrayUtils.containsArray(charArray, new char[]{'1'}));
        assertEquals(false, ArrayUtils.containsArray(charArray, new char[]{'2', '3', '4', '9'}));

    }

    @Test
    public void testIndexOf() throws Exception {
        assertEquals(3, ArrayUtils.indexOf(intArray1d, 68));
        assertEquals(-1, ArrayUtils.indexOf(intArray1d, 0));
        assertEquals(-1, ArrayUtils.indexOf(intArray1d, -10));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        assertEquals(3, ArrayUtils.lastIndexOf(intArray1d, 68));
        assertEquals(-1, ArrayUtils.lastIndexOf(intArray1d, 0));
        assertEquals(-1, ArrayUtils.lastIndexOf(intArray1d, -10));
    }

    @Test
    public void testFactorial() throws Exception {
        assertEquals(0, ArrayUtils.factorial(-1));
        assertEquals(1, ArrayUtils.factorial(0));
        assertEquals(1, ArrayUtils.factorial(1));
        assertEquals(2, ArrayUtils.factorial(2));
        assertEquals(6, ArrayUtils.factorial(3));
    }

    @Test
    public void testIsLeapYear() throws Exception {

    }

    @Test
    public void testFilterStringArray() throws Exception {

    }

    @Test
    public void testPrintMultiples() throws Exception {
        ArrayUtils.printMultiples(intArray1d, 3);
        assertEquals("66\r\n69\r\n", outContent.toString());
    }

    @Test
    public void testPrintRound() throws Exception {
        ArrayUtils.printRound(123456789.554545456);
        assertEquals(String.format("%.3f%n",(double)123456789.554545456), outContent.toString());
    }

    @Test
    public void testIsDuplicatesExists() throws Exception {

    }

    @Test
    public void testToString2() throws Exception {
        assertEquals("-6843", ArrayUtils.toString(-6843));
        assertEquals("-1", ArrayUtils.toString(-1));
        assertEquals("0", ArrayUtils.toString(-0));
        assertEquals("0", ArrayUtils.toString(0));
        assertEquals("1", ArrayUtils.toString(1));
        assertEquals("9871", ArrayUtils.toString(9871));
    }
}