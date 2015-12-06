package com.lesson01;

/**
 * Created by ibraga on 24/11/2015.
 */

import java.lang.reflect.Array;
import java.util.*;

public class ArrayUtils {

    public static void printArray(char[] data) {
        System.out.print("[");
        for (int row = 0; row < data.length; row++){
            System.out.print(data[row]);
            if (row == data.length - 1) {
                System.out.println("]");
            }
            else {
            System.out.print(", ");
            }
        }
    }

    public static void printArray(String[][] data) {

        for (int row = 0; row < data.length; row++) {
            System.out.print("[");
            for (int column = 0; column < data[row].length; column++)
            {
                System.out.print(data[row][column]);
                if (column == data[row].length - 1) {
                        System.out.print("]");
                }
                else{
                        System.out.print(", ");
                    }
                }
            System.out.println();
            }
    }


    public static char[][] decodeASCIIArray(int[][] asciiCodes) {
        char[][] asciiChars = new char[asciiCodes.length][];
        for (int row = 0; row < asciiCodes.length; row++) {
            asciiChars[row] = new char [asciiCodes[row].length];
            for (int column = 0; column < asciiCodes[row].length; column++) {
                asciiChars[row][column] = (char)asciiCodes[row][column];
            }
        }
        return asciiChars;
    }

    public static void invertArraySign(int[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                data[row][column] = -data[row][column];
            }
        }
    }

    public static int max(int first, int second) {
        return (first > second ? first:second);
    }

    public static int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

    public static int max(int first, int second, int third, int fourth, int fifth) {
        return max(max(first, second, third), fourth, fifth);
    }

    public static String toString(char[] data) {
        return new String(data);
    }

    public static boolean containsArray(char[] data, char[] key) {
        //Last position for start search
        int endPosition = data.length - key.length + 1;
        int startIndex = 0;
        boolean found = false;
        while (startIndex < endPosition){
            for (int keyIndex = 0; keyIndex < key.length; keyIndex++){
                //As only current character not equal to key character break inner loop
                if (!(data[startIndex + keyIndex] == key[keyIndex])){
                    startIndex++;
                    found = false;
                    break;
                }
                else {
                    found = true;
                }
            }
            //If after inner loop @found = true then exit
            if (found) return found;
        }
        return false;
    }

    public static int indexOf(int[] data, int key) {
        int size = data.length;
        int idx = 0;

        while (idx < size) {
            if (data[idx] == key) {
                return idx;
            }
            else {
                idx++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(int[] data, int key) {
        int size = data.length;
        int dataIndex = size - 1;
        while (dataIndex >= 0) {
            if (data[dataIndex] == key) {return dataIndex;
            }
            else {
                dataIndex--;
            }
        }
        return -1;
    }


    public static int factorial(int base)
    {
        if (base < 0){
            return 0;
        }
        return (base == 0 ? 1 : base * factorial(base - 1));
    }

    public static boolean isLeapYear(int year) {
        if (year > 0) {
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        }
        return false;
    }

    public static String[] filterArray(String[] data, String template) {
        String [] outDataUncut = new String [data.length];
        int outDataIdx = 0;
        if (data.length > 0) {
            for (String row : data) {
               if (row.contains(template)){
                   outDataUncut[outDataIdx] = row;
                   outDataIdx++;
               }
            }
        }
        String [] outDataCut = new String[outDataIdx];
        System.arraycopy(outDataUncut, 0, outDataCut, 0, outDataCut.length);
        return outDataCut;
    }

    public static void printMultiples(int[] data, int divisor) {
        if (data.length > 0 && divisor != 0) {
            for (int row = 0; row < data.length; row++) {
                if (data[row] % divisor == 0) {
                    System.out.println(data[row]);
                }
            }
        }
    }

    public static double round(double base, int precision) {
        return Math.round(base * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    // without sort, one loop, one additional array
    public static boolean isDuplicatesExists(byte[] data) {
        int size = data.length;
        switch (size) {
            case 0:
                return false;
            case 1:
                return true;
            default: {
                int[] dataint = new int[size];
                for (int idx = 0; idx < size; idx++) {
                    dataint[idx] = data[idx];
                }
                MergeSort ms = new MergeSort(dataint);
                //System.arraycopy(data, 0, dataint, 0, size);
                ms.sort(false);
                for (int idx = 0; idx < size - 1; idx++) {
                    if (dataint[idx] == dataint[idx + 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String toString(int data) {
        int intLength = data < 0 ? 2 : 1;
        int reminder = Math.abs(data);
        char[] numRef = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        //System.out.println("Data = " + data);
        while (reminder >= 10) {
            reminder = reminder / 10;
            intLength++;
        }
        //System.out.println("Size =  " + intLength);
        char[] intSplit = new char[intLength];
        intSplit[0] = '-';
        int absdata = Math.abs(data);
        for (int intpos = (data < 0 ? 1 : 0); intpos < intLength; intpos++) {
            intSplit[intLength - intpos] =
                    numRef[((absdata - (absdata / (int) Math.pow(10, intpos)) * (int) Math.pow(10, intpos))) / (int) Math.pow(10, intpos - 1)];
        }
        return new String(intSplit);
    }
}
