package com.example.Seminar4.Homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**Даны два Deque, представляющие два целых числа.
 Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
 1) Умножьте два числа и верните произведение в виде связанного списка.
 2) Сложите два числа и верните сумму в виде связанного списка.
 Одно или два числа могут быть отрицательными.

 Даны два Deque, цифры в обратном порядке.
 [3,2,1,-] - пример Deque
 [5,4,3]- пример второго Deque
 1) -123 * 345 = -42 435
 Ответ всегда - связный список, в обычном порядке
 [-,4,2,4,3,5] - пример ответа*/
public class Task1 {
    public static void main(String[] args) {
        /* Чтобы не составлять свой метод заполнения очереди, на основе ввода с клавиатуры
           или объявлять дополнительные переменные, заполняем очередь при её объявлении
           через Arrays.stream(String[]).to list. Stream помогает провести источник через нужные операции сразу весь
           массив, а не запускать цикл и обрабатывать по одному значению */
        Deque<String> num1 = new ArrayDeque<>(Arrays.stream(new String[]{"3","2","1","-"}).toList());
        Deque<String> num2 = new ArrayDeque<>(Arrays.stream(new String[]{"5","4","3"}).toList());
        System.out.println(IntToLinkedList(DequeToInt(num1) + DequeToInt(num2)));
        System.out.println(IntToLinkedList(DequeToInt(num1) * DequeToInt(num2)));
    }
    public static Integer DequeToInt(Deque input){
        /*Копия очереди из которой будем брать значения*/
        Deque in = new ArrayDeque(input);
        StringBuilder res = new StringBuilder();
        /*Мне показалось, что так будет лучше, чем писать while или for. Хотел через stream
         сделать перевернутую коллекцию, но не придумал как это сделать*/
        input.forEach((n) -> res.append(in.pollLast()));
        return Integer.parseInt(res.toString());
    }
    public static LinkedList IntToLinkedList(Integer input){
        /*Сплит числа и перевод его в связанный список*/
        return new LinkedList<>(
                Arrays.stream(
                        input.toString()
                                .split("")
                ).toList());
    }
}
