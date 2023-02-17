/** Задание 1. Дано четное число N (>0) и символы c1 и c2. 
Написать метод, который вернет строку длины N, которая состоит из
чередующихся символов c1 и c2, начиная с c1. */

package Seminar2;

public class Task01 {
    public static void main(String[] args) {
        int n = 10;
        char c1 = 'F';
        char c2 = 'V';
        System.out.println(createAlteraitingString (c1,c2,n));
    }

    private static String createAlteraitingString (char c1, char c2, int n){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) result.append(c1);
            else result.append(c2);
        }
        return result.toString();
    }
}