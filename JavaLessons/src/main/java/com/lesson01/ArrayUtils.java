package com.lesson01;

/**
 * Created by ibraga on 24/11/2015.
 */

import java.util.*;

public class ArrayUtils {

    public static void printArray(char[] array) {
        System.out.print("[ ");
        for (int row = 0; row < array.length; row++){
            System.out.print(array[row]);
            if (row == array.length - 1) {

                System.out.println(" ]");
            }
            else {
            System.out.print(", ");
            }
        }
    }

    public static void printArray(String[][] array) {
        for (int row = 0; row < array.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < array[row].length; column++)
            {
                System.out.print(array[row][column]);
                if (row == array.length - 1) {
                        System.out.println(" ]");
                }
                else{
                        System.out.print(", ");
                    }
                }
            }
        System.out.println();
    }


    //{{1,2,3}, {1,2}}
    public static char[][] decodeArrayToASCIICode(int[][] arr) {
        char[][] acsiiarray = new char[arr.length][arr[0].length];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = (char) arr[row][column];
            }
        }
        return acsiiarray;
    }
    //{{1,2,3}, {1,2}}
    public static void invertArraySign(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = -arr[row][col];
            }
        }
    }

    public static int max(int first, int second) {
        return Math.max(first, second);// ternary
    }

    public static int max(int first, int second, int third) {
        return Math.max(Math.max(first, second), third);
    }

    public static int max(int first, int second, int third, int fourth, int fifth) {
        return max(max(first, second, third), fourth, fifth);
    }

    public static String toString(char[] arr) {
        return new String(arr);
    }

    public static boolean lookupArray(char[] data, char[] template) {
        return toString(data).indexOf(toString(template)) != -1;
    }

    public static int lookupArray(int[] data, int template, boolean invertdirection) {
        int sz = data.length;
        int idx = (!invertdirection ? 0 : sz - 1);
        int incrementstep = (!invertdirection ? 1 : -1);
        while (idx >= 0 && idx < sz) {
            if (data[idx] == template) {
                //System.out.println("Can not found at " + idx);
                return idx;
            } else {
                //System.out.println(idx);
                idx += incrementstep;
            }
        }
        //System.out.println("Can not found " + template);
        return -1;
    }

    public static int getFactorial(int base)
    {
        if (base < 0){
            return 0;
        }
        return (base == 0 ? 1 : base * getFactorial(base - 1));
    }

    public static boolean isLeapYear(int year) {

        if (year > 0) {
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        }
        return false;
    }

    public static String[] filterStringArray(String[] data, String template) {
        int sz = data.length;
        ArrayList<String> outlist = new ArrayList<String>();
        if (sz > 0) {

            for (int row = 0; row < sz; row++) {
                if (data[row].contains(template)) {
                    outlist.add(data[row]);
                }
            }
        }
        return outlist.toArray(new String[outlist.size()]);
    }

    public static void filterArrayByMutiplicity(int[] data, int divisor) {
        if (data.length > 0 && divisor != 0) {
            for (int row = 0; row < data.length; row++) {
                if (data[row] % divisor == 0) {
                    System.out.println(data[row]);
                }
            }
        }
    }

    public static double roundDouble(double base, int precision) {
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
