/**
 * Created by ibraga on 24/11/2015.
 */
import com.utilities.*;

import java.util.Date;
import java.sql.Timestamp;

public class TestLesson01 {

    public static void main(String[] args) {
        System.out.println(new Timestamp(new Date().getTime()));
        System.out.println(Converter.toString(123.456789));
        System.out.println(new Timestamp(new Date().getTime()));

    }
}