package com.lesson01;

import java.util.Arrays;
import java.math.BigInteger;

/**
 * Created by ibraga on 28/11/2015.
 */
public interface IArrayUtils {

    public void printCharArray(char[] arr);

    public void printStringArray(String[][] arr);

    public char[][] decodeIntArrayToASCIICode(int[][] arr);

    public int[][] invertIntArraySign(int[][] arr);

    public int getMax(int first, int second);

    public int getMax(int first, int second, int third);

    public int getMax(int first, int second, int third, int fourth, int fifth);

    public String charArrayToString(char[] arr);

    public boolean lookupCharArray(char[] data, char[] template);

    public int lookupIntArray(int[] data, int template, boolean invertdirection);

    public int getFactorial(int base);

    public boolean isLeapYear(int year);

    public String[] filterStringArray(String[] data, String template);

    public int[] filterByMutiplicity(int[] data, int divisor);

    public double round(double base);

    public int[] sortArrayAsc(int[] data);

    public int[] sortArrayDesc(int[] data);

    public int[] sortArray(int[] data, boolean ascending);

    public boolean isDuplicatesExists(byte[] data);
}
