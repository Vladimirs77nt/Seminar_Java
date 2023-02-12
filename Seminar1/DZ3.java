import java.util.Scanner;

// Задача 3. Реализовать простой калькулятор
// Введите число 2 / Введите операцию: 1 + 2 - 3 * 4
// Введите число 2 2 + 2 = 4

public class DZ3 {
    public static void main(String[] args) {
        System.out.println("Очень простой калькулятор! Работа только с целыми числами");
        System.out.println("Допустимые операции только ( +, -, *, / ) и все...");
        System.out.print("Введите первое число: ");
        Scanner iScanner = new Scanner(System.in);
        int num1 = iScanner.nextInt();
        System.out.print("Введите операцию ( +, -, *, / ): ");
        String operation = iScanner.next();
        System.out.print("Введите второе число: ");
        int num2 = iScanner.nextInt();
        iScanner.close();
        int res = 0;
        switch (operation) {
            case ("+"):
                res = num1 + num2;
                System.out.print("Операция сложения:  ");
                break;
            case ("-"):
                res = num1 - num2;
                System.out.print("Операция вычитания:  ");
                break;
            case ("*"):
                res = num1 * num2;
                System.out.print("Операция умножения:  ");
                break;
            case ("/"):
                res = num1 / num2;
                System.out.print("Операция деления:  ");
                break;
            default:
                System.out.println("Введена неверная операция. Перезапустите программу!");
                break;
        }
        System.out.printf("%d %s %d = %d", num1, operation, num2, res);
    }
}
