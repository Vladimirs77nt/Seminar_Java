// Написать программу, которая запросит пользователя ввести <Имя> в консоли.
// Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”

// package Seminar1;
import java.util.Scanner;

public class Task01{
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in, "cp866");
        System.out.printf("Ваше имя: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        iScanner.close();
    }
}