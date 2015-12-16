package com.utilities;

/**
 * Created by ibraga on 14/12/2015.
 */
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


    public static int parseInt(String value) throws NumberFormatException{
        int result = 0;
        char firstChar = value.charAt(0);
        boolean negative = ('-' == firstChar ? true:false);
        int length = value.length();
        char digit;
        for (int position = ('-' == firstChar || '+' == firstChar ? 1:0); position < length; position++){
            digit = value.charAt(position);
            result = (result * 10) + (int)digit - 48;
        }
        return negative ? -result : result;
    }

    public static String toString(double value) throws NumberFormatException {
        //Initial length
        long integerPart = 0;
        double floatPart = value % 1d;
        StringBuilder result = new StringBuilder();
        integerPart = (long)Math.abs(value);
        while (integerPart >= 1){
            result.append(integerPart % 10);
            integerPart /= 10.0;
            System.out.println("integerPart = [" + integerPart + "]");
        }
        return String.valueOf(result);
    }

    public static double parseDouble(String value) throws NumberFormatException {

        return Double.parseDouble(value);
    }

}
