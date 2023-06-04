package com.example.Seminar1.Homework;

import java.util.Arrays;
import java.util.Scanner;

//4) (дополнительное задание) Задано уравнение вида q + w = e. q, w, e >= 0.
//Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
//Требуется восстановить выражение до верного равенства.
//Знаки вопроса - одинаковые цифры.
//Предложить хотя бы одно решение или сообщить, что его нет.
public class Task4 {
    public static void main(String[] args) {
        int count = 0;
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите пример в формате q + w = e. Вместо чисел вы можете в случайно расставить знаки '?'");
        String text = iScanner.nextLine();
        iScanner.close();
        for (var i = 0; i <= 9; i++) {
            char j = Integer.toString(i).charAt(0);
            String temp = text.replace('?', j);
            if (SplitAndRes(temp)) {
                count++;
                System.out.printf("Решение №%s: %s", count, temp);
            }
        }
        if (count == 0) {
            System.out.println("Решения нет.");
        }
    }


    public static boolean SplitAndRes(String text) {
        String[] nText = text.split("");
        String num1 = "";
        String num2 = "";
        String res = "";
        String temp = "";
        for (int i = 0; i < nText.length; i++) {
            if (nText[i].contains("+")) {
                num1 = temp;
                temp = "";
            } else if (nText[i].contains(" ")) {

            } else if (nText[i].contains("=")) {
                num2 = temp;
                temp = "";
            } else temp += nText[i];
        }
        res = temp;
        return Integer.parseInt(num1) + Integer.parseInt(num2) == Integer.parseInt(res);
    }
}
