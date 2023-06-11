package com.example.Seminar2;
// Напиите метод, который сжимает строку. Пример: вход aaaabbbcdd. Выход: a4b3cd2
public class Task2 {
    public static void main(String[] args) {
        System.out.println(comStr("aaaabbbcdd"));
    }
    public static String comStr(String str) {
        String[] temp = str.split("");
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (i > 0 && !temp[i].contains(temp[i-1])) {
                res = count > 1 ? res.append(temp[i-1]+count) : res.append(temp[i-1]); // Если count =1 то цифру не пишем
                count = 0;
            }
            count +=1;
        }
        res = count > 1 ? res.append(temp[temp.length-1]+count) : res.append(temp[temp.length-1]);;
        return res.toString();
    }
}
