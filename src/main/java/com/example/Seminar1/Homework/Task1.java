package com.example.Seminar1.Homework;

//1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class Task1 {
    public static void main(String[] args) {
        System.out.println(SumBeforeN(10));
        System.out.println(FactorialN(10));
    }

    public static int SumBeforeN(int n) {
        return (n >= 0) ? n * (n + 1) / 2 : -1;
    }

    public static int FactorialN(int n) {
        return (n != 1) ? n * FactorialN(n - 1) : 1;
    }
}
