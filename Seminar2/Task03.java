/** Задание 2. Напишите метод, который принимает на вход строку (String) и определяет
является ли строка палиндромом (возвращает boolean значение). */

package Seminar2;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        System.out.print("Введите строку для проврки на полиндром: ");
        Scanner iScanner = new Scanner(System.in);
        String str = iScanner.next();
        iScanner.close();
        System.out.print(polindrom(str));
        } 

    private static boolean polindrom(String str){
        for (int i = 0; i < str.length()-i; i++) {
            System.out.print(i);
            if (str.charAt(i) != str.charAt(str.length()-i-1)) return false;
        }
        return true;
    }
}