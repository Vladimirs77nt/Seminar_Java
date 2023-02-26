/* Задача №3 (ДЗ)
* В калькулятор добавьте возможность отменить последнюю операцию. */

package Seminar4;

import java.util.Scanner;
import java.util.Stack;

public class DZ3 {
    public static void main(String[] args) {
        Stack<String> calcMemory = new Stack<>();
        System.out.println("\nОчень простой калькулятор! Работа только с целыми числами");
        System.out.println("Допустимые операции только ( +, -, *, / ) и все...");
        Scanner iScanner = new Scanner(System.in);
        do {
            System.out.println("\nВведите данные в формате: первое число (пробел) операция (пробел) второе число");
            System.out.println(" * внимание! операции только такие => +, -, *, /");
            System.out.println(" * exit -> завершение программы");
            System.out.println(" * print -> вывести из памяти список записанных операций");
            System.out.println(" * cancel -> отменить последнюю операци (удалить из памяти)");
            String string = iScanner.nextLine();
            System.out.println();
            if (string.contains("exit"))
                break;
            if (string.contains("print")) {
                printCalcMemory(calcMemory);
                continue;
            }
            if (string.contains("cancel")) {
                calcMemory.pop();
                System.out.println(" >>> последняя операция стерта из памяти калькулятора...");
                printCalcMemory(calcMemory);
                continue;
            }
            String[] calculation = string.split(" ");
            int num1 = Integer.parseInt(calculation[0]);
            int num2 = Integer.parseInt(calculation[2]);
            String operation = calculation[1];
            int res = 0;
            switch (operation) {
                case ("+"):
                    res = num1 + num2;
                    System.out.println(" >>> Операция сложения:  ");
                    break;
                case ("-"):
                    res = num1 - num2;
                    System.out.println(" >>> Операция вычитания:  ");
                    break;
                case ("*"):
                    res = num1 * num2;
                    System.out.println(" >>> Операция умножения:  ");
                    break;
                case ("/"):
                    res = num1 / num2;
                    System.out.println(" >>> Операция деления:  ");
                    break;
                default:
                    System.out.println(" >>> Введена неверная операция. Введите заново!");
                    break;
            }
            operation = num1 + " " + operation + " " + num2 + " = " + res;
            System.out.println(operation);
            calcMemory.add(operation);
            System.out.println(" >>> операция записана в память калькулятора...");
        } while (true);
        iScanner.close();
    }

    private static void printCalcMemory(Stack<String> list) {
        System.out.println("--- СПИСОК ПРОИЗВЕДЕННЫХ ВЫЧИСЛЕНИЙ НА КАЛЬКУЛЯТОРЕ ---");
        if (list.empty()) {
            System.out.println(" >>> в памяти нет записей");
        }
        for (String string : list) {
            System.out.println("> " + string);
        }
    }
}