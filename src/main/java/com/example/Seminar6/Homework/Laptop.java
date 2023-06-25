package com.example.Seminar6.Homework;

import java.util.HashSet;
import java.util.Scanner;

public class Laptop {
    private final String brand;
    private Integer ram;
    private Integer hdd;
    private String os;
    private final String color;

    public Laptop(String brand, Integer ram, Integer hdd, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public Laptop(String brand, Integer ram, Integer hdd, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = "none";
        this.color = color;
    }

    public Laptop(String brand, Integer ram, Integer hdd) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = "none";
        this.color = "Black";
    }

    public String getBrand() {
        return brand;
    }

    public Integer getRam() {
        return ram;
    }

    /*Задаток на редактирование списка ноутбуков на случай ремонта*/
    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getHdd() {
        return hdd;
    }

    /*Задаток на редактирование списка ноутбуков на случай ремонта*/
    public void setHdd(Integer hdd) {
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
        System.out.println(" Добрый день!");
        Integer num = null; /*Цифра критерия вынесена за try catch, чтобы её было видно*/
        boolean bol = false; /*Для вывода сообщения, если не найдем ноутбуки*/
        Scanner scanner = new Scanner(System.in);
        /*Выполняется пока, что-то не найдем*/
        while (!bol) {
            System.out.println("""
                     Введите цифру, соответствующую необходимому критерию:\s
                     1 - Брэнд
                     2 - ОЗУ(Гб)
                     3 - Объем ЖД hd hdd(Гб)
                     4 - Операционная система
                     5 - Цвет\
                    """);
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
                switch (num) {
                    case 1 -> {
                        for (var lapt : inputset) {
                            /*Если находим объект по характеристике - отдаем на вывод*/
                            if (lapt.getBrand().contains(string)) {
                                System.out.println(lapt);
                                bol = true;/*Отдаем true когда находим что-то подходящее*/
                            }
                        }
                    }
                    case 2 -> {
                        for (var lapt : inputset) {
                            if (lapt.getRam().equals(Integer.parseInt(string))) {
                                System.out.println(lapt);
                                bol = true;
                            }
                        }
                    }
                    case 3 -> {
                        for (var lapt : inputset) {
                            if (lapt.getHdd().equals(Integer.parseInt(string))) {
                                System.out.println(lapt);
                                bol = true;
                            }
                        }
                    }
                    case 4 -> {
                        for (var lapt : inputset) {
                            if (lapt.getOs().contains(string)) {
                                System.out.println(lapt);
                                bol = true;
                            }
                        }
                    }
                    case 5 -> {
                        for (var lapt : inputset) {
                            if (lapt.getColor().contains(string)) {
                                System.out.println(lapt);
                                bol = true;
                            }
                        }
                    }
                    default -> {
                    }
                }
                if (!bol) {
                    /*Выводим если ничего не нашли*/
                    System.out.println("Ноутбуков с такой характеристикой нет.");
                }
            } else {
                /*Если ввел неподходящее число*/
                System.out.println("Некорректное значение.");
            }
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
