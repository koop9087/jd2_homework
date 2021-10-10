package service;

import java.io.FileWriter;
import java.io.IOException;

public class CustomFileWriter {
    public static void writeFile(int count) {
        try (FileWriter fileWriter = new FileWriter(CustomFileCreator.FILE_PATH, false)) {
            fileWriter.write("count " + count);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
