/**
 * Created by ibraga on 24/11/2015.
 */

import com.io.FileManager;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class TestLesson01 {

    public static void main(String[] args) {
        //System.out.println(FileManager.calculateFiles2("C:\\Temp"));
        //System.out.println(FileManager.calculateFiles2("C:\\Windows\\System32"));
        //System.out.println(FileManager.calculateFiles("C:\\Windows\\winsxs"));
        //System.out.println(FileManager.calculateFiles("C:\\Temp"));
        //System.out.println(FileManager.calculateDirs("C:\\Users\\IBraga"));
        //System.out.println(FileManager.calculateFiles("C:\\Users\\IBraga\\Documents"));
        System.out.println(Calendar.getInstance().getTime());

        //Positive
        System.out.println(FileManager.copy("C:\\TEMP\\source", "C:\\TEMP\\target"));

        //Copy to non existing directory ()
        //System.out.println(FileManager.copy("C:\\TEMP\\LOTUS CLIENT 8.5.exe", "C:\\TEMP\\TEMP01\\"));

        //Copy to file in non existing directory
        //System.out.println(FileManager.copy("C:\\TEMP\\LOTUS CLIENT 8.5.exe", "C:\\TEMP\\TEMP01\\LOTUS CLIENT 8.5.exe"));

        //Target is same directory
        //System.out.println(FileManager.copy("C:\\TEMP\\LOTUS CLIENT 8.5.exe", "C:\\TEMP"));

        //Source not exist file is same directory
        //System.out.println(FileManager.copy("C:\\TEMP\\xxx", "C:\\TEMP\\xxx"));

        //Folder with file to another folder
        //System.out.println(FileManager.copy("C:\\TEMP\\asdfg", "C:\\TEMP\\asdf"));

        System.out.println(Calendar.getInstance().getTime());
    }
}