/** Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл. */

package Seminar2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DZ2 {
    static Logger logger = Logger.getLogger(DZ2.class.getName());
    
    public static void main(String[] args) throws SecurityException, IOException{
        // инициализация логирования
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.setUseParentHandlers(false);

        // массив чисел
        int[] array = {34, 76,24,75,24,890,34,654,24,2,64,4,86,46,57};
        System.out.println("Исходный массив чисел: " + Arrays.toString(array));
        // отсортированный массив чисел
        int[] newArray = SortBubblle(array);
        System.out.println("Отсортированный массив чисел: " + Arrays.toString(newArray));
    }

    public static int[] SortBubblle(int[] array){
        logger.info(String.format("\n>>> Обрабатываемый массив чисел: %s\n>>> Запуск сортировки...\n", Arrays.toString(array)));
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++){
                if (array[j]>array[j+1]){
                    // logger.info(String.format(">>> обработка! элемент %d [%d] больше элемента %d [%d] -> меняем местами!...\n", j, array[j], j+1, array[j+1]));
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            };
            logger.info(String.format(">>> %d-й проход выполнен! результат сортировки:\n", i) + Arrays.toString(array) + "\n");
        }
        logger.info(String.format(">>>\n Сортировка выполнена!\n>>> Возвращаемый массив чисел: %s\n", Arrays.toString(array)));
        return array;
    }
}