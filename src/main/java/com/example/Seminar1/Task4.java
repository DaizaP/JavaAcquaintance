package com.example.Seminar1;

import java.lang.reflect.Array;
import java.util.*;

//Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
public class Task4 {
    public static void main(String[] args) {
        String text = "Добро пожаловать на курс по Java";
        String[] words = text.split(" ");
        for (int i = words.length-1; i >= 0; i--) {
            System.out.printf("%s ", words[i]);
        }
//        String phrase = "Добро пожаловать на курс по Java";
//        String[] words = phrase.split(" ");
//        phrase = "";
//        for (int i = words.length - 1; i >= 0; i--) {
//            phrase = phrase + " " + words[i];
//        }
//        System.out.println(phrase);
    }
}
