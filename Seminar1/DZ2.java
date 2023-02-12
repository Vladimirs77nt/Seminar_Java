// Задача 2. Вывести все простые числа от 1 до 1000

public class DZ2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int num = 1000;
        System.out.printf("Список простых чисел до %d:\n", num);
        boolean simple = false;
        for (int i = 2; i <= num; i++) {
            simple = true;
            for (int j = 2; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple)
                System.out.printf("%d ", i);
        }
    }
}