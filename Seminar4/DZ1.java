/* Задача №1 (ДЗ)
Пусть дан LinkedList с несколькими элементами.
Реализуйте метод, который вернет “перевернутый” список. */

package Seminar4;

import java.util.LinkedList;

public class DZ1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println("Исходный список: " + list);
        System.out.println("Перевернутый список: " + ListFlipBack(list));

    }

    // метод, который возвращает “перевернутый” список
    private static LinkedList<Integer> ListFlipBack(LinkedList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(list.remove(size - i - 1));
        }
        return list;
    }
}