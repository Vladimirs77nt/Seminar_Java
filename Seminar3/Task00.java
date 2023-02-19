/* Даны следующие строки, cравнить их с помощью == и метода equals() класса Object
String s1 = "hello";
String s2 = "hello";
String s3 = s1;
String s4 = "h" + "e" + "l" + "l" + "o";
String s5 = new String("hello");
String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'}); */

package Seminar3;

public class Task00 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        if (s1 == s6) System.out.println("равны как ссылки");
        else System.out.println("НЕ равны как ссылки");
        if (s1.equals(s6)) System.out.println("равны как значения");
        else System.out.println("НЕ равны как значения");
    }
}