package com.example.Seminar2;

import java.io.FileWriter;

public class Task3 {
    public static void main(String[] args) {
        filePrintTest("ТЕСТ\n");
    }

    public static void filePrintTest(String str) {
        String path = "src\\main\\java\\com\\example\\Seminar2\\text.txt";
        try(FileWriter strWriter = new FileWriter(path)) {
            for (int i = 0; i < 10; i++) {
                strWriter.write(str);
            }
            System.out.println("Получилось!");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
