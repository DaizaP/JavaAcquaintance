package com.example.Seminar2.Homework;

import java.io.FileWriter;
import java.util.Arrays;

//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task2 {
    public static void main(String[] args) {
        int[] arr = {11, 3, 14, 16, 7};
        //Буду составлять строку и делить её \n чтобы красиво выводились логи, которые будут перезаписываться
        String resLog = "";
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                //Если сравнение чисел, без перестановки тоже считается итерацией по условиям, то логи накапливаются
                // верно. Если нужно логировать только перестановку чисел, то нужно разместить запись логов за цикл for.
                resLog += Arrays.toString(arr) + "\n";
            }
        }
        filePrintLog(resLog);
        System.out.println("Done");
    }

    public static void filePrintLog(String str) {
        // Путь написал, чтобы логи сохранялись в удобном для меня месте в проекте.
        String path = "src\\main\\java\\com\\example\\Seminar2\\Homework\\log.txt";
        //Можно было добавить значение append в FileWriter, но тогда при каждом запуске логи будут накапливаться и
        //файл не будет "чистится" автоматически.
        try (FileWriter strWriter = new FileWriter(path)) {
            strWriter.write(str + "\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}

