package com.example.Seminar6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/** 1. Напишите метод, который заполнит массив из 99 элементов случайными цифрами от 0 до 50.

 2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных
 значений в данном массиве и верните его в виде числа с плавающей запятой.

 Для вычисления процента используйте формулу:

 Процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве. */
public class Taks2 {
    public static void main(String[] args) {
        System.out.println(uniqElements(createArray()));
    }
    public static Integer[] createArray() {
        Integer[] arr = new Integer[99];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50);
        }
        return arr;
    }
    public static double uniqElements(Integer[] arr) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
        return set.size() * 100f / arr.length;
    }
}