package com.utilities;

/**
 * Created by ibraga on 24/11/2015.
 */

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
        ArrayList<String> filtered = new ArrayList<String>();
        for (String row : data) {
            if (row.contains(template)){
                filtered.add(row);
            }
        }
        return filtered.toArray(new String[filtered.size()]);
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

    public static void printRound(double base) {
        System.out.println(String.format("%.3f", base));
    }

    // without sort, one loop, one additional array
    public static boolean isDuplicatesExists(byte[] data) {
        HashSet unique = new HashSet();
        for (byte row : data){
            if (!unique.add(row))
            {
                return true;
            }
        }
        return false;
    }

    public static String toString(int data) {
        int length = data < 0 ? 2 : 1;
        int rank = Math.abs(data);
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        while (rank >= 10) {
            rank = rank / 10;
            length++;
        }
        char[] out = new char[length];

        out[0] = (data == 0 ? '0':'-');

        int dataUnsigned = Math.abs(data);
        int digit = 0;

        while(dataUnsigned > 0) {
            length--;
            digit = dataUnsigned % 10;
            dataUnsigned /= 10;
            out[length] = numbers[digit];
        }
        return new String(out);
    }
}
