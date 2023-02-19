/* Заполнить список десятью случайными числами.
Отсортировать список методом sort() и вывести его на экран. */

package Seminar3;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Task01 {
    public static void main(String[] args) {
        ArrayList<Integer> collection = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            collection.add(rnd.nextInt(100));
        }
        System.out.println(collection);
        System.out.println();

        collection.sort(new MyComparator());
        System.out.println(collection);
    }
}