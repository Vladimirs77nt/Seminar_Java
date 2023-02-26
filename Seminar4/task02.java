/* Задача №2
Реализовать консольное приложение, которое:
Принимает от пользователя и “запоминает” строки.
Если введено print, выводит строки так, чтобы последняя введенная была первой в списке,
а первая - последней. Если введено revert, удаляет предыдущую введенную строку из памяти. */

package Seminar4;

import java.util.LinkedList;
import java.util.Scanner;

/* Вариант 1 - мой вариант */
public class task02 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.print("Введите текст: ");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String text = iScanner.nextLine();

        while (!text.equals("exit")) {
            if (text.equals("print")) {
                System.out.print(" >>> Вывод списка (с конца): [");
                for (int i = 0; i < list.size()-1; i++) {
                    System.out.print(list.get(list.size()-i-1)+", ");
                }
                System.out.print(list.get(0));
                System.out.println("]");
            }
            else if (text.equals("revert")) {
                System.out.println(" >>> Удаление последней записи...");
                list.removeLast();
                System.out.println(" >>> Вывод списка: " + list);
                } else {
                    System.out.println(" >>> Запись в список...");
                    list.add(text);
                }
            System.out.print("Введите текст (exit - выход): ");
            text = iScanner.nextLine();
        } 
    iScanner.close();
    } 
}