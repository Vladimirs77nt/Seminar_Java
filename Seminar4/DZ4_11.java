/* Задача №4 (ДЗ)
Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения. */

package Seminar4;

import java.lang.Thread.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class DZ4_11 {
    public static void main(String[] args) {
        String inFormula = "x ^ y / ( 544 * z1 + ( 6 - 45 * ( 10 / 2) -8)) +10";
        System.out.println("математическая запись:\n" + inFormula);

        // вызов функции построения списка элементов математической записи
        ArrayList<String> formulaListOut = formulaList(inFormula);
        System.out.println("результат разбивки на элементы:\n" + formulaListOut);

        // вызов функции поиска индексов открывающих и закрывающих скобок
        LinkedList <String> indexList = priorityIndexList(formulaListOut);
        System.out.println("обнаруженные диапазоны скобок: " + indexList + "\n");

        for (String string : indexList) {
            System.out.println("диапазон: " + string);
            String[] index = string.split("-");
            int indexStart = Integer.parseInt(index[0]);
            int indexEnd = Integer.parseInt(index[1]);
            String result = formula(formulaListOut, indexStart, indexEnd);
        }

    }

    // функция "умной" разбивки математической записи на элементы
    private static ArrayList<String> formulaList(String inFormula) {
        String[] formulaList = inFormula.split("");
        ArrayList<String> formulaListOut = new ArrayList<>();
        String item = "";
        for (int i = 0; i < formulaList.length; i++) {
            if (formulaList[i].contains(" ")) {
                if (item != "") formulaListOut.add(item);
                item = "";
                continue;
            } else if (formulaList[i].contains("(") | 
                formulaList[i].contains(")") | 
                formulaList[i].contains("+") | 
                formulaList[i].contains("-") | 
                formulaList[i].contains("*") | 
                formulaList[i].contains("/") | 
                formulaList[i].contains("^")) {
                if (item != "") formulaListOut.add(item);
                formulaListOut.add(formulaList[i]);
                item = "";
                continue;
            } else {
                item = item + formulaList[i];
            }
        }
        if (item != "") {
            formulaListOut.add(item);
        }
        return formulaListOut;
    }

    // функция поиска диапазонов (индексов) открывающих и закрывающих скобок
    private static LinkedList<String> priorityIndexList(ArrayList<String> list) {
        LinkedList<String> iList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("(")) {
                iList.addLast(i+"-");
            }
            if (list.get(i).contains(")")) {
                String index = iList.removeLast();
                iList.addFirst(index + i);
            }
        }
        int size = iList.size();
        for (int i = 0; i < size; i++) {
            iList.add(iList.remove(size-i-1));
        }
        return iList;
    }

    // функция построения математической записи
    private static String formula(ArrayList<String> formulaList, int indexStart, int indexEnd) {
        ArrayList<String> currentFormulaList = new ArrayList<>();
        for (int i = indexStart+1; i < indexEnd; i++) {
            currentFormulaList.add(formulaList.get(i));
        }
        System.out.println(currentFormulaList);
        return "привет";
    }

    // функция построения математической записи ТРИ элемента
    private static String formula3(ArrayList<String> currentFormulaList) {
        String[] currentFormulaList = new String[indexEnd-indexStart-1];
        System.out.println("кусок: " + Arrays.toString(currentFormulaList));
        String item;
        for (int i = indexStart+1; i < indexEnd; i++) {
            item = formulaList.get(i);
            System.out.println("i=" + i + " item = " + item);
            if (item.contains("(") & item.length()>0) {
                item = item.substring(1, item.length()-1);
            }
            if (item.contains(")") & item.length()>0) {
                item = item.substring(1, item.length()-1);
            }
            currentFormulaList[i-indexStart-1] = item;
        }
        return "привет";
}

}