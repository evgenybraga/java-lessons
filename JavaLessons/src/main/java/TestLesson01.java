/**
 * Created by ibraga on 24/11/2015.
 */
import com.list.CustomArrayList;
import com.utilities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.sql.Timestamp;

public class TestLesson01 {

    public static void main(String[] args) {
/*        System.out.println(Converter.toString(123.456789));
        System.out.println(Converter.toString(123.987654));*/
        CustomArrayList a = new CustomArrayList();
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

    }
}