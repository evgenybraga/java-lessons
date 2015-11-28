package com.lesson01;

/**
 * Created by ibraga on 24/11/2015.
 */
import java.util.*;

public class ArrayUtilsBuiltIn implements IArrayUtils
{

    public void printCharArray(char[] arr)
    {
          System.out.println(Arrays.toString(arr));
    }

    public void printStringArray(String[][] arr)
    {
        for (int row = 0; row < arr.length; row++)
        {
            System.out.println(Arrays.toString(arr[row]));
        }
    }

    public char[][] decodeIntArrayToASCIICode(int[][] arr)
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

    public int[][] invertIntArraySign(int[][] arr)
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

    public int getMax(int first, int second)
    {
        System.out.println("Execution 1-2");
        return Math.max(first, second);
    }

    public int getMax(int first, int second, int third)
    {
        System.out.println("Execution 1-2-3");
        return Math.max(Math.max(first, second), third);
    }

    public int getMax(int first, int second, int third, int fourth, int fifth)
    {
        System.out.println("Execution 1-2-3-4-5");
        return getMax(getMax(first, second, third), fourth, fifth);
    }

    public String charArrayToString(char[] arr)
    {
        return new String(arr);
    }

    public boolean lookupCharArray(char[] data, char[] template)
    {
        String datastr = charArrayToString(data);
        String templatestr = charArrayToString(template);
        return (datastr.indexOf(templatestr) != -1);
    }

    public int lookupIntArray(int[] data, int template, boolean invertdirection)
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

    public int getFactorial(int base)
    {
        if (base < 0 ) //throw new IllegalArgumentException("Function argument base = " + base + " should be greater or equal to zero");// ????????? ??????????????
        {
            return 0;
         }
        return (base == 0  ? 1 : base * getFactorial(base - 1));
    }

    public boolean isLeapYear(int year)
    {

        if (year > 0)
        {
            return (year%4 == 0 && (year%100 != 0 || year%400 == 0));
        }
        return false;
    }

    public String[] filterStringArray(String[] data, String template)
    {
        return null;
    }

    public int[] filterByMutiplicity(int[] data, int divisor)
    {
        return data;
    }

    public double round(double base)
    {
        return 0;
    }

    public int[] sortArrayAsc(int[] data)
    {
     return data;
    }

    public int[] sortArrayDesc(int[] data)
    {
        return data;
    }

    public int[] sortArray(int[] data, boolean ascending)
    {
        return data;
    }

    public boolean isDuplicatesExists(byte[] data)
    {
        return false;
    }


}
