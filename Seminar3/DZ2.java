/* Задача №2.
Пусть дан произвольный список целых чисел. Удалить из него чётные числа. */

package Seminar3;

import java.util.ArrayList;
import java.util.Random;

public class DZ2 {
    public static void main(String[] args) {
        // создание случайного списка чисел:
        ArrayList<Integer> numbers = createRandomArrayNum(10, 100);
        System.out.println("Исходный список чисел: " + numbers);

        // поиск и удаление четных чисел:
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
        System.out.println("Список чисел без четных: " + numbers);
    }

    // функция создания списка случайных чисел (кол-во: size, максимальное число:
    // max)
    private static ArrayList<Integer> createRandomArrayNum(int size, int max) {
        // создание случайного списка чисел размером size
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(rnd.nextInt(max));
        }
        return numbers;
    }
}