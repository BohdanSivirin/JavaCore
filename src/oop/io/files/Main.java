package oop.io.files;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("Dir/File2.txt");
//        try{
//           // file.createNewFile();
        file.delete();
        File file1 = new File("Dir/File1.txt");
        long size = file1.getTotalSpace();
        System.out.println("file1 size " + size);
        long lenght = file1.length();
        System.out.println("file1 lenght " + lenght);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
        File file2 = new File("Dir");
        boolean isDirectory = file2.isDirectory();
        System.out.println("isDirectory " + isDirectory);

        File file3 = new File("Dir/Dir1");
        invistigateStructure(file2);


    }

    public static void invistigateStructure(File file) {
        if (file.isFile()) {
            System.out.println("\tFile: " + file.getName() + " Size " + file.length());
        } else {
            System.out.println("Dir: " + file.getName());
            File[] allFiles = file.listFiles();
            for (int i = 0; i < allFiles.length; i++) {
                invistigateStructure(allFiles[i]);
            }
        }
    }

}
