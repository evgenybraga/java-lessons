package com.lesson01;

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
    private final static String[][] stringArray2d = {{"1", "2"}, {"3", "4"}, {"5", "6"}};
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
        assertEquals("[ 1, 2, 3, 4, 5, 6, 7 ]\r\n", outContent.toString());
    }

    @Test
    public void testPrintArray2d() throws Exception {
        ArrayUtils.printArray(stringArray2d);
        assertEquals("123456\r\n", outContent.toString());
    }

    @Test
    public void testDecodeArrayToASCIICode() throws Exception {

    }

    @Test
    public void testInvertArraySign() throws Exception {

    }

    @Test
    public void testMax() throws Exception {

    }

    @Test
    public void testMax1() throws Exception {

    }

    @Test
    public void testMax2() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testLookupArray() throws Exception {

    }

    @Test
    public void testLookupArray1() throws Exception {

    }

    @Test
    public void testGetFactorial() throws Exception {

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