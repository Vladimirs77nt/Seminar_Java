/* Задание 1.
1. Напишите метод, который заполнит массив из 1000 элементов случайными числами от 0 до 24.
1.5. Создайте метод, в который передайте заполненный выше массив, и с помощью Set вычислите
процент уникальных значений в данном массиве, и верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
*/

package Seminar6;

import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        int length = 1000;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*25);
        }
        System.out.println(statistic(array));
    }

    private static float statistic(int[] arr) {
        Set<Integer> uniq = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            uniq.add(arr[i]);
        }
        float result = uniq.size()*100f/arr.length;
        return result;
    }
}