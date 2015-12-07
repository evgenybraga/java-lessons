/**
 * Created by ibraga on 24/11/2015.
 */
import com.lesson01.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Date;
import java.sql.Timestamp;

public class TestLesson01 {


    //public static char[] testchar1x = new char[10000000];
    //public static char[] tmplchar = new char[39500];

    public static char[] testchar1x = {'1', '2', '3', '4', '5', '6', '7'};
    public static char[] tmplchar = {'1', '2', '3', '%', '5', '6', '7'};

    public static String[] teststr1x = {"3", "4", "3", "4", "5", "4", "7"};
    public static String[][] teststr2x = {{"1", "2", "3", "4"}, {"5", "6"}, {"7", "8", "9"}};

    public static int[] testint1x = {1, 2, 3, 4, 4, 3, 2, 1};
    public static int[][] testint2x = {{65, 66},{67, 68, 69},{70, 71}};

    public static byte[] testbyte1x = {1, 2, 3, 4, 5};

    /*
    static
    {
        Random random = new Random();
        for (int row = 0; row < testint2x.length; row++)
        {
            for (int col = 0; col < testint2x[row].length; col++)
            {
                testint2x[row][col] = random.nextInt(32000);
            }
        }

        random = new Random();
        for (int row = 0; row < testint1x.length; row++)
        {
            testint1x[row] = random.nextInt(100);
        }

        int strlength = 10;
        String st = new String();
        int rndch = 0;

        for (int row = 0; row < teststr1x.length; row++)
        {
            while (st.length() < strlength)
            {
                rndch = random.nextInt(122);
                if (rndch >= 48 && rndch <= 122)
                {
                    st = st.concat(String.valueOf((char)rndch));
                }
            }
            teststr1x[row] = st;
            st = new String();
        }

        random = new Random();
        for(int row = 0; row < tmplchar.length; row++){
            tmplchar[row] = (char)(random.nextInt(255));
        }

    }
*/
    public static void main(String[] args) {
        System.out.println(new Timestamp(new Date().getTime()));
/*
        ArrayUtils.printArray(testchar1x);
        ArrayUtils.printArray(teststr2x);
        char[][] ascii = {{'0', '0'}, {'0', '0', '0'}, {'0', '0'}};

        ascii = ArrayUtils.decodeASCIIArray(testint2x);

        for (int i = 0; i < testint2x.length; i++)
        {
            System.out.println(Arrays.toString(ascii[i]));
        }


        for (int i = 0; i < testint2x.length; i++)
        {
            System.out.println(Arrays.toString(testint2x[i]));
        }

        ArrayUtils.invertArraySign(testint2x);

        for (int i = 0; i < testint2x.length; i++)
        {
            System.out.println(Arrays.toString(testint2x[i]));
        }
*/
        //System.out.println(ArrayUtils.max(5, 4, 3, 2, 1));

        //System.out.println(ArrayUtils.toString(testchar1x));

        //System.out.println(ArrayUtils.containsArray(testchar1x, tmplchar));

        /*
        System.out.println(ArrayUtils.indexOf(testint1x, 1));
        System.out.println(ArrayUtils.indexOf(testint1x, 4));
        System.out.println(ArrayUtils.indexOf(testint1x, -1));
        System.out.println(ArrayUtils.lastIndexOf(testint1x, 1));
        System.out.println(ArrayUtils.lastIndexOf(testint1x, 4));
        System.out.println(ArrayUtils.lastIndexOf(testint1x, -1));
        */

        /*
        for (int i = 1970; i < 2020; i++)
        {
            if (ArrayUtils.isLeapYear(i)) {System.out.println("Year " + i + " is a leap");}
            System.out.println("Year " + i + " is a " + ArrayUtils.isLeapYear(i));
        }
        */



        //System.out.println(Arrays.toString(teststr1x));
        //System.out.println(Arrays.toString(ArrayUtils.filterArray(teststr1x, "4")));



        //ArrayUtils.printMultiples(testint1x, 3);
        ArrayUtils.printRound(1236.554545456);

        //System.out.println(Arrays.toString(testint1x));
        //MergeSort ms = new MergeSort(testint1x);
        //ms.sort(true);
        //System.out.println(Arrays.toString(testint1x));
        //System.out.println(new Timestamp(new Date().getTime()));

        //System.out.println(ArrayUtils.isDuplicatesExists(testbyte1x));
        /*
        System.out.println("Size = " + ArrayUtils.toString(-952));
        System.out.println("Size = " + ArrayUtils.toString(-1));
        System.out.println("Size = " + ArrayUtils.toString(0));
        System.out.println("Size = " + ArrayUtils.toString(-0));
        System.out.println("Size = " + ArrayUtils.toString(1));
        System.out.println("Size = " + ArrayUtils.toString(952));
        */




        //System.out.println(ArrayUtils.toString(-665686));

    }
}