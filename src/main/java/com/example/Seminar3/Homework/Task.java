package com.example.Seminar3.Homework;
//Пусть дан произвольный список целых чисел.
//
//1) Нужно удалить из него чётные числа
//2) Найти минимальное значение
//3) Найти максимальное значение
//4) Найти среднее значение

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            arrayList.add(r.nextInt(100));
        }
        System.out.println(arrayList);
        System.out.println("Без четных чисел: " + delEvenNum(arrayList));
        // Не совсем понял условия задачи, поэтому ищу числа в списке, в котором мы убрали четные числа
        System.out.println("Минимальное значение: " + minValue(arrayList));
        System.out.println("Максимальное значение: " + maxValue(arrayList));
        System.out.printf("Среднее значение: %.2f", meanValue(arrayList));
    }

    public static List delEvenNum(List<Integer> arrayList) {
        arrayList.removeIf(x -> x % 2 == 0);
        return arrayList;
    }

    public static Integer minValue(List<Integer> arrayList) {
        return Collections.min(arrayList);
    }

    public static Integer maxValue(List<Integer> arrayList) {
        return Collections.max(arrayList);
    }

    public static Double meanValue(List<Integer> arrayList) {
        // Засовываем в потом данных list и считаем среднее значение.
        return arrayList.stream().mapToInt(n -> n).average().orElse(0);
    }
}
