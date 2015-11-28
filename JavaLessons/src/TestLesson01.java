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
    public static char[] tmplchar = {'6', '7'};

    public static String[][] teststr2x = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    public static int[] testint1x = {1, 2, 3, 2, 6};
    public static int[][] testint2x = new int[3][3];

    static
    {
        Random random = new Random();
        for (int row = 0; row < testint2x.length; row++)
        {
            for (int col = 0; col < testint2x.length; col++)
            {
                testint2x[row][col] = random.nextInt(32000);
            }
        }
/*
        for(int row = 0; row < testchar1x.length; row++){
            testchar1x[row] = (char)(random.nextInt(255));
        }

        random = new Random();
        for(int row = 0; row < tmplchar.length; row++){
            tmplchar[row] = (char)(random.nextInt(255));
        }
        */
    }

    public static void main(String[] args) {
        System.out.println(new Timestamp(new Date().getTime()));
        /*
        ArrayUtilsBuiltIn.printCharArray(testchar1x);
        ArrayUtilsBuiltIn.printStringArray(teststr2x);

        for (int i = 0; i < testint2x.length; i++)
        {
            System.out.println(Arrays.toString(testint2x[i]));
        }
        System.out.println();
        for (int i = 0; i < testint2x.length; i++)
        {
            System.out.println(Arrays.toString(ArrayUtilsBuiltIn.invertIntArraySign(testint2x)[i]));
        }

        ArrayUtilsBuiltIn.invertIntArraySign(testint2x);
        */
        //System.out.println(ArrayUtilsBuiltIn.getMax(5, 4, 3, 2, 1));
        //System.out.println(ArrayUtilsBuiltIn.charArrayToString(testchar1x));
        //System.out.println(ArrayUtilsBuiltIn.lookupCharArray(testchar1x, tmplchar));
        //System.out.println(Arrays.toString(testchar1x));
        //System.out.println(Arrays.toString(tmplchar));

        ArrayUtilsBuiltIn ar = new ArrayUtilsBuiltIn();

        //System.out.println(ar.lookupCharArray(testchar1x, tmplchar));
        /*
        ar.lookupIntArray(testint1x, 1, false);
        ar.lookupIntArray(testint1x, 1, true);
        ar.lookupIntArray(testint1x, 10, false);
        ar.lookupIntArray(testint1x, 10, true);
        ar.lookupIntArray(testint1x, 2, false);
        ar.lookupIntArray(testint1x, 2, true);
        */
        for (int i = 1970; i < 2020; i++)
        {
            if (ar.isLeapYear(i)) {System.out.println("Year " + i + " is a leap");}
            //System.out.println("Year " + i + " is a " + ar.isLeapYear(i));
        }
        System.out.println(new Timestamp(new Date().getTime()));
    }
}