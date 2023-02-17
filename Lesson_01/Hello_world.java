package Lesson_01;

import java.util.Scanner;

/**
 * Hello world
 */
public class Hello_world {
    public static void main(String[] args) {
        short age = 10;
        int salary = 123456;
        System.out.println(age);        //10
        System.out.println(salary);     //123456

        float e = 2.7f;
        double pi = 3.1415;
        System.out.println(e);        // 2.7
        System.out.println(pi);       // 3.1415

        char ch = '1';
        System.out.println(Character.isDigit(ch));  // true
        ch = 'a';
        System.out.println(Character.isDigit(ch));  // false

        boolean flag1 = 123 <= 234;
        System.out.println(flag1);  // true
        boolean flag2 = 123 >= 234 || flag1;
        System.out.println(flag2);  // true
        boolean flag3 = flag1 ^ flag2;
        System.out.println(flag3);  // false

        // НЕЯВНАЯ ТИПИЗАЦИЯ
        var a0 = 123;
        System.out.println(a0);  // 123
        var d0 = 123.456;
        System.out.println(d0);  // 123.456

        // НЕЯВНАЯ ТИПИЗАЦИЯ
        var a = 123;
        System.out.println(a);  // 123
        var d = 123.456;
        System.out.println(d);  // 123.456
        System.out.println(getType(a));  // Integer
        System.out.println(getType(d));  // Double
        d = 1022;
        System.out.println(d);  // 1022
        //d = "mistake";
        //error: incompatible types:
        //String cannot be converted to double

        // КЛАССЫ ОБЕРТКИ
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648

        // МАССИВЫ ОДНОМЕРНЫЕ
        int[] arr = new int[10];
        System.out.println(arr.length); // 10
        arr = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(arr.length); // 5

        // МАССИВЫ МНОГОМЕРНЫЕ
        int[] arr2[] = new int[3][5];
        for (int[] line : arr2) {
            for (int item : line) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }

        // МАССИВЫ МНОГОМЕРНЫЕ
        int[][] arr3 = new int[3][5];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.printf("%d ", arr3[i][j]);
            }
            System.out.println();
        }

        // ПРЕОБРАЗОВАНИЯ
        int i = 123; double d2 = i;
        System.out.println(i);  // 123
        System.out.println(d2);  // 123.0
        d2 = 3.1415; i = (int)d2;
        System.out.println(d2);  // 3.1415
        System.out.println(i);  // 3
        d2 = 3.9415; i = (int)d2;
        System.out.println(d2);  // 3.9415
        System.out.println(i);  // 3
        byte b = Byte.parseByte("123");
        System.out.println(b);  // 123
        // b = Byte.parseByte("1234");
        // System.out.println(b);  // NumberFormatException: Value out of range

        // ИЗУЧАЕМ ковариантность и контравариантность
        int[] a1 = new int[10];
        // double[] d1 = a1; ТАК НЕЛЬЗЯ !!!

        // Получение данных из терминала - СТРОКИ
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ", "cp866"); // "cp866" - ПОДДЕРЖКА РУССКОГО ВВОДА
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        System.out.println(name);
        // iScanner.close();

        // Получение данных из терминала - ПРИМИТИВЫ
        System.out.printf("int a: ");
        int x = iScanner.nextInt();
        System.out.printf("double a: ");
        double y = iScanner.nextDouble();
        System.out.printf("%d + %f = %f \n", x, y, x + y);
        // iScanner.close();

        // Проверка на соответствие получаемого типа
        System.out.printf("int a: ");
        boolean flag = iScanner.hasNextInt();
        System.out.println(flag);
        if (flag) {
            int i2 = iScanner.nextInt();
            System.out.println(i2);  
        } else {
            double i2 = iScanner.nextDouble();
            System.out.println(i2);  
        }

        iScanner.close();

        // ФОРМАТИРОВАННЫЙ ВЫВОД
        int a3 = 1, b3 = 2;
        int c = a3 + b3;
        String res = a3 + " + " + b3 + " = " + c;
        System.out.println(res);

        int a4 = 1, b4 = 2;
        int c2 = a4 + b4;
        String res2 = String.format("%d + %d = %d \n", a4, b4, c2);
        System.out.printf("%d + %d = %d \n", a4, b4, c2);
        System.out.println(res2);

        // ВИДЫ СПЕЦИФИКАТОРОВ
        // %d: целочисленных значений
        // %x: для вывода шестнадцатеричных чисел
        // %f: для вывода чисел с плавающей точкой
        // %e: для вывода чисел в экспоненциальной форме, 
        // например, 3.1415e+01
        // %c: для вывода одиночного символа
        // %s: для вывода строковых значений

        System.out.printf("%f\n", pi);    // 3,141500
        System.out.printf("%.2f\n", pi);  // 3,14
        System.out.printf("%.3f\n", pi);  // 3,141
        System.out.printf("%e\n", pi);    // 3,141500e+00
        System.out.printf("%.2e\n", pi);  // 3,14e+00
        System.out.printf("%.3e\n", pi);  // 3,141e+00

        // Управляющие конструкции: условный оператор
        int a5 = 1;
        int b5 = 2;
        int c5;
        if (a5 > b5) {
            c5 = a5;
        } else {
            c5 = b5;
        }
        System.out.println(c5);

        // или
        c5 = 0;
        if (a5 > c5) c5 = a5;
        if (b5 > a5) c5 = b5;
        System.out.println(c5);

        // ИЛИ
        int min = a5 < b5 ? a5 : b5;
        System.out.println(min);


    }

    // ФУНКЦИИ
    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}