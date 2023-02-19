/* Задача №3.
Задан целочисленный список ArrayList.
Найти минимальное, максимальное и среднее арифметичское этого списка.
 */

package Seminar3;

import java.util.ArrayList;
import java.util.Random;

public class DZ3 {
    public static void main(String[] args) {
        // создание случайного списка чисел:
        ArrayList<Integer> numbers = createRandomArrayNum(10, 100);
        System.out.println("Список чисел: " + numbers);
        int max = numbers.get(0);
        int min = numbers.get(0);
        float arithmeticMean = 0;
        // поиск минимальльного и максимального, подсчет суммы
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max)
                max = numbers.get(i);
            if (numbers.get(i) < min)
                min = numbers.get(i);
            arithmeticMean += numbers.get(i);
        }
        arithmeticMean += arithmeticMean / numbers.size();
        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);
        System.out.println("Среднее арифметическое: " + arithmeticMean);
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