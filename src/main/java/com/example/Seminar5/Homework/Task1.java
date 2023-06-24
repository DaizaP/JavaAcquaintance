package com.example.Seminar5.Homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**Реализуйте структуру телефонной книги с помощью HashMap.
 Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
 их необходимо считать, как одного человека с разными телефонами.
 Вывод должен быть отсортирован по убыванию числа телефонов.

 Пример:
 Иванов 1231234
 Иванов 3456345
 Иванов 5676585
 Петров 12345
 Петров 82332*/
public class Task1 {
    public static void main(String[] args) {
        Map<String, String[]> pn = new HashMap<>();
        pn.put("Иванов", new String[]{"123123123", "765543", "33342342"});
        pn.put("Васильев", new String[]{"1231312", "418798613"});
        pn.put("Петрова", new String[]{"434324123", "141413413", "314134134", "13413413"} );
        pn.put("Васечкин", new String[]{});
        /*Пример редактирования телефонной книги*/
        InputPhoneNumber(pn,"Витольд", "342324342 ");
        /*Запускаем взаимодействие c данными из HashMap*/
        pn.entrySet().stream()
                /*Делаем сортировку входных данных сравнивая HashMap (comparingByValue)*/
                .sorted(Map.Entry.<String, String[]>comparingByValue(Comparator
                        /*Компаратор сравнивает длину значения (кол-во значений в массиве).
                        * Т.к. .sorted делает сортировку по возрастанию, то надо делать после него
                        * .reversed(), чтобы соблюсти условия задачи */
                        .comparing(e -> e.length)).reversed())
                /*В отсортированных данных запускаем цикл foreach в которых будем перебирать ключи (f)
                * через лямбда выражение берем данные значения и запускаем еще один foreach.
                * Он уже будет пробегать, по значениям (res) массива Arrays.stream(f.getValue())
                * выводя результат.*/
                .forEach(f -> Arrays.stream(f.getValue())
                        .forEach(res -> System.out.println(f.getKey() + " " + res)));
    }
    public static void InputPhoneNumber(Map<String, String[]> input, String name, String phone){
        StringBuilder tmp = new StringBuilder();
        /*Создаем новую строку на тех данных, что были*/
        if (input.containsKey(name)) {
            Arrays.stream(input.get(name)).forEach(e -> tmp.append(e).append(" "));
            /*Добавляем номер*/
            tmp.append(phone);
            /*Возвращаем полученный массив в телефонную книгу*/
            input.put(name, tmp.toString().split(" "));
        }else {
            /*Если такого ключа в HashMap нет, то не проделываем действия и просто добавляем номер*/
            input.put(name, phone.split(" "));
        }
    }
}
