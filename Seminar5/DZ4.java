/* Задача 4.
 На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. */

package Seminar5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DZ4 {
    public static void main(String[] args) {
        int[][] table = new int [8][8];
        // в цикле заполняем шахматную доску нулями (пустые поля)
        for (int i = 0; i < 64; i++) {
            int y = i/8;
            int x = i - y*8;
            table[x][y] = 0;
            System.out.println(x + " " + y);
        }
        printTable(table);

        double x = Math.random()*8;
        double y = Math.random()*8;
        table[(int)x][(int)y] = 1; // ставим первого ферзя

        for (int i = 0; i < 8; i++) {
            do {
                double j = Math.random()*8;
        }
    }

    private static void printTable(int[][] arr) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (arr[x][y] == 0) System.out.print("   ");
                else System.out.print("V ");
            }
            System.out.println();
            
        }
    }
}