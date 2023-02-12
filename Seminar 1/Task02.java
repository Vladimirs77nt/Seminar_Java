// Дан массив двоичных чисел, например [1,1,0,1,1,1],
// вывести максимальное количество подряд идущих 1.

public class Task02 {
    public static void main(String[] args) {
        int[] array = new int []{1,1,1,0,1,1,1,1,1};
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) count++;
            else
                if (count > maxCount){
                    maxCount = count;
                    count = 0;
                }
        }
        if (count > maxCount) maxCount = count;
        System.out.printf("Результат: %d", maxCount);
    }
}