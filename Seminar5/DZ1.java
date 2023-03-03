/* Задача 1.
Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
что один человек может иметь несколько телефонов. */

package Seminar5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DZ1 {
    static Map<String, ArrayList<String>> telephoneBook = new HashMap<>(); // телефонная книга
    // внимание! телефонные номера решил записывать по типу String - так удобнее отображается
    
    public static void main(String[] args) {
        telephoneAdd("Иванов", "+7(912)1234567");
        telephoneAdd("Иванов", "+7(982)4569871");
        telephoneAdd("Захаров", "+7(3435)234871");
        telephoneAdd("Брачун", "+7(999)2316598");
        telephoneAdd("Вовк", "+7(992)2357412");
        telephoneAdd("Захаров", "+7(901)1020001");
        for (Entry<String, ArrayList<String>> entry : telephoneBook.entrySet()) {
            System.out.println(entry);
        }
    }

    // фунция добавления номера телефона по имени
    private static void telephoneAdd(String name, String telephoneNumber) {
        ArrayList<String> phone = new ArrayList<>();
        if (telephoneBook.containsKey(name))
            phone = telephoneBook.get(name);
        phone.add(telephoneNumber);
        telephoneBook.put(name, phone);
    }
}