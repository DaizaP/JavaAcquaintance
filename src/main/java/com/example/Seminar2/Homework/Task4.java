package com.example.Seminar2.Homework;

import java.io.FileWriter;
import java.util.Scanner;

//4) К калькулятору из предыдущего ДЗ добавить логирование.
//        4+2=6
//        6-1=5
public class Task4 {
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
        calkLog(num1+sym+num2+"="+res);
        return res;
    }
    public static void calkLog(String str) {
        // Путь написал, чтобы логи сохранялись в удобном для меня месте в проекте.
        String path = "src\\main\\java\\com\\example\\Seminar2\\Homework\\Task4Log.txt";
        try (FileWriter strWriter = new FileWriter(path, true)) {
            strWriter.write(str + "\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}
