/**
 * Created by ibraga on 24/11/2015.
 */

import com.list.CustomArrayList;
import com.list.CustomLinkedList;
import com.utilities.Converter;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestLesson01 {

    public static void main(String[] args) {
        System.out.println(Converter.toString(-0.0));
        System.out.println(Converter.toString(0.0));
        System.out.println(Converter.toString(-0.1d));
        System.out.println(Converter.toString(0.1d));
        System.out.println(Converter.toString(-0.456d));
        System.out.println(Converter.toString(0.456d));
        System.out.println(Converter.toString(1.0d));
        System.out.println(Converter.toString(-1.0d));
        System.out.println(Converter.toString(123.0d));
        System.out.println(Converter.toString(-123.0d));
    }
}