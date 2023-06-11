package com.example.Seminar2.Homework;

import java.util.HashMap;

//1) Дана строка sql-запроса "select * from students WHERE ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
//Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
public class Task1 {
    public static void main(String[] args) {
        String request = "select * from students WHERE";
        String inputStr = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
        System.out.println(sqlRequest(request, inputStr));
    }
    public static String sqlRequest(String request, String inputStr) {
//        Составляем SQL запрос.
        StringBuilder res = new StringBuilder(request);
        return res.toString();
    }
    public static HashMap<String, String> strForHashMap(String inputStr){

        inputStr = inputStr.replace("'","").replace("{","").replace("}","");
        String[] jsLine = inputStr.split(", ");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < jsLine.length; i++) {
            for (String pair : jsLine) {
                String[] keyValue = pair.split(":");
                map.put(keyValue[0], keyValue[1]);
            }
        }
        return map;
    }
}

