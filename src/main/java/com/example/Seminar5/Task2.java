package com.example.Seminar5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**Даны 2 строки, написать метод, который вернет true, если эти строки являются
 изоморфными и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить
 на некоторую букву во втором слове, при этом
 1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
 (Например, add - egg изоморфны)
 2. буква может не меняться, а остаться такой же. (Например, note - code) n - c, o - o, t-d, e-e
 Пример 1:
 Input: s = "foo", t = "bar" f- b, o - a, ошибка
 Output: false
 Пример 2:
 Input: s = "paper", t = "title"
 p-t
 a-i
 e-l
 r-e
 Output: true */
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.print("Введите первую строку: ");
        String s1 = sc.nextLine();
        System.out.print("Введите вторую строку: ");
        String s2 = sc.nextLine();
        sc.close();

        System.out.println(isIzomorfString(s1, s2) && isIzomorfString(s2, s1));
    }

    public static Boolean isIzomorfString (String s1, String s2) {
        Map<Character, Character> sm1 = new HashMap<>();
        if (s1.length() != s2.length()){
            return false;
        }
        else {
            for (int i = 0; i < s1.length(); i++) {
                if (!sm1.containsKey(s1.charAt(i)))
                    sm1.put(s1.charAt(i), s2.charAt(i));
                else {
                    if (sm1.get(s1.charAt(i)) != s2.charAt(i))
                        return false;
                }
            }
        }
        return true;
    }
}
