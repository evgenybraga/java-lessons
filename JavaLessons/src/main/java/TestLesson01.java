/**
 * Created by ibraga on 24/11/2015.
 */

import com.list.CustomArrayList;
import com.list.CustomLinkedList;
import com.list.List;
import com.utilities.Converter;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestLesson01 {

    public static void main(String[] args) {
        List<String> list = new CustomArrayList<String>();
        list.add("String 0");
        list.add("String 1");
        list.add("String 2");
        System.out.println("args = [" + list.get(0) + "]");
        System.out.println("args = [" + list.get(1) + "]");
        System.out.println("args = [" + list.get(2) + "]");
        System.out.println("args = [" + list.get(3) + "]");
    }
}