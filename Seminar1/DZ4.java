import java.util.ArrayList;
import java.util.Scanner;

// Задача 4. Задано уравнение вида q + w = e, q, w, e >= 0
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// * уточнение!!! числа могут быть двухзначными и не более...

public class DZ4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1 часть - ввод данных
        System.out.println(
                "Введите уравнение в формате (AB + CD = FE), где вместо букв могут стоять или цифры (от 0 до 9) или знак ?");
        System.out.println("Например: 2? + ?5 = 69  -> пробелы обязательны!");
        Scanner iScanner = new Scanner(System.in);
        String numStr = iScanner.nextLine();
        iScanner.close();

        // 2 часть - расшифровка того, что ввели
        String[] numStrArr = numStr.split(" ");
        boolean x11 = false, x12 = false, x21 = false, x22 = false, x31 = false, x32 = false;
        // x1...x6 - это "флажки" если True - то данная цифра определена
        int x11num = 0, x12num = 0, x21num = 0, x22num = 0, x31num = 0, x32num = 0;
        // x11...x32 - это начальные разряды чисел (пока все нули)
        String num1Str = numStrArr[0]; // первое число в строке
        String num2Str = numStrArr[2]; // второе число в строке
        String num3Str = numStrArr[4]; // третье число в строке

        // 3 часть - инициализация цифр-разрядов в числах, если они есть
        // первое число
        if (Character.isDigit(num1Str.charAt(0))) {
            x11num = Integer.parseInt(num1Str.charAt(0) + "");
            x11 = true;
        }
        if (num1Str.length() == 2) {
            if (Character.isDigit(num1Str.charAt(1))) {
                x12num = Integer.parseInt(num1Str.charAt(1) + "");
                x12 = true;
            }
        }
        // второе число
        if (Character.isDigit(num2Str.charAt(0))) {
            x21num = Integer.parseInt(num2Str.charAt(0) + "");
            x21 = true;
        }
        if (num2Str.length() == 2) {
            if (Character.isDigit(num2Str.charAt(1))) {
                x22num = Integer.parseInt(num2Str.charAt(1) + "");
                x22 = true;
            }
        }
        // третье число
        if (Character.isDigit(num3Str.charAt(0))) {
            x31num = Integer.parseInt(num3Str.charAt(0) + "");
            x31 = true;
        }
        if (num3Str.length() == 2) {
            if (Character.isDigit(num3Str.charAt(1))) {
                x32num = Integer.parseInt(num3Str.charAt(1) + "");
                x32 = true;
            }
        }

        // 4 часть - перебор всех вариантов цифр-разрядов
        System.out.println("Результат:");
        ArrayList<String> result = new ArrayList<String>();
        String str0 = "";
        int num1, num2, num3;
        for (int i11 = 0; i11 < 10; i11++) {
            if (!x11)
                x11num = i11;
            for (int i12 = 0; i12 < 10; i12++) {
                if (!x12)
                    x12num = i12;
                for (int i21 = 0; i21 < 10; i21++) {
                    if (!x21)
                        x21num = i21;
                    for (int i22 = 0; i22 < 10; i22++) {
                        if (!x22)
                            x22num = i22;
                        for (int i31 = 0; i31 < 10; i31++) {
                            if (!x31)
                                x31num = i31;
                            for (int i32 = 0; i32 < 10; i32++) {
                                if (!x32)
                                    x32num = i32;
                                num1 = x11num * 10 + x12num;
                                num2 = x21num * 10 + x22num;
                                num3 = x31num * 10 + x32num;
                                if (num1 + num2 == num3) {
                                    str0 = num1 + " + " + num2 + " = " + num3;
                                    if (!result.contains(str0)) {
                                        result.add(str0);
                                        System.out.println(str0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // если список результата пустой - то решения нет...
        if (result.isEmpty())
            System.out.println("Решения нет...");
    }
}