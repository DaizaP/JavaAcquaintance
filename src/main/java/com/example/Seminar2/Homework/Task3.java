package com.example.Seminar2.Homework;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;


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
        StringBuilder res = new StringBuilder();

        JSONParser parser = new JSONParser();
        //На основе полученной информации из файла делаем массив JSONArray в котором JSONObject.
        JSONArray rootJsonObject = (JSONArray) parser.parse(fileRead(pathIn));
        // Создаем итератор, чтобы можно было пройтись циклом и наполняем строку.
        Iterator students = rootJsonObject.iterator();
        while (students.hasNext()) {
            JSONObject test = (JSONObject) students.next();
            res.append("Студент " + test.get("фамилия")
                    + " получил " + test.get("оценка")
                    + " по предмету " + test.get("предмет") + "\n");
        }
        fileWriter(pathOut, res.toString());
        System.out.println("Done");
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
            ;
        }
        return reader;
    }
}
