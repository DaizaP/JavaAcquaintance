package com.example.Seminar1.Homework;

import java.util.ArrayList;

//Вывести все простые числа от 1 до 1000
public class Task2 {
    public static void main(String[] args) {
        System.out.println(PrimeNumbersList(1000));;
    }
    public static ArrayList<Integer> PrimeNumbersList(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n ; i++) {
            if (IsPrime(i)) { // Проверка числа на простоту
                res.add(i); // Если число простое до добавляем его в список
            }
        }
        return res;
    }
    public static boolean IsPrime (int n) {
        if (n % 2 == 0) { // Оптимизация. Проверяем делимость на 2. Чтобы в for перебирать только нечетные делители
            return n == 2; // Если число делится на два, то возвращаем результат сравнения числа и двойки.
        }
        for (int i = 3; i <= Math.sqrt(n); i+=2) { // Оптимизация. У любого непростого (составного) есть делитель (не равный 1),
            if (n % i == 0) { // не превосходящий квадратный корень числа.
                return false;// Если у числа есть делитель (if (n % i == 0)) результат проверки false
            }
        }
        return true;
    }
}
