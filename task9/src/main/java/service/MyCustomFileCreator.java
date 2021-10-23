package service;

import java.io.File;
import java.io.IOException;

public class MyCustomFileCreator {
    public static final String FILE_PATH = "D:\\work\\jd2_homework\\task9\\src\\main\\resources\\text.txt";

    public static void createDirAndFile() {
        File newFile = new File(FILE_PATH);
        try {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
