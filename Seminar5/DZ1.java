/* Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
что один человек может иметь несколько телефонов. */

package Seminar5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DZ1 {
    public static void main(String[] args) {
        Map<String, ArrayList<Long>> telephoneBook = new HashMap<>();
        ArrayList<Long> phone = new ArrayList<>();
        String name;
        name = "Иванов";
        phone.add(89521234567);
        phone.add(123);
        phone.add(38578753);
        telephoneBook.put("Иванов", phone);
        System.out.println(telephoneBook);
        phone = telephoneBook.get("Иванов");

        phone.remove(0);
        telephoneBook.put("Иванов", phone);
        System.out.println(telephoneBook);
    }
}
