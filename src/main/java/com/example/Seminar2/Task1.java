package com.example.Seminar2;
// Дано четное число n>0 и символы с1 и с2. Написать метод, который вернет строку длины N, которая состоит из чередующи-
// хся символов с1 и с2, начиная с с1.
public class Task1 {
    public static void main(String[] args) {
        System.out.println(str("v", "b", 10));
    }
    public static String str(String c1, String c2, int n){
        StringBuilder res = new StringBuilder();
        if (n % 2 != 0){
            res.append(-1);
            return res.toString();
        }
        for (int i = 0; i < n/2; i++) {
            res.append(c1+c2);
        }
        return res.toString();
    }
}