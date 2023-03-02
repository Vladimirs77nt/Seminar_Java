/* Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
что один человек может иметь несколько телефонов. */

package Seminar5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DZ1 {
    static Map<String, ArrayList<String>> telephoneBook = new HashMap<>();
    public static void main(String[] args) {
        telephoneAdd("Иванов", "+7(912)1234567");
        telephoneAdd("Иванов", "+7(982)4569871");
        System.out.println(telephoneBook);
    }

    private static void telephoneAdd(String name, String telephoneNumber) {
        ArrayList<String> phone = new ArrayList<>();
        if (telephoneBook.containsKey(name))
            phone = telephoneBook.get(name);
        phone.add(telephoneNumber);
        System.out.println(phone);
        telephoneBook.put(name, phone);
    }
}