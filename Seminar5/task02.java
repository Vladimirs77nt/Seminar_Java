/* Написать программу, определяющую правильность расстановки скобок в выражении. */

package Seminar5;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите  строку:");
        String string = scanner.nextLine();

        scanner.close();
        
        System.out.println(isValid(string));
    }

    private static boolean isValid(String formula) {
        Map<Character, Character> bracketsDict = new HashMap<>();
        bracketsDict.put('(', ')');
        bracketsDict.put('{', '}');
        bracketsDict.put('[', ']');
        bracketsDict.put('<', '>');
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        for (char c : formula.toCharArray()) {
            if (bracketsDict.containsKey(c)) brackets.add(c);
            if (bracketsDict.containsValue(c)) {
                if (brackets.isEmpty()) return false;
                if (bracketsDict.get(brackets.peek()) == c)
                    brackets.pop();
                else return false;
            }
        }
        return brackets.isEmpty();
    }
}