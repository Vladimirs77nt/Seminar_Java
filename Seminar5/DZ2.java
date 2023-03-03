/* Задача 2.
Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
 */

package Seminar5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DZ2 {
    public static void main(String[] args) {
        String[] name = {"Иван", "Антон", "Матвей", "Алексей", "Сергей", "Дима", "Иван", "Дима",
                        "Евгений", "Иван", "Дима", "Иван", "Сергей", "Иван" };
        Map<String, Integer> worker = new HashMap<>();
        // в цикле заполняем Map именами и их количеством
        for (String string : name) {
            if (worker.containsKey(string))
                worker.put(string, worker.get(string) + 1);
            else
                worker.put(string, 1);
        }
        System.out.println("Не сортированный список: " + worker);
        worker = sortByValues(worker);
        System.out.println("Сортированный список: " + worker);
    }

    // функция сортировки Map по убыванию
    public static Map<String, Integer> sortByValues(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        // sortedMap.entrySet().forEach(System.out::println);
        return sortedMap;
    }
}