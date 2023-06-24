package com.example.Seminar5;

import java.util.HashMap;
import java.util.Map;

/** Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
 123456 Иванов
 321456 Васильев
 234561 Петрова
 234432 Иванов
 654321 Петрова
 345678 Иванов
 Вывести данные по сотрудникам с фамилией Иванов. */
public class Task1 {
    public static void main(String[] args) {
        Map<Integer, String> pn = new HashMap<>();
        pn.put(123456, "Иванов");
        pn.put(321456, "Васильев");
        pn.put(234561, "Петрова");
        pn.put(234432, "Иванов");
        pn.put(654321, "Петрова");
        pn.put(345678, "Иванов");
        //System.out.println(pn);
        for ( var item : pn.entrySet()) {
            if (item.getValue().equals("Иванов")) {
                System.out.println(item);
            }
        }
    }
}
