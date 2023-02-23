// 2. Пусть дан произвольный список целых чисел, удалить из него четные числа
package main.Java.HomeWork3;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int value = r.nextInt(1, 10);
            list.add(value);
        }
        System.out.println(list);

        list.removeIf(value -> value % 2 == 0);
        System.out.println(list);
    }
}