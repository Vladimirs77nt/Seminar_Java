/* Задача №1.
Реализовать алгоритм сортировки слиянием. */

package Seminar3;

import java.util.ArrayList;
import java.util.Random;

public class DZ1 {
    public static void main(String[] args) {
        // создание случайного списка чисел:
        ArrayList<Integer> numbers = createRandomArrayNum(8, 20);

        System.out.printf("%30s %s\n", "Исходный набор чисел: ", numbers.toString());
        ArrayList<Integer> numbersSorted = new ArrayList<>(sortingMerge(numbers));
        System.out.printf("%30s %s\n", "Отсортированный набор чисел: ", numbersSorted.toString());
    }

    // функция сортировки слиянием (вызывает доп.функцию слияния merge)
    private static ArrayList<Integer> sortingMerge(ArrayList<Integer> list) {
        if (list.size() < 2) { // проверяем - массив меньше 2 элементов?
            return list; // если меньше - то больше не делим массив
        }
        int indexMiddle = list.size() / 2; // индекс середины массива
        ArrayList<Integer> listA = new ArrayList<>(list.subList(0, indexMiddle));
        ArrayList<Integer> listB = new ArrayList<>(list.subList(indexMiddle, list.size()));
        listA = sortingMerge(listA);
        listB = sortingMerge(listB);
        return merge(listA, listB);
    }

    // дополнительная функция слияния двух массивов
    private static ArrayList<Integer> merge(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        ArrayList<Integer> listC = new ArrayList<>(listA);
        listC.addAll(listB);
        int positionA = 0, positionB = 0;
        for (int i = 0; i < listC.size(); i++) {
            if (positionA == listA.size()) {
                listC.set(i, listB.get(positionB));
                positionB++;
            } else if (positionB == listB.size()) {
                listC.set(i, listA.get(positionA));
                positionA++;
            } else if (listA.get(positionA) < listB.get(positionB)) {
                listC.set(i, listA.get(positionA));
                positionA++;
            } else {
                listC.set(i, listB.get(positionB));
                positionB++;
            }
        }
        return listC;
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