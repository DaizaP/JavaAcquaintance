package com.example.Seminar2.Homework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//1) Дана строка sql-запроса "select * from students WHERE ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
//Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
public class Task1 {
    public static void main(String[] args) throws ParseException {
        String request = "select * from students WHERE";
        String inputStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        //Option1. Решение через конверт inputStr в Map и составления из этого строки.
        System.out.println(Option1.sqlRequest(request, inputStr));
        //Option2. Решение через сплит строки. Решение меньше и никакого Map.
        System.out.println(Option2.sqlRequest(request, inputStr));
        //Option3. Решение через пас json через библиотеку Simple Json.
        System.out.println(Option3.sqlRequest(request, inputStr));
    }

}

class Option1 {
    public static String sqlRequest(String request, String inputStr) {
        StringBuilder res = new StringBuilder();
        String sqlReqInputStr = sqlRequestFromHashMap(inputStr);
        // Если в inputStr все значения будут null, то sqlRequestFromHashMap вернет пустую строку. В result проверка
        // на строки на пустоту и если строка пустая, то убирает WHERE из request, если нет, то прибавляет к request
        // результат sqlRequestFromHashMap и конвертит в строку
        return sqlReqInputStr.isEmpty()
                ? request.replaceAll("WHERE", "")
                : res.append(request + sqlReqInputStr).toString();
    }

    public static String sqlRequestFromHashMap(String inputStr) {
//        Составляем значения в строку для SQL запроса.
        int count = 0; // итератор, нужен, чтобы правильно выводить лишние AND;
        StringBuilder res = new StringBuilder();
        // Делаем Map из inputStr. Я решил так сделать, чтобы в теории можно было пользоваться данными, которые
        // которые передались в json строке. Сторонние библиотеки включил в решении Option3.
        Map<String, String> map = strForHashMap(inputStr);
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (!pair.getValue().contains("null") && count == 0) {
                count++;
                res.append(" " + pair.getKey() + "=" + pair.getValue());
            } else if (!pair.getValue().contains("null") && count != 0) {
                count++;
                res.append(" AND " + pair.getKey() + "=" + pair.getValue());
            }
        }
        return res.toString();
    }

    public static Map<String, String> strForHashMap(String inputStr) {
        // Множественный .replace, чобы убрать все, неугодные мне, повторяющиеся символы. Способа проще не нашел.
        inputStr = inputStr.replace("\"", "")
                .replace("{", "")
                .replace("}", "");
        String[] jsLine = inputStr.split(", ");
        Map<String, String> map = new HashMap<>();
        // Итоговый список запихиваю в цикл, который еще раз сплитует, каждое значение строки и кладет ключ и значение
        // в Map
        for (String pair : jsLine) {
            String[] keyValue = pair.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }
}

class Option2 {
    public static String sqlRequest(String request, String inputStr) {
        StringBuilder res = new StringBuilder();
        String sqlReqInputStr = ConvStr(inputStr);
        // Если в inputStr все значения будут null, то sqlRequestFromHashMap вернет пустую строку. В result проверка
        // на строки на пустоту и если строка пустая, то убирает WHERE из request, если нет, то прибавляет к request
        // результат sqlRequestFromHashMap и конвертит в строку
        return sqlReqInputStr.isEmpty()
                ? request.replaceAll("WHERE", "")
                : res.append(request + sqlReqInputStr).toString();
    }

    public static String ConvStr(String inputStr) {
        // Множественный .replace, чобы убрать все, неугодные мне, повторяющиеся символы. Способа проще не нашел.
        inputStr = inputStr.replace("\"", "")
                .replace("{", "")
                .replace("}", "");
        String[] jsLine = inputStr.split(", ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < jsLine.length; i++) {
            String[] keyValue = jsLine[i].split(":");
            if (!keyValue[1].contains("null") && i == 0) {
                res.append(" " + keyValue[0] + "=" + keyValue[1]);
            } else if (!keyValue[1].contains("null") && i != 0) {
                res.append(" AND " + keyValue[0] + "=" + keyValue[1]);
            }
        }
        return res.toString();
    }
}

class Option3 {
    public static String sqlRequest(String request, String inputStr) throws ParseException {
        StringBuilder res = new StringBuilder();
        JSONParser parser = new JSONParser();
        JSONObject temp = (JSONObject) parser.parse(inputStr);
        //Проще вывода не придумал
        if (!temp.get("name").toString().contains("null")) {
            res.append(" name=" + temp.get("name"));
        }
        if (!temp.get("country").toString().contains("null")) {
            res.append(" AND country=" + temp.get("country"));
        }
        if (!temp.get("city").toString().contains("null")) {
            res.append(" AND city=" + temp.get("city"));
        }
        if (!temp.get("age").toString().contains("null")) {
            res.append(" AND age=" + temp.get("age"));
        }
        return res.isEmpty()
                ? request.replaceAll("WHERE", "")
                : request + res.toString();
    }
}