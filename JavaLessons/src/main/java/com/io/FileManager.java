package com.io;

import java.io.*;
import java.util.*;

public class FileManager {

    /**
     * принимает путь к папке, возвращает количество файлов в папке и всех подпапках по пути
     *
     * @param path
     * @return
     */

    public static int calculateFiles(String path) {
        int count = 0;
        try {
            File root = new File(path);
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile();
                }
            };
            count = root.listFiles(filter).length;

            for (File dir : getDirs(path)) {
                count += calculateFiles(dir.getPath());
            }
            //return count;
        } catch (NullPointerException ex) {
            //return 0;
        } finally {
            return count;
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

    private static List<File> getFiles(String path) {
        List<File> filesList = new ArrayList<File>();
        try {
            File root = new File(path);
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile();
                }
            };
            for (File currentFile : root.listFiles(filter)) {
                filesList.add(currentFile);
            }

            for (File dir : getDirs(path)) {
                filesList.addAll(getFiles(dir.getPath()));
            }
            //return count;
        } catch (NullPointerException ex) {
            //return 0;
        } finally {
            return filesList;
        }
    }

    /**
     * принимает путь к папке, возвращает количество папок в папке и всех подпапках по пути
     *
     * @param path
     * @return
     */
    public static int calculateDirs(String path) {
        int count = 0;
        try {
            File root = new File(path);
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            };
            count = root.listFiles(filter).length;

            for (File dir : getDirs(path)) {
                count += calculateDirs(dir.getPath());
            }
        } catch (NullPointerException ex) {
        } finally {
            return count;
        }
    }

    /**
     * метод по копированию папок и файлов
     *
     * @param from - путь к файлу или папке
     * @param to   - путь к папке куда будет производиться копирование
     * @return
     */
    public static boolean copy(String from, String to) {
        boolean status = false;
        File checkSource = new File(from);
        File checkTarget = new File(to);

        try {
            if (checkSource.exists() && checkSource.isDirectory()) {
                String root = checkSource.getName();
                List<File> fileList = getFiles(from);
                Set<File> folderList = new HashSet<File>();
                for (File file : fileList){
                    folderList.add(file.getParentFile());
                }

                for (File folder : folderList ) {
                    System.out.println(checkTarget);

                }
                System.out.println(root);
                System.out.println(fileList);
                System.out.println(folderList);
            }
            return false;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        } finally {
            return status;
        }
/*
        if (!checkTarget.exists() || checkTarget.isFile()) {
            checkTarget.mkdirs();
        }
*/
        /*
        try (BufferedInputStream sourceStream = new BufferedInputStream(new FileInputStream(from));
             BufferedOutputStream targetStream = new BufferedOutputStream(new FileOutputStream(to + "\\" + checkSource.getName()))) {
            int chunkSize = 1024;
            byte[] chunk = new byte[chunkSize];
            while (sourceStream.available() > 0) {
                sourceStream.read(chunk, 0, chunkSize);
                targetStream.write(chunk);
                chunkSize = chunkSize <= sourceStream.available() ? chunkSize : sourceStream.available();
                chunk = new byte[chunkSize];
            }
            status = true;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        } finally {
            return status;

        }
        */
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
