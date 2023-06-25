package com.example.Seminar6.Homework;

import java.util.HashSet;
import java.util.Set;

/** Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 Создать множество ноутбуков.
 Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
 NoteBook notebook1 = new NoteBook
 NoteBook notebook2 = new NoteBook
 NoteBook notebook3 = new NoteBook
 NoteBook notebook4 = new NoteBook
 NoteBook notebook5 = new NoteBook

 Например: “Введите цифру, соответствующую необходимому критерию:"
 1 - ОЗУ
 2 - Объем ЖД hd hdd
 3 - Операционная система
 4 - Цвет

 Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

 Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

 Класс сделать в отдельном файле

 приветствие
 Выбор параметра
 выбор конкретнее
 вывод подходящих */
public class Task1 {
    public static void main(String[] args) {
        HashSet<Laptop> laptopList = new HashSet<>();
        Laptop m94n6 = new Laptop("ASUS", 4, 1024, "Windows", "Red");
        Laptop lt564 = new Laptop("HP", 16, 2048);
        Laptop hdrtx = new Laptop("Apple", 32, 4096, "macOS 12 Monterey", "White");
        Laptop brmax = new Laptop("DEXP", 4, 1024, "Blue");
        Laptop s4221 = new Laptop("Hyper-X", 32, 2048, "Windows", "Yellow");
        Laptop klult = new Laptop("MSI", 2, 512, "Arch Linux");
        /*Не придумал массовое добавление*/
        laptopList.add(m94n6);
        laptopList.add(lt564);
        laptopList.add(hdrtx);
        laptopList.add(brmax);
        laptopList.add(s4221);
        laptopList.add(klult);
        Laptop.find(laptopList);
    }
}
