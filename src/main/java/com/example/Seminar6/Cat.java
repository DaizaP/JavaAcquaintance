package com.example.Seminar6;

import java.util.ArrayList;
import java.util.List;

/**Продумайте структуру класса Кот для информационной системой ветеринарной клиники

 Поля:
 Имя
 Возраст
 Привит ли (boolean)


 Методы:
 Кот .. мяукнул n раз
 Метод прививки кота
 1 придумаем */
public class Cat {
    private String name;
    private int age;
    private String poroda;

    public Cat(String name, int age, String poroda) {
        this.name = name;
        this.poroda = poroda;
        this.age = age;
    }
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void golos() {
        System.out.println(this.name + "say mur");
    }
    @Override
    public String toString() {
        return name + " <-Имя Возраст-> " + age;
    }
}