package main.Java.HomeWork2;

public class Main {
    public static void main(String[] args) {
        String testString= "     Добрый    день Как  дела     Все хорошо  ";
        System.out.println(testString);
        System.out.println(normaliser(testString));
    }

    public static String normaliser(String incomingString) {
        StringBuilder workString = new StringBuilder().append(incomingString);
        int i = 1;
        while (i < workString.length()) {
            if (workString.charAt(0)==' '){ //убираем префиксные пробелы
                workString.deleteCharAt(0);
                continue;
            }
            if (i == workString.length() - 1) {
                //последний символ
                if (workString.charAt(i) == ' ') {//убираем пробелы с конца
                    workString.deleteCharAt(i);
                    i--;
                    continue;
                } else if (workString.charAt(i) != '.') { // ставим точку в конце, если ее нет
                    workString.append('.');
                    break;
                }
            }
            if (workString.charAt(i) == ' ' && workString.charAt(i - 1) == ' ') { // убираем двойные пробелы
                workString.deleteCharAt(i);
                i--;
                continue;
            }
            if (workString.charAt(i) == ' ' && Character.isUpperCase(workString.charAt(i + 1)) && Character.isLowerCase(workString.charAt(i - 1))) {
                workString.insert(i, '.'); //ставим точку в конце предложения
                continue;
            }
            i++;
        }
        return workString.toString();
    }
}
/* вывод консоли
     Добрый    день Как  дела     Все хорошо
Добрый день. Как дела. Все хорошо.
 */