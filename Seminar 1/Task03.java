import java.util.Arrays;

// Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
// а остальные - равны ему.

public class Task03 {
    public static void main(String[] args) {
        int[] array = new int []{3,2,2,1,1,3,3,5,5,6,3};
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array));

        int[] array2 = new int [array.length];
        int val = 3;
        int i = 0;
        int index = 0;
        int index_end = array.length-1;
        while (index<=index_end) {
            if (array[i] == val){
                array2[index_end] = array[i];
                index_end--;
                i++;
            } else {
                array2[index] = array[i];
                index++;
                i++;
            }
        }
        System.out.print("Новый массив: ");
        System.out.println(Arrays.toString(array2));
    }
}