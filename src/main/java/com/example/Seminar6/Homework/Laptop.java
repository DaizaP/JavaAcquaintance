package com.example.Seminar6.Homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Laptop {
    private final String brand;
    private String ram;
    private String hdd;
    private String os;
    private final String color;

    public Laptop(String brand, String ram, String hdd, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public Laptop(String brand, String ram, String hdd, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = "none";
        this.color = color;
    }

    public Laptop(String brand, String ram, String hdd) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = "none";
        this.color = "Black";
    }

    public String getBrand() {
        return brand;
    }

    public String getRam() {
        return ram;
    }
    public static HashMap<Integer, String> entrySet(Laptop input){
        HashMap<Integer, String> res = new HashMap<>();
        res.put(1, input.getBrand());
        res.put(2, input.getRam());
        res.put(3, input.getHdd());
        res.put(4, input.getOs());
        res.put(5, input.getColor());
        return res;
    }

    /*Задаток на редактирование списка ноутбуков на случай ремонта*/
    public void setRam() {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    /*Задаток на редактирование списка ноутбуков на случай ремонта*/
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    /*Задаток на редактирование списка ноутбуков на случай ремонта*/
    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public static void find(HashSet<Laptop> inputset) {
        HashMap<Integer, String> findCharacteristic = new HashMap<>(Stream.of(new String[][]{
                {"1", " "},
                {"2", " "},
                {"3", " "},
                {"4", " "},
                {"5", " "}
        }).collect(Collectors.toMap(p -> Integer.parseInt(p[0]), p -> " ")));
        System.out.println(" Добрый день!");
        Integer num = 0; /*Цифра критерия вынесена за try catch, чтобы её было видно*/
        boolean bol = false; /*Для вывода сообщения, если не найдем ноутбуки*/
        Scanner scanner = new Scanner(System.in);
        /*Выполняется пока, что-то не найдем*/
        while (!num.equals(6)) {
            System.out.println(
                    " Введите цифру, соответствующую необходимому критерию:" +
                            "\n 1 - Брэнд " + findCharacteristic.get(1) +
                            "\n 2 - ОЗУ(Гб) " + findCharacteristic.get(2) +
                            "\n 3 - Объем ЖД hd hdd(Гб) " + findCharacteristic.get(3) +
                            "\n 4 - Операционная система " + findCharacteristic.get(4) +
                            "\n 5 - Цвет " + findCharacteristic.get(5) +
                            "\n 6 - Начать поиск");
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                /*Если введут не цифру, исключение не прервет выполнение программы*/
                System.out.println("Некорректное значение.");
                Laptop.find(inputset);
                return;
            }
            /*Проверка, что пользователь ввел нормальное число*/
            if (num <= 5) {
                System.out.println("Введите значение: ");
                String string = scanner.next(); /*Запрашиваем значение характеристики*/
                findCharacteristic.put(num, string);
//                switch (num) {
//                    case 1 -> {
////                        for (var lapt : inputset) {
////                            /*Если находим объект по характеристике - отдаем на вывод*/
////                            if (lapt.getBrand().contains(string)) {
////                                System.out.println(lapt);
////                                bol = true;/*Отдаем true когда находим что-то подходящее*/
////                            }
////                        }
//                    }
//                    case 2 -> {
////                        for (var lapt : inputset) {
////                            if (lapt.getRam().equals(Integer.parseInt(string))) {
////                                System.out.println(lapt);
////                                bol = true;
////                            }
////                        }
//                    }
//                    case 3 -> {
////                        for (var lapt : inputset) {
////                            if (lapt.getHdd().equals(Integer.parseInt(string))) {
////                                System.out.println(lapt);
////                                bol = true;
////                            }
////                        }
//                    }
//                    case 4 -> {
////                        for (var lapt : inputset) {
////                            if (lapt.getOs().contains(string)) {
////                                System.out.println(lapt);
////                                bol = true;
////                            }
////                        }
//                    }
//                    case 5 -> {
////                        for (var lapt : inputset) {
////                            if (lapt.getColor().contains(string)) {
////                                System.out.println(lapt);
////                                bol = true;
////                            }
////                        }
//                    }
//                    default -> {
//                    }
//                }

            } else if(num > 6 || num == 0){
                /*Если ввел неподходящее число*/
                System.out.println("Некорректное значение.");
            }
        }
         if (num == 6) {
            boolean check = true;
            for (var lapt : inputset) {
                check = true;
                /*Если находим объект по характеристике - отдаем на вывод*/
                for (int i =1; i <= 5; i++) {
                    if(!findCharacteristic.get(i).equals(" ")){
                        if(!Laptop.entrySet(lapt).get(i).equals(findCharacteristic.get(i))) {
                            check = false;
                        }
                    }
                } if(check){
                    bol = true;
                    System.out.println(lapt);
                }/*Отдаем true когда находим что-то подходящее*/

            }
        }
        if (!bol) {
            /*Выводим если ничего не нашли*/
            System.out.println("Ноутбуков с такой характеристикой нет.");
        }
    }

    @Override
    public String toString() {
        return "---------------\n" +
                brand + " <-Модель\n" +
                ram + " <-ОЗУ\n" +
                hdd + " <-Объем HDD\n" +
                os + " <-Операционная система\n" +
                color + " <-Цвет\n" +
                "---------------";
    }
}
