/* Создать список типа ArrayList<String>.
Поместить в него как строки, так и целые числа.
Пройти по списку, найти и удалить целые числа. */

package Seminar3;

import java.util.ArrayList;

public class Task03 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("321");
        array.add("Земля");
        array.add("11");
        array.add("красный");
        array.add("124");
        array.add("веселье");
        array.add("125.6");
        System.out.println(array);

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) instanceof Integer){
            array.remove(i);
            i--;
            }
        }

        /* Вариант 2
        for (int i = 0; i < array.size(); i++) {
            boolean flag = array.get(i) instanceof Integer;
            if (flag) {
                System.out.println(array.get(i) + " - это число, удаляем...");
                array.remove(i);
                i --;
            }
            System.out.println(array.get(i) + " - это не число!"); 
        } */

        /* Вариант 3
        for (int i = 0; i < array.size(); i++) {
            try { 
                int value = Integer.parseInt(array.get(i));
                System.out.println(value + " - это число, удаляем...");
                array.remove(array.get(i));
                i --;
                continue;
            } catch (NumberFormatException e) {
                System.out.println(array.get(i) + " - это не число!"); 
                } 
        }
        System.out.println(array);
    } */
}
