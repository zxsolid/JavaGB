// 1. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
package main.Java.HomeWork3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int value = r.nextInt(1, 10);
            list.add(value);
        }
        System.out.println(list);

        double result = 0;
        int count = 0;
        for (int elem : list) {
            result += elem;
            count++;
        }
        result /= count;

        System.out.println("min: " + Collections.min(list));
        System.out.println("max: " + Collections.max(list));
        System.out.println("average: " + result);
    }
}