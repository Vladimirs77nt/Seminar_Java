/* Задание №1.
Реализовать консольное приложение, которое:
Принимает от пользователя строку вида text~num
Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка. */

package Seminar4;

import java.util.LinkedList;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.print("Введите текст в виде text~num: ");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String text = iScanner.nextLine();
        String[] textarray = text.split("/");

        while (!textarray[0].equals("exit")) {
            System.out.println(list);
            if (textarray[0].equals("print")) {
                int index = Integer.parseInt (textarray[1]);
                System.out.println(" >>> Вывод текста с позиции(" + index + ") = " + list.get(index));
                list.remove(index);
                System.out.println(list);
            }
            else {
                int index = Integer.parseInt (textarray[1]);
                if (index>list.size()-2) {
                    int count = index-list.size();
                    for (int i = 0; i < count+1; i++) {
                        System.out.println(i);
                        list.addLast(null);
                    }
                }
                System.out.println(" >>> Запись текста на позицию [" + index + "]...");
                list.set(index, textarray[0]);
                System.out.println(list);
            }
            System.out.print("Введите текст в виде text~num (exit - выход): ");
            text = iScanner.nextLine();
            textarray = text.split("/");
        } 
    iScanner.close();
    } 
}
