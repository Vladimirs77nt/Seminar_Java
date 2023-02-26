/* Задача №4 (ДЗ)
Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
!! Вычислить запись если это возможно. */

package Seminar4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class DZ4 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\nВведите арифметическое выражение: ");
        String inFormula = iScanner.nextLine();
        // String inFormula = "x^y/(544*z+(6-45*(10/2)-8))+10";
        // String inFormula = "10+10*5";
        iScanner.close();
        
        // вызов функции построения списка элементов математической записи
        ArrayList<String> formulaListOut = formulaList(inFormula);

        // вызов функции вывода постфиксной записи для арифметического выражения.
        String result = convertToRPN(formulaListOut);
        System.out.println("Результат преобразования в постфиксную запись: " + result);

        // решение арифметического выражения
        try {
            System.out.println(" >> Результат: " + resultOfRPN(result));
        } catch (EmptyStackException e) {
            System.out.println(" >> решения нет (присутствуют неизвестные) / ошибка: EmptyStackException");
        }
    }

// главная функция построения строки - на входе массив элементов ArrayList<String>
    public static String convertToRPN(ArrayList<String> elements) {
        Stack<String> stack = new Stack<>();
        String result = "";
        String item;
        for (int i = 0; i < elements.size(); i++) {
            item = elements.get(i);
            if (priority(item) > 0) { // если входящая это операция
                if (stack.isEmpty()) { // если стэк пустой - то операнд положить в стэк
                    stack.push(item);
                    continue;
                }

                if (priority(item) <= priority(stack.peek())) { // если приоритет входящей операции меньше или равен
                    while (!stack.isEmpty() && (priority(item) <= priority(stack.peek()))) { // операции из стека
                        result += stack.pop() + " "; // выталкивать операции из стека к выходной строке
                    }
                    stack.push(item); // входящую операцию положить в стек
                } else {
                    stack.push(item);
                }
                continue;
            }

            if (item.contains("(")) {
                stack.push(item);
                continue;
            }

            if (item.contains(")")) {
                while (!stack.peek().contains("(")) {
                    result += stack.pop() + " ";
                }
                stack.pop();
                continue;
            }

            result += item + " ";
        }
        while (!stack.isEmpty())
            result += stack.pop() + " ";
        return result;
    }

// функция проверки приоритета операции
    private static int priority(String str) {
        if (str.contains("^")) {
            return 3;
        }
        if (str.contains("*") | str.contains("/")) {
            return 2;
        }
        if (str.contains("+") | str.contains("-")) {
            return 1;
        }
        return 0;
    }

// функция "умной" разбивки математической записи на элементы
    private static ArrayList<String> formulaList(String inFormula) {
        String[] formulaList = inFormula.split("");
        ArrayList<String> formulaListOut = new ArrayList<>();
        String item = "";
        for (int i = 0; i < formulaList.length; i++) {
            if (formulaList[i].contains(" ")) {
                if (item != "")
                    formulaListOut.add(item);
                item = "";
                continue;
            } else if (formulaList[i].contains("(") |
                    formulaList[i].contains(")") |
                    formulaList[i].contains("+") |
                    formulaList[i].contains("-") |
                    formulaList[i].contains("*") |
                    formulaList[i].contains("/") |
                    formulaList[i].contains("^")) {
                if (item != "")
                    formulaListOut.add(item);
                formulaListOut.add(formulaList[i]);
                item = "";
                continue;
            } else {
                item = item + formulaList[i];
            }
        }
        if (item != "") {
            formulaListOut.add(item);
        }
        return formulaListOut;
    }

// функция вычисления резуьтата постфиксной строки
    public static double resultOfRPN(String str) {
        ArrayList<String> list = formulaList(str);
        Stack<Double> numbers = new Stack<>();
        for (String item : list) {
            if (isNumeric(item)) {
                numbers.push(Double.parseDouble(item));
                continue;
            }
            if (item.contains("^")) {
                double x = numbers.pop();
                double y = numbers.pop();
                numbers.push(Math.pow (y, x));
            }
            if (item.contains("+")) {
                double x = numbers.pop();
                double y = numbers.pop();
                numbers.push(x+y);
            }
            if (item.contains("-")) {
                double y = numbers.pop();
                double x = numbers.pop();
                numbers.push(x+y);
            }
            if (item.contains("*")) {
                double y = numbers.pop();
                double x = numbers.pop();
                numbers.push(x*y);
            }
            if (item.contains("/")) {
                double y = numbers.pop();
                double x = numbers.pop();
                numbers.push(x/y);
            }
        }
        return numbers.pop();
    }

// функция проверки строки на число / true - если число! иначе false
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }    
}