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

        out[0] = (data == 0 ? '0':'-');

        int dataUnsigned = Math.abs(data);
        int digit = 0;

        while(dataUnsigned > 0) {
            length--;
            digit = dataUnsigned % 10;
            dataUnsigned /= 10;
            out[length] = numbers[digit];
        }
        return String.valueOf(out);
    }
}
