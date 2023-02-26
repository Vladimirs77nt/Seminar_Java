/* Задание № 0
1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим. */

package Seminar4;

import java.util.ArrayList;
import java.util.LinkedList;

public class task00 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ArrayList <Integer> arraynum = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arraynum.add((int) (Math.random()*100));
            // System.out.print(arraynum.get(i));
        }
        System.out.println("Заполнение массива на 10.000 элементов заняло: " + (System.currentTimeMillis()-time));

        time = System.currentTimeMillis();
        LinkedList <Integer> arraynum2 = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            arraynum2.add((int) (Math.random()*100));
            // System.out.print(arraynum.get(i));
        }
        System.out.println("Заполнение массива на 10.000 элементов заняло: " + (System.currentTimeMillis()-time));
    }
}
