package com.lesson01;

/**
 * Created by ibraga on 24/11/2015.
 */

import java.util.Arrays;

public class ArrayUtilsHandMade implements IArrayUtils
{

    public void printCharArray(char[] arr)
    {
        for (int row = 0; row < arr.length; row++)
        {
            System.out.println(arr[row]);
        }
    }

    public void printStringArray(String[][] arr)
    {
        for (int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr.length; col++)
            {
                System.out.println(arr[row][col]);
            }

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
                invertarray[row][col] = (arr[row][col] < 0 ? -arr[row][col] : arr[row][col]);
            }
        }
        return invertarray;
    }

    public int getMax(int first, int second)
    {
        System.out.println("Execution 1-2");
        return (first > second ? first : second);
    }

    public int getMax(int first, int second, int third)
    {
        System.out.println("Execution 1-2-3");
        return getMax(first, second, third);
    }

    public int getMax(int first, int second, int third, int fourth, int fifth)
    {
        System.out.println("Execution 1-2-3-4-5");
        return getMax(getMax(first, second, third), fourth, fifth);
    }

    public String charArrayToString(char[] arr)
    {
        return String.valueOf(arr);
    }

    public boolean lookupCharArray(char[] data, char[] template)
    {
        int datasize = data.length;
        int templsize = template.length;
        int idx = 0;
        int occur = -1;
        int exact = 0;
        char[] datacut = new char[template.length];

        //Validate arrays size
        if (datasize == 0 || templsize == 0 || templsize >  datasize) { return false; }

        //Search first character occurrence
        while (idx < datasize - templsize + 1)
        {
            if (data[idx] == template[0])
            {
                System.arraycopy(data, idx, datacut, 0, templsize);
                if (Arrays.equals(datacut, template)) {return true;}
                /*
                occur = idx;
                for (int tmplidx = 0; tmplidx < templsize; tmplidx++)
                {
                    if (data[occur + tmplidx] == template[tmplidx])
                    {
                        exact++;
                    }
                    else
                    {
                        break;
                    }
                }
                if (exact == templsize) {System.out.println(occur); return true;}
                */
            }
            idx++;
        }
        return false;

    }
    public int lookupIntArray(int[] data, int template, boolean invertdirection)
    {
        return -1;
    }

    public int getFactorial(int base)
    {
        return 1;
    }

    public boolean isLeapYear(int year)
    {
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
