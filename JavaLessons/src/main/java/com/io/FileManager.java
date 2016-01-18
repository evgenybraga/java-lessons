package com.io;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class FileManager {

    /**
     * принимает путь к папке, возвращает количество файлов в папке и всех подпапках по пути
     *
     * @param path
     * @return
     */
    public static int calculateFiles(String path) {
        int count = getFileCount(path);
        for (File dir : getDirs(path)) {
            count += calculateFiles(dir.getPath());
        }
        return count;
    }

    private static int getFileCount(String path) {
        try (FileInputStream fs = new FileInputStream(new File(path))) {
            File root = new File(path);
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile();
                }
            };
            return root.listFiles(filter).length;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    private static File[] getDirs(String path) {
        File root = new File(path);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        return root.listFiles(filter);
    }


    /**
     * принимает путь к папке, возвращает количество папок в папке и всех подпапках по пути
     *
     * @param path
     * @return
     */
    public static int calculateDirs(String path) {
        return 0;
    }

    /**
     * метод по копированию папок и файлов
     *
     * @param from - путь к файлу или папке
     * @param to   - путь к папке куда будет производиться копирование
     * @return
     */
    public static boolean copy(String from, String to) {
        return false;
    }

    /**
     * метод по перемещению папок и файлов
     *
     * @param from - путь к файлу или папке
     * @param to   - путь к папке куда будет производиться перемещение
     * @return
     */
    public static boolean move(String from, String to) {
        return false;
    }
}
