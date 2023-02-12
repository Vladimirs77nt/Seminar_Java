// Дан массив двоичных чисел, например [1,1,0,1,1,1],
// вывести максимальное количество подряд идущих 1.

public class Task02double{
    public static void main(String[] args) {
        int[] array = new int []{1,1,0,1,1,1,3,3,3,3,3,3,3,4,4,4,4,4,3,3,3,2,2,2};
        int count = 1;
        int maxCount = 1;
        System.out.print(array[0]);
        // var item = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]){
                System.out.print(array[i]);
                count++;
            }
            else{
                if (count > maxCount) maxCount = count;
                count = 1;
                System.out.println();
                System.out.print(array[i]);
            }
        }
        System.out.println();
        System.out.printf("Результат: %d", maxCount);
    }
}