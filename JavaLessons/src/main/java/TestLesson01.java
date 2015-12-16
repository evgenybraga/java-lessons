/**
 * Created by ibraga on 24/11/2015.
 */
import com.list.CustomArrayList;
import com.list.CustomLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestLesson01 {

    public static void main(String[] args) {
/*      System.out.println(Converter.toString(123.456789));
        System.out.println(Converter.toString(123.987654));*/
        //CustomArrayList a = new CustomArrayList();
        CustomLinkedList a = new CustomLinkedList();
        a.add("String 0");
        a.add("String 1");
        a.add(2, "String 4");
        a.add(2, "String 2");
        a.add(3, "String 3");
        a.add("String 5");
        System.out.println(a.indexOf( "String 0"));
        a.remove(1);
        System.out.println(a.lastIndexOf("String 0"));
        System.out.println(a.contains("String 4"));
        System.out.println(a.contains("String 6"));
        for (int i = 0; i < a.size(); i++){
            System.out.println(a.get(i).toString());
        }
        System.out.println(a.size());

        System.out.println("Native Linked List");
        LinkedList<String> lst = new LinkedList<String>();
        //ArrayList<String> lst = new ArrayList<String>();
        lst.add("String 0");
        lst.add("String 1");
        lst.add(2, "String 4");
        lst.add(2, "String 2");
        lst.add(3, "String 3");
        lst.add("String 5");
        System.out.println(lst.indexOf( "String 0"));
        lst.remove(1);
        System.out.println(lst.lastIndexOf("String 0"));
        System.out.println(lst.contains("String 4"));
        System.out.println(lst.contains("String 6"));
        for (int i = 0; i < lst.size(); i++){
            System.out.println(lst.get(i).toString());
        }
        System.out.println(lst.size());



    }
}