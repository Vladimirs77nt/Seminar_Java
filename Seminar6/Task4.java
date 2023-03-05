package Seminar6;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Task4 {
    public static void main(String[] args) {
        Set<Cat> myCats = new HashSet<>();
        myCats.add(new Cat("Барсик", "Иван", "мейкун",
                LocalDate.of(2020,01,10), "черепаховый"));
        myCats.add(new Cat("Васька", "Иван", "дворовая",
                LocalDate.of(2021,03,14), "серый"));
        myCats.add(new Cat("Манюня", "Иван", "дворовая",
                LocalDate.of(2021,03,14), "белая"));
        myCats.add(new Cat("Манюня", "Иван", "дворовая",
                LocalDate.of(2021,03,14), "белая"));
        System.out.println(myCats);
    }
}
