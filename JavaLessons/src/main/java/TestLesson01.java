/**
 * Created by ibraga on 24/11/2015.
 */

import com.io.FileManager;

public class TestLesson01 {

    public static void main(String[] args) {
        System.out.println(FileManager.calculateFiles("C:\\Temp"));
        System.out.println(FileManager.calculateFiles("C:\\Windows\\System32\\LogFiles\\"));

        System.out.println(FileManager.calculateFiles("C:\\Windows\\System32"));
    }
}