// Вычислить n-ое треугольного число(сумма чисел от 1 до n),
// а также n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class DZ1 {
    public static void main(String[] args) {
        System.out.print("Введите число n: ");
        Scanner iScanner = new Scanner(System.in);
        int num = iScanner.nextInt();
        iScanner.close();

        // 1 часть - треугольные числа (сумма чисел от 1 до n),
        int summ = 0;
        for (int i = 0; i <= num; i++)
            summ += i;
        System.out.printf("Сумма чисел от 1 до %d: %d\n", num, summ);

        // 12 часть - n! (произведение чисел от 1 до n)
        long fact = 1;
        for (int i = 1; i <= num; i++)
            fact *= i;
        System.out.printf("Факториал числа %d!: %d\n", num, fact);
    }
}