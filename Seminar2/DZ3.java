/** В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и,
используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */

package Seminar2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DZ3 {
    public static void main(String[] args) {
        String str = readString("DZ3_text.txt");  // название файла со строкой JSON
        Map[] arrayMap = stringToArray(str);                // созадние массива словарей 
        System.out.println(">>> форматированный вывод:");
        for (int i = 0; i < arrayMap.length; i++) {         // в цикле выводим шаблонный текст
            StringBuilder string = new StringBuilder();
            Map dictionary = arrayMap[i];
            string.append("Студент ");
            string.append(dictionary.get("фамилия"));
            string.append(" получил ");
            string.append(dictionary.get("оценка"));
            string.append(" по предмету ");
            string.append(dictionary.get("предмет"));
            System.out.println(string.toString());
            /* НО! короче было бы использовать форматированный вывод! вот так:
            System.out.printf("Студент %s получил %s по предмету %s\n", dictionary.get("фамилия"),  dictionary.get("оценка"),dictionary.get("предмет")); */
        }
    }

    // функция чтения файла и возвращения строки
    public static String readString (String filename){
        try(FileReader file = new FileReader(filename)){
            BufferedReader reader = new BufferedReader(file);
            String fileStr = reader.readLine();
            file.close();
            System.out.println(">>> файл успешно прочитан...");
            return fileStr;
        }
        catch (IOException ex) {
            System.err.println("Ошибка: " + ex);
            return "ошибка";
        }
    }

    // функция преобразования строки в массив словарей
    public static Map[] stringToArray (String string){
        System.out.println(">>> исходная строка:\n" + string);
        // удаляем из строки лишние символы
        string = string.replace("[", "");
        string = string.replace("]", "");
        string = string.replace("{", "");
        string = string.replace("}", "");
        string = string.replace("\"", "");
        // разбиваем "словарь" на элементы
        String[] array = string.split(", ", 0);
        // создание массива словарей
        Map[] arrayMap = new Map[array.length]; // инициализируем массив словарей
        for (int i = 0; i < array.length; i++) {
            String[] record = array[i].split(",", 0);
            Map<String,String> dictionary = new HashMap<String,String>();
            for (int j = 0; j < record.length; j++) {
                String[] element = record[j].split(":", 0);
                String key = element[0];
                String value = element[1];
                dictionary.put(key, value);
            } 
            arrayMap[i] = dictionary;
        }
        System.out.println(">>> массив словарей готов:\n" + Arrays.toString(arrayMap));
        return arrayMap;
    }
}