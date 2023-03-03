/* Задача 3.
Реализовать алгоритм пирамидальной сортировки (HeapSort). */

package Seminar5;

import java.util.Arrays;

public class DZ3 {

    /*рекурсивный алгоритм heapify-down
    Узел с индексом `i` и 2 его прямых потомка нарушают свойство кучи */
    private static void heapify(int[] sortArr, int i, int size) {
        int left = 2 * i + 1; // левый потомок i-того элемента
        int right = 2 * i + 2; // правый потомок i-того элемента
        int largest = i;

        // сравниваем `A[i]` с его левым и правым дочерними элементами и находим
        // наибольшее значение
        if (left < size && sortArr[left] > sortArr[i])
            largest = left;
        if (right < size && sortArr[right] > sortArr[largest])
            largest = right;

        // поменяться местами с потомком, имеющим большее значение и вызовите
        // heapify-down для дочернего элемента
        if (largest != i) {
            int swap = sortArr[i];
            sortArr[i] = sortArr[largest];
            sortArr[largest] = swap;
            heapify(sortArr, largest, size);
        }
    }

    // функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] sortArr, int size) {
        if (size <= 0) { // если в куче нет элементов
            return -1;
        }
        int top = sortArr[0];

        // заменяем корень кучи последним элементом массива
        sortArr[0] = sortArr[size - 1];
        // вызовите heapify-down на корневом узле
        heapify(sortArr, 0, size - 1);
        return top;
    }

    // функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void heapSort(int[] sortArr) {
        // строим приоритетную очередь и инициализируем ее заданным массивом
        int n = sortArr.length;

        // build-heap: вызывать heapify, начиная с последнего внутреннего узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(sortArr, i--, n);
        }

        // несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            sortArr[n - 1] = pop(sortArr, n);
            n--;
        }
    }

    public static void main(String args[]) {
        int[] sortArr = { 23, 16, 43, 51, 215, 12, 28, 9, 99, 33, 100 };
        System.out.println("Исходный массив: " + Arrays.toString(sortArr));
        heapSort(sortArr);
        System.out.println("Отсортированный массив: " + Arrays.toString(sortArr));
    }
}