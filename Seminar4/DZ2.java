/* Задача №2 (ДЗ)
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя. */

package Seminar4;

import java.util.LinkedList;
import java.util.Scanner;

public class DZ2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println("\n >>> очередь: пустая...\n");
        Scanner iScanner = new Scanner(System.in, "cp866");
        do {
            System.out.println("Введите команду работы с очередью: ");
            System.out.println("команда: enqueue <пробел> любое слово/число -> помещает элемент в конец очереди");
            System.out.println("команда: dequeue -> возвращает первый элемент из очереди и удаляет его");
            System.out.println("команда: first -> возвращает первый элемент из очереди, не удаляя");
            System.out.println("exit - Завершение программы\n");
            String command = iScanner.nextLine();

            // enqueue() - помещает элемент в конец очереди / аналог push() из стека
            if (command.contains("enqueue")) {
                System.out.println(" >>> выполняетя команда enqueue()...");
                String[] items = command.split(" ");
                String item = items[1]; // выделяем введеное значение после команды enqueue
                System.out.println(" >>> элемент (" + item + ") добавлен в очередь");
                // ---> вызов метода enqueue()
                enqueue(list, item);
                System.out.println("очередь:" + list + "\n");
            }

            // dequeue() - возвращает первый (верхний) элемент из очереди и удаляет его -
            // аналог pop() из Stack
            if (command.contains("dequeue")) {
                System.out.println(" >>> выполняетя команда dequeue()...");
                // ---> вызов функции dequeue()
                String item = dequeue(list);
                if (item != null) {
                    System.out.println("первый элемент в очереди: " + item);
                    System.out.println(" >>> элемент (" + item + ") удален из очереди!");
                    System.out.println("очередь:" + list + "\n");
                }
            }

            // first() - возвращает первый (верхний) элемент из очереди, не удаляя его -
            // аналог peek() из Stack
            if (command.contains("first")) {
                System.out.println(" >>> выполняетя команда first()...");
                // ---> вызов функции first()
                String item = first(list);
                System.out.println("первый элемент в очереди: " + item);
                System.out.println("очередь:" + list + "\n");
            }

            if (command.contains("exit")) {
                System.out.println(" >>> завершение программы...");
                break;
            }
        } while (true);
        iScanner.close();
    }

    // ФУНКЦИЯ: enqueue() - помещает элемент в конец очереди - аналог push() из
    // Stack
    private static void enqueue(LinkedList<String> list, String item) {
        list.addLast(item);
    }

    // ФУНКЦИЯ: dequeue() - возвращает первый элемент из очереди и удаляет его -
    // аналог pop() из Stack
    private static String dequeue(LinkedList<String> list) {
        if (list.isEmpty()) {
            System.out.println("ошибка! очередь пустая!\n");
            return null;
        }
        String itemFirst = list.get(0);
        list.remove(0);
        return itemFirst;
    }

    // ФУНКЦИЯ: first() - возвращает первый элемент из очереди, не удаляя - аналог
    // peek() из Stack
    private static String first(LinkedList<String> list) {
        return list.get(0);
    }
}

// ФУНКЦИЯ - поиск значения между скобками
// private static String itemCut(String string) {
// Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
// java.util.regex.Matcher matcher = pattern.matcher(string);
// String item;
// if (matcher.find()) {
// item = matcher.group(1);
// }
// return item;