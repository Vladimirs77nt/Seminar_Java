/** Задание 3. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST
и метод, который запишет эту строку в простой текстовый файл, обработайте исключения. */

package Seminar2;

import java.io.FileWriter;
import java.io.IOException;

public class Task04 {
    public static void main(String[] args) {
        String str = repeatString("TEST\n");
        writeString (str);
    }

    public static String repeatString(String part) {
        StringBuilder fullMarker = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            fullMarker.append(part);
        }
        return fullMarker.toString();
    }

    /* Вариант 1 - старомодный */
    public static void writeStringOld (String string){
        FileWriter file = null;
        try {
            file = new FileWriter("test.txt");
            file.append(string);
        }
        catch (IOException ex) {
            System.err.println("Ошибка: " + ex);
        }
        finally {
            if (file != null) {
                try {
                file.close();
                }
                catch (IOException ex) {
                    System.err.println("Ошибка: " + ex);
                }
            }
        }
    }

    /* Вариант 2 - современный */
    public static void writeString (String string){
        try(FileWriter file = new FileWriter("test.txt")) {
            file.append(string);
            System.out.println("файл успешно записан");
            file.close();
        }
        catch (IOException ex) {
            System.err.println("Ошибка: " + ex);
        }
    }
}