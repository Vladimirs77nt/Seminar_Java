/** В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
Значения null не включаются в запрос. */

package Seminar2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DZ1 {
    public static void main(String[] args) {
        String str = readString("students.txt");  // название файла со строкой JSON
        System.out.println(">>> SQL запрос: " + createSQLstring(stringToArray(str)));
    }

    // функция чтения файла и возвращения строки
    public static String readString(String filename) {
        try (FileReader file = new FileReader(filename)) {
            BufferedReader reader = new BufferedReader(file);
            String fileStr = reader.readLine();
            file.close();
            System.out.println(">>> файл успешно прочитан...");
            return fileStr;
        } catch (IOException ex) {
            System.err.println("Ошибка: " + ex);
            return "ошибка";
        }
    }

    // функция преобразования строки в двумерный массив (типа словаря)
    public static String[][] stringToArray(String string) {
        System.out.println(">>> исходная строка:\n" + string);
        // удаляем из строки в начале и в конце фигурные скобки и кавычки
        string = string.replace("{", "");
        string = string.replace("}", "");
        // разбиваем "словарь" на элементы КЛЮЧ:ЗНАЧЕНИЕ
        String[] arr = string.split(", ", 0);
        String[][] array = new String [arr.length][2];
        // в цикле формируем двумерный массив
        for (int i = 0; i < arr.length; i++) {
            String[] element = arr[i].split(":", 0);
            element[0] = element[0].replace("\"", "");
            array[i][0] = element[0];   // key
            array[i][1] = element[1];  // value
        }
        return array;
    }

    private static String createSQLstring (String[][] array){
        StringBuilder stringSQL = new StringBuilder();
        // формирование шаблонной строки
        // SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
        stringSQL.append("SELECT * FROM students WHERE ");
        for (int i = 0; i < array.length; i++) {
            if (array[i][1].indexOf("null")>=0) continue;
            if (i>0) stringSQL.append(" AND ");
            stringSQL.append(array[i][0]);
            stringSQL.append(" = ");
            stringSQL.append(array[i][1]);
        }
        return stringSQL.toString();
    }
}