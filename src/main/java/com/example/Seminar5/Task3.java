package com.example.Seminar5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**Написать программу, определяющую правильность расстановки скобок в выражении.
 Пример 1: a+(d*3) - истина
 Пример 2: [a+(1*3) - ложь
 Пример 3: [6+(3*3)] - истина
 Пример 4: {a}[+]{(d*3)} - истина
 Пример 5: <{a}+{(d*3)}> - истина
 Пример 6: {a+]}{(d*3)} - ложь */
public class Task3 {
    public static void main(String[] args) {
        String s1 = "<{a(}+{(d*3))}>";
        System.out.println(isTruePlace(s1));
    }
    public static boolean isTruePlace (String s)
    {
        Map<Character, Character> m = new HashMap<>();
        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');
        m.put('>', '<');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsValue(s.charAt(i))) {
                st.push(s.charAt(i));
            }
            if (m.containsKey(s.charAt(i))) {
                if (st.empty() || st.pop() != m.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return st.empty();
    }
}
