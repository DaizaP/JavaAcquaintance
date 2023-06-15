package com.example.Seminar2.Homework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
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


    static class Option1 {
        public static String sqlRequest(String request, String inputStr) {
            StringBuilder res = new StringBuilder();
            String sqlReqInputStr = sqlRequestFromHashMap(inputStr);
            // Если в inputStr все значения будут null, то sqlRequestFromHashMap вернет пустую строку. В result проверка
            // на строки на пустоту и если строка пустая, то убирает WHERE из request, если нет, то прибавляет к request
            // результат sqlRequestFromHashMap и конвертит в строку
            return sqlReqInputStr.isEmpty()
                    ? request.replaceAll("WHERE", "")
                    : res.append(request).append(sqlReqInputStr).toString();
        }

        public static String sqlRequestFromHashMap(String inputStr) {
//        Составляем значения в строку для SQL запроса.
            int count = 0; // счетчик, нужен, чтобы правильно выводить AND;
            StringBuilder res = new StringBuilder();
            // Делаем Map из inputStr. Я решил так сделать, чтобы в теории можно было пользоваться данными,
            // которые передались в json строке. Сторонние библиотеки включил в решении Option3.
            Map<String, String> map = strForHashMap(inputStr);
            for (Map.Entry<String, String> pair : map.entrySet()) {
                if (!pair.getValue().contains("null") && count == 0) {
                    count++;
                    res.append(" ").append(pair.getKey()).append("=").append(pair.getValue());
                } else if (!pair.getValue().contains("null") && count != 0) {
                    count++;
                    res.append(" AND ").append(pair.getKey()).append("=").append(pair.getValue());
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

    static class Option2 {
        public static String sqlRequest(String request, String inputStr) {
            StringBuilder res = new StringBuilder();
            String sqlReqInputStr = convStr(inputStr);
            // Если в inputStr все значения будут null, то sqlRequestFromHashMap вернет пустую строку. В result проверка
            // на строки на пустоту и если строка пустая, то убирает WHERE из request, если нет, то прибавляет к request
            // результат sqlRequestFromHashMap и конвертит в строку
            return sqlReqInputStr.isEmpty()
                    ? request.replaceAll("WHERE", "")
                    : res.append(request).append(sqlReqInputStr).toString();
        }

        public static String convStr(String inputStr) {
            int count = 0;
            // Множественный .replace, чобы убрать все, неугодные мне, повторяющиеся символы.
            inputStr = inputStr.replace("\"", "")
                    .replace("{", "")
                    .replace("}", "");
            String[] jsLine = inputStr.split(", ");
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < jsLine.length; i++) {
                String[] keyValue = jsLine[i].split(":");
                if (!keyValue[1].contains("null") && count == 0) {
                    count++;
                    res.append(" ").append(keyValue[0]).append("=").append(keyValue[1]);
                } else if (!keyValue[1].contains("null") && count != 0) {
                    count++;
                    res.append(" AND ").append(keyValue[0]).append("=").append(keyValue[1]);
                }
            }
            return res.toString();
        }
    }

    static class Option3 {
        public static String sqlRequest(String request, String inputStr) throws ParseException {
            // Счетчик увеличивается за каждое значение не null;
            int count = 0;
            StringBuilder res = new StringBuilder();
            JSONParser parser = new JSONParser();
            JSONObject temp = (JSONObject) parser.parse(inputStr);
            // От if до конца избавится не смог. В appendString передаю, JSONObject класс объекта, строку для вывода
            // результата и счтетчик для корректного вывода AND
            if(appendString(temp, "name", res, count)){count++;}
            if(appendString(temp, "country", res, count)){count++;};
            if(appendString(temp, "city", res, count)){count++;}
            appendString(temp, "age", res, count);

            return res.isEmpty()
                    ? request.replaceAll("WHERE", "")
                    : request + res.toString();
        }

        static boolean appendString(JSONObject temp, String obj, StringBuilder res, int count) {
            boolean bol = false;
            if (!temp.get(obj).toString().contains("null")) {
                // Передаем в appendAnd счетчик и строку для результата, если значение счетчика не 0, то он прибавляет AND
                appendAnd(count, res);
                res.append(" ").append(obj).append("=").append(temp.get(obj));
                bol = true;
            }
            // возвращаем истину или ложь, для увеличения счетчика
            return bol;
        }

        static void appendAnd(Integer count, StringBuilder res) {
            if (count == 0) {
                res.append("");
            } else {
                res.append(" AND");
            }
        }
    }
}
