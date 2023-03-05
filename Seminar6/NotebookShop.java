/*
Задача 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
Реализовать в java.

Задача 2. Создать множество ноутбуков.

Задача 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map (необязательно!)
Например:
    “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …

Задача 4. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
фильтрации можно также в Map.

Задача 5. Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
  */

package Seminar6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NotebookShop {
    static Scanner iScanner = new Scanner(System.in, "cp866");

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("KLVF-X", "HUAWEI", 14f, "Intel Core i5 1240P",
                16, 512, "Windows 11 Home", "серый", 99890f));
        notebooks.add(new Notebook("G16", "HIPER", 16.1f, "Intel Core i7 11700",
                16, 1024, "Windows 11 Professional", "черный", 174970f));
        notebooks.add(new Notebook("Corebook X 14/8/512", "CHUWI", 14f, "Intel Core i3 10110U",
                8, 512, "Windows 11 Home", "серебристый", 31890f));
        notebooks.add(new Notebook("A2337", "APPLE", 13.3f, "Apple M1 8 core",
                8, 256, "Mac OS", "золотой", 89890f));
        notebooks.add(new Notebook("A315-24P-R16W", "ACER", 15.6f, "AMD Ryzen 3 7320U",
                8, 256, "Eshell", "серебристый", 42890f));

        System.out.println("Ноутбуки в магазине:");
        printNotebook(notebooks);       // вывод списка ноутбуков
        interfaceCriteria(notebooks);   // вызов интерфейса выбора критериев и параметров
    }

    // функция получения множества ноутбуков проходящих по заданным критериям (RAM, ROM, ОС, цвет)
    private static Set<Notebook> searhByParameters(Set<Notebook> notebooks, int ram, int rom, String os, String color) {
        Set<Notebook> notebooksSuitable = new HashSet<>();
        for (Notebook notebook : notebooks)
            if (notebook.byFilter(null, null, 0f, null, ram, rom,
                    os, color, 0f))
                notebooksSuitable.add(notebook);
        return notebooksSuitable;
    }

    // интерфейс выбора КРИТЕРИЯ
    private static void interfaceCriteria(Set<Notebook> notebooks) {
        do {
            System.out.println("\nВыберите критерий выбора списка ноутбуков:");
            System.out.println(" > 1. Оперативная память");     // RAM
            System.out.println(" > 2. Память SSD / Диск");      // ROM
            System.out.println(" > 3. Операционная система");   // OS
            System.out.println(" > 4. Цвет");                   // COLOR
            System.out.println(" > 0. завершение работы");
            String choice = iScanner.nextLine();

            if (choice.equals("0"))  // завершение программы
                break;

            if (choice.equals("1")) { // выбор по памяти ОЗУ (RAM)
                int parameter = Integer.parseInt(interfaceParameter());
                Set<Notebook> result = searhByParameters(notebooks, parameter, 0,null, null);
                if (result.size()>0) {
                    System.out.println("\nНоутбуки с оперативной памятью " + parameter + " Гб или более:");
                    printNotebook(result);
                }
                else System.out.println("!!! ноутбуков с подходящими параметрами нет...");
            }

            if (choice.equals("2")) { // выбор по памяти SSD/Диска (ROM)
                int parameter = Integer.parseInt(interfaceParameter());
                Set<Notebook> result = searhByParameters(notebooks, 0, parameter, null, null);
                if (result.size()>0) {
                    System.out.println("\nНоутбуки с памятью SSD (диск) " + parameter + " Гб или более:");
                    printNotebook(result);
                }
                else System.out.println("!!! ноутбуков с подходящими параметрами нет...");
            }

            if (choice.equals("3")) { // выбор по операционной системе
                String parameter = interfaceParameter();
                Set<Notebook> result = searhByParameters(notebooks, 0, 0, parameter, null);
                if (result.size()>0) {
                    System.out.println("\nНоутбуки с установленной операционной системой " + parameter + ":");
                    printNotebook(result);
                }
                else System.out.println("!!! ноутбуков с подходящими параметрами нет...");
            }

            if (choice.equals("4")) { // выбор по цвету
                String parameter = interfaceParameter();
                Set<Notebook> result = searhByParameters(notebooks, 0, 0, null, parameter);
                if (result.size()>0) {
                    System.out.println("\nНоутбуки с цветом " + parameter + ":");
                    printNotebook(result);
                }
                else System.out.println("!!! ноутбуков с подходящими параметрами нет...");
            }

        } while (true);
    }

    // интерфейс получения ПАРАМЕТРА критерия
    private static String interfaceParameter() {
        do {
            System.out.print("введите параметр фильтрации (для чисел это минимальный порог, для текста это любое слово): ");
            String parameter = iScanner.nextLine();
            if (!(parameter == null)) {
                return parameter;
            }
        } while (true);
    }

    // функция печати списка ноутбуков
    private static void printNotebook(Set<Notebook> notebooks) {
        for (Notebook notebook : notebooks)
            System.out.println(" > " + notebook);
    }

}