/* Задача №2
Реализовать консольное приложение, которое:
Принимает от пользователя и “запоминает” строки.
Если введено print, выводит строки так, чтобы последняя введенная была первой в списке,
а первая - последней. Если введено revert, удаляет предыдущую введенную строку из памяти. */

package Seminar4;

import java.util.ArrayDeque;
import java.util.Scanner;

/* Вариант 2 - вариант с семинара */
public class task02v2 {
    public static void main(String[] args) {
        ArrayDeque<String> list = new ArrayDeque<String>(){};
        System.out.print("Введите текст: ");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String text = iScanner.nextLine();

        while (!text.equals("exit")) {
            if (text.equals("print")) {
                System.out.println(" >>> Вывод списка: " + list);
            }
            else if (text.equals("revert")) {
                System.out.println(" >>> Удаление последней записи...");
                // list.removeFirst();
                list.pop();
                System.out.println(" >>> Вывод списка: " + list);
            } else {
                System.out.println(" >>> Запись в список...");
                // list.addFirst(text);
                list.push(text);
            }
            System.out.print("Введите текст (exit - выход): ");
            text = iScanner.nextLine();
        } 
    iScanner.close();
    } 
}