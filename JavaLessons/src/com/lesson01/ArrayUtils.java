package com.lesson01;

/**
 * Created by ibraga on 24/11/2015.
 */
import java.util.*;

public class ArrayUtils {

    public static void printCharArray(char[] arr)
    {
          System.out.println(Arrays.toString(arr));
    }

    public static void printStringArray(String[][] arr)
    {
        for (int row = 0; row < arr.length; row++)
        {
            System.out.println(Arrays.toString(arr[row]));
        }
    }

    public static char[][] decodeIntArrayToASCIICode(int[][] arr)
    {
        char [][] acsiiarray = new char[arr.length][arr[0].length];
        for (int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr.length; col++)
            {
                acsiiarray[row][col] = (char)arr[row][col];
            }
        }
        return acsiiarray;
    }

    public static int[][] invertIntArraySign(int[][] arr)
    {
        int[][] invertarray = new int[arr.length][arr[0].length];
        for (int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr.length; col++)
            {
                invertarray[row][col] = -arr[row][col];
            }
        }
        return invertarray;
    }

    public static int getMax(int first, int second)
    {
        System.out.println("Execution 1-2");
        return Math.max(first, second);
    }

    public static int getMax(int first, int second, int third)
    {
        System.out.println("Execution 1-2-3");
        return Math.max(Math.max(first, second), third);
    }

    public static int getMax(int first, int second, int third, int fourth, int fifth)
    {
        System.out.println("Execution 1-2-3-4-5");
        return getMax(getMax(first, second, third), fourth, fifth);
    }

    public static String charArrayToString(char[] arr)
    {
        return new String(arr);
    }

    public static boolean lookupCharArray(char[] data, char[] template)
    {
        String datastr = charArrayToString(data);
        String templatestr = charArrayToString(template);
        return (datastr.indexOf(templatestr) != -1);
    }

    public static int lookupIntArray(int[] data, int template, boolean invertdirection)
    {
        int sz = data.length;
        int idx = (!invertdirection ? 0 : sz - 1);
        int incrementstep = (!invertdirection ? 1 : -1);
        while (idx >= 0 && idx < sz)
        {
            if (data[idx] == template)
            {
                //System.out.println("Can not found at " + idx);
                return idx;
            }
            else
            {
                //System.out.println(idx);
                idx +=incrementstep;
            }
        }
        //System.out.println("Can not found " + template);
        return -1;
    }

    public static int getFactorial(int base)
    {
        if (base < 0 ) //throw new IllegalArgumentException("Function argument base = " + base + " should be greater or equal to zero");// ????????? ??????????????
        {
            return 0;
         }
        return (base == 0  ? 1 : base * getFactorial(base - 1));
    }

    public static boolean isLeapYear(int year)
    {

        if (year > 0)
        {
            return (year%4 == 0 && (year%100 != 0 || year%400 == 0));
        }
        return false;
    }

    public static String[] filterStringArray(String[] data, String template)
    {
        int sz = data.length;
        ArrayList<String> outlist = new ArrayList<String>();
        if (sz > 0)
        {

            for (int row = 0; row < sz; row++)
            {
                if (data[row].indexOf(template) != -1)
                {
                    outlist.add(data[row]);
                }
            }
        }
        return outlist.toArray(new String[outlist.size()]);
    }

    public static void filterIntArrayByMutiplicity(int[] data, int divisor)
    {
        if (data.length > 0  && divisor != 0)
        {
            for (int row = 0; row < data.length; row++)
            {
                if (data[row]%divisor == 0)
                {
                    System.out.println(data[row]);
                }
            }
        }
    }

    public static double roundDouble(double base, int precision)
    {
        return Math.round(base * Math.pow(10, precision))/ Math.pow(10, precision);
    }

    public static int[] sortArrayAsc(int[] data)
    {
     return data;
    }

    public static int[] sortArrayDesc(int[] data)
    {
        return data;
    }

    public static int[] sortArray(int[] data, boolean ascending)
    {
        return data;
    }

    public static boolean isDuplicatesExists(byte[] data)
    {
        return false;
    }


}
