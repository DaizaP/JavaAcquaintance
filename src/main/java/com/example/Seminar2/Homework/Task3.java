package com.example.Seminar2.Homework;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


//3) Дана строка (сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder,
// создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.
public class Task3 {

    public static void main(String[] args) throws IOException, ParseException {
        String pathIn = "src\\main\\java\\com\\example\\Seminar2\\Homework\\Task3in.json";
        String pathOut = "src\\main\\java\\com\\example\\Seminar2\\Homework\\Task3out.txt";
        // Красивый вывод двух вариантов
        String res = Sol1Task3.jsonParser(pathIn) + Sol2Task3.Parser(pathIn);
        fileWriter(pathOut, res);
    }

    static class Sol1Task3 {
        public static String jsonParser(String pathIn) throws IOException, ParseException {
            StringBuilder res = new StringBuilder("Решение через JSONParser: \n");
            JSONParser parser = new JSONParser();
            //На основе полученной информации из файла делаем массив JSONArray в котором JSONObject.
            JSONArray rootJsonObject = (JSONArray) parser.parse(fileRead(pathIn));
            // Создаем итератор, чтобы можно было пройтись циклом и наполняем строку.
            for (Object o : rootJsonObject) {
                JSONObject test = (JSONObject) o;
                res.append("Студент ")
                        .append(test.get("фамилия"))
                        .append(" получил ")
                        .append(test.get("оценка"))
                        .append(" по предмету ")
                        .append(test.get("предмет"))
                        .append("\n");
            }
            System.out.println("JSONParser Done");
            return res.toString();
        }


    }

    static class Sol2Task3 {
        public static String Parser(String pathIn) {
            StringBuilder res = new StringBuilder("Решение через ручное разложение: \n");
            //Временная строка
            StringBuilder temp = new StringBuilder();
            Scanner scan = new Scanner(fileRead(pathIn));
            //Наполняем строку входными данными
            while (scan.hasNext()) {
                temp.append(scan.nextLine());
            }
            scan.close();
            //Добавляем в результат разложенную и сформированную строку
            res.append(stringParse(temp.toString()));
            System.out.println("Ручное раскладывание Done");
            return res.toString();

        }

        public static String stringParse(String inputStr) {
            StringBuilder res = new StringBuilder();
            //Множественный реплейс и сплит в массив
            String[] tempList = inputStr.replace("}]", "")
                    .replace("[{", "")
                    .split("},\\{");
            for (String pair : tempList) {
                // Делаем массив в массиве
                String[] tempList2 = pair.split(",");
                for (String pair2 : tempList2) {
                    // Ещё один массив в массиве и составление строки
                    String[] keyValue = pair2.split(":");
                    if (keyValue[0].contains("фамилия")) {
                        res.append("Студент ").append(keyValue[1]);
                    } else if (keyValue[0].contains("оценка")) {
                        res.append(" получил ").append(keyValue[1]);
                    } else if (keyValue[0].contains("предмет")) {
                        res.append(" по предмету ").append(keyValue[1]).append("\n");
                    }

                }
            }
            return res.toString().replace("\"", "");
        }

    }

    public static void fileWriter(String out, String str) {
        try (FileWriter writer = new FileWriter(out)) {
            writer.write(str);

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }

    public static FileReader fileRead(String in) {
        FileReader reader = null;
        try {
            reader = new FileReader(in);

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return reader;
    }
}
