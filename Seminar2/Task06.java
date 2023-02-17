/* Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
1 Расширение файла: txt
2 Расширение файла: pdf
3 Расширение файла:
4 Расширение файла: jpg */

package Seminar2;
import java.io.File;

public class Task06 {
    public static void main(String[] args) {
        File folder = new File(".");
        System.out.println("папка = " + folder.getAbsolutePath());
        showExtencion(folder.list());
    }

    public static void showExtencion(String[] filenames) {
        for (int i = 0; i < filenames.length; i++) {
            // System.out.println(i + " = " + filenames[i]);
            int pos = filenames[i].lastIndexOf(".");
            if (pos >= 0)
                System.out.println(filenames[i].substring(pos + 1));
        }
    }
}