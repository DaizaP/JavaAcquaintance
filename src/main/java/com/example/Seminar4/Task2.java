package com.example.Seminar4;

import java.util.LinkedList;
import java.util.Scanner;

/**Реализовать консольное приложение, которое:
 1. Принимает от пользователя строку вида
 text
 1. Нужно сохранить text в связный список.
 2. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
 3. Выход - слово exit
 qwe
 [qwe]
 tre
 [qwe, tre]
 zxc
 [qwe, tre, zxc]
 print~1
 tre
 [qwe, zxc]
 print~1
 zxc
 [qwe] */
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите строку и нажмите Enter: ");
        try (Scanner sc = new Scanner(System.in, "cp866")) {
            LinkedList<String> ll = new LinkedList<String>();
            String str = "";
            while (!str.equals("exit")) {
                str = sc.nextLine();
                if (str.startsWith("print~")) {
                    String[] pn = str.split("~");
                    System.out.println(ll.remove(Integer.parseInt(pn[1])));
                }
                else {
                    ll.add(str.trim());
                }
                System.out.println(ll);
            }
        }
    }
}