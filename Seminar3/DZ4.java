/* Задача №4.
(Необязательная задача повышенной сложности)
Даны два ArrayList из целых чисел.
Написать функции, которые вычисляют разницу коллекций:
Разность:
A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
B - A = все числа из второй коллекции, которые не содержатся в первой
Симметрическая разность:
A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
*/

package Seminar3;

import java.util.ArrayList;
import java.util.Random;

public class DZ4 {
    public static void main(String[] args) {
        // создание случайного списка чисел - список А:
        ArrayList<Integer> listA = createRandomArrayNum(5, 10);
        ArrayList<Integer> listB = createRandomArrayNum(5, 10);
        System.out.println("Список чисел А: " + listA);
        System.out.println("Список чисел B: " + listB);
        System.out.println("Разница двух списков А-В: " + differenseList(listA, listB));
        System.out.println("Разница двух списков В-А: " + differenseList(listB, listA));
        System.out.println("Симметричная разность списков А и В: " + differenseListSymmetric(listA, listB));
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

    // функция вычисления разницы двух коллекций
    private static ArrayList<Integer> differenseList(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        // специально делаю новые коллекции-копии, чтобы не менять исходные коллекции
        ArrayList<Integer> arrA = new ArrayList<>(listA);
        ArrayList<Integer> arrB = new ArrayList<>(listB);
        for (int i = 0; i < arrB.size(); i++) {
            int num = arrB.get(i);
            if (arrA.indexOf(num) >= 0) {
                arrA.remove(arrA.indexOf(num));
                arrB.remove(i);
                i--;
            }
        }
        return arrA;
    }

    // функция вычисления симметричной разницы двух коллекций
    private static ArrayList<Integer> differenseListSymmetric(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        // симметричная разница двух коллекций - это сумма двух обратных разностей
        ArrayList<Integer> arrDiff = new ArrayList<>(differenseList(listA, listB));
        arrDiff.addAll(differenseList(listB, listA));
        return arrDiff;
    }
}