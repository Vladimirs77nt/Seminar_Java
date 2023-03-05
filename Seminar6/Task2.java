/*
Задание 2.
1. Продумайте структуру класса Кот.
Какие поля и методы будут актуальны для приложения, которое является:
а) информационной системой ветеринарной клиники
б) архивом выставки котов
в) информационной системой Театра кошек Ю. Д. Куклачёва
Можно записать в текстовом виде, не обязательно реализовывать в java. 

Задание 3.
1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно 
использовать не все придуманные поля и методы. Создайте несколько 
экземпляров этого класса, выведите их в консоль.
2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась 
его кличка, цвет и возраст (или другие параметры на ваше усмотрение).
*/

package Seminar6;

import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        Vaccination vaccination = new Vaccination(LocalDate.of(2020,1,2), "P&G", "стобняк");
        System.out.println(vaccination);
        // vaccination.setDate(LocalDate.of(2020, 5, 20));
        // System.out.println(vaccination);

        Cat cat = new Cat("Матильда", "Дмитрий Иванов", "шртландская", LocalDate.of(2019, 10, 12),"серая");
        cat.addVaccination(vaccination);
        cat.addVaccination(new Vaccination(LocalDate.of(2021,3,8), "Aspo", "корь"));
        System.out.println(cat);
    }
}