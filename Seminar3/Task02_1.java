/* Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке. */

package Seminar3;

import java.util.ArrayList;

public class Task02_1 {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>();
        planets.add("Земля");     // 4
        planets.add("Меркурий");  // 1
        planets.add("Венера");    // 1
        planets.add("Земля");     // 1
        planets.add("Марс");      // 1
        planets.add("Юпитер");    // 1
        planets.add("Сатурн");    // 1
        planets.add("Нептун");    // 1
        planets.add("Земля");     // 2
        planets.add("Марс");      // 2
        planets.add("Юпитер");    // 2
        planets.add("Земля");     // 3

        ArrayList<String> planets2 = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        int index = 0;
        for (String planet : planets) {
            index = planets2.indexOf(planet);
            if (index>=0) counts.set(index, counts.get(index)+1);
            else {
                planets2.add(planet);
                counts.add(1);
            }
        }
        ShowPlanets(planets2, counts);
    }

    private static void ShowPlanets(ArrayList<String> planets, ArrayList<Integer> counts){
        for (int i = 0; i < planets.size(); i++) {
            System.out.println(planets.get(i) + " - " + counts.get(i));
        }
    }
    
}