package com.utilities;

/**
 * Created by ibraga on 14/12/2015.
 */

import java.util.regex.Pattern;

public class Converter {
    public static String toString(int data) {
        //Initial length
        int length = data < 0 ? 2 : 1;
        int rank = Math.abs(data);
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        //Calculate length for array of chars
        while (rank >= 10) {
            rank /= 10;
            length++;
        }
        char[] out = new char[length];

        out[0] = (data == 0 ? '0' : '-');

        int dataUnsigned = Math.abs(data);
        int digit = 0;

        while (dataUnsigned > 0) {
            length--;
            digit = dataUnsigned % 10;
            dataUnsigned /= 10;
            out[length] = numbers[digit];
        }
        return String.valueOf(out);
    }


    public static int parseInt(String value) throws NumberFormatException {
        int result = 0;
        char firstChar = value.charAt(0);
        boolean negative = ('-' == firstChar ? true : false);
        int length = value.length();
        char digit;
        for (int position = ('-' == firstChar || '+' == firstChar ? 1 : 0); position < length; position++) {
            digit = value.charAt(position);
            result = (result * 10) + (int) digit - 48;
        }
        return negative ? -result : result;
    }

    public static String toString(double value) throws NumberFormatException {
        if (value == 0) {
            return "0.0";
        }
        StringBuilder result = new StringBuilder();
        double temp = Math.abs(value);
        double integerPart = (long) temp;
        int mantissaLength = 0;
        while (temp - integerPart != 0) {
            mantissaLength++;
            temp *= 10;
            integerPart = (long) temp;
        }
        long tempRanked = (long) (Math.abs(value) * Math.pow(10, mantissaLength));
        int floatPosition = 0;
        if (mantissaLength == 0)
            result.insert(0, '0');
        while (tempRanked > 0 || floatPosition <= mantissaLength) {
            if (floatPosition == mantissaLength) {
                result.insert(0, '.');
            }
            result.insert(0, tempRanked % 10);
            tempRanked /= 10;
            floatPosition++;
        }
        result.insert(0, value < 0 ? "-" : "");
        return result.toString();
    }

    public static double parseDouble(String value) throws NumberFormatException {
        char[] array = value.toCharArray();
        double result = 0;
        byte start = 0;
        byte sign = 1;
        int mantissaLength = 0;
        if (array[0] == '-') {
            sign = -1;
            start++;
        }
        for (int index = start; index < array.length; index++) {
            if (array[index] != '.') {
                result = result * 10 + array[index] - 48;
            } else {
                mantissaLength = array.length - index - 1;
            }
        }
        return sign * result / Math.pow(10, mantissaLength);
    }
}
