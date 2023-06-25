package com.example.Seminar6;

import java.util.ArrayList;

/**Продумайте структуру класса Кот для информационной системой ветеринарной клиники

 Поля:
 Имя
 Возраст
 Привит ли (boolean)


 Методы:
 Кот .. мяукнул n раз
 Метод прививки кота
 1 придумаем */
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Cat> kototeka = new ArrayList<>();
        Cat bars = new Cat("pups",3,"Bars");
        Cat cat2 = new Cat("bob", 5, "egypt");
        kototeka.add(bars);
        kototeka.add(cat2);
        bars.setAge(6);
        bars.setName("Pupsik");
        System.out.println(kototeka);;
    }
}