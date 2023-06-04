package com.example.Seminar1.Homework;

import java.util.Scanner;

//3) Реализовать простой калькулятор
//+ - / *
//Пример:
//Введите первое число: A \n
//Введите знак: *
//Введите второе число: B
//Результат: A*B
public class Task3 {
    public static void main(String[] args) {

        System.out.printf("Результат: %s", Calk());
    }
    public static int Calk() {
        int res = -1;
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Калькулятор умеет складывать(+), вычитать(-), умножать(*) и делить(/).");
        System.out.print("Введите первое число: ");
        int num1 = iScanner.nextInt();
        System.out.print("Введите символ: ");
        String sym = iScanner.next();
        System.out.print("Введите второе число: ");
        int num2 = iScanner.nextInt();
        iScanner.close();
        switch(sym) {
            case "+": res = num1 + num2;
                break;
            case "-": res = num1 - num2;
                break;
            case "*": res = num1 * num2;
                break;
            case "/": res = num1 / num2;
                break;
            default:  System.out.print("Error! Enter correct operator ");
                break;
        }
        return res;
    }
}
