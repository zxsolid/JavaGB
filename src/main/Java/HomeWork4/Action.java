package main.Java.HomeWork4;

import java.util.Scanner;

public class Action {
    static Scanner scan = new Scanner(System.in);

    public static String input() {

        String in = scan.next().toString();
        return in;
    }

    public static void add_number(PhoneBook phoneBook) {
        System.out.println("Добавление записи");
        System.out.print("Введите логин:");
        String login = input();
        System.out.print("Введите номер телефона:");
        String phone = input();
        phoneBook.add(login, phone);
    }

    public static void find_login(PhoneBook phoneBook) {
        System.out.println("Поиск логина по номеру телефона");
        System.out.print("Введите номер:");
        String phone = input();
        System.out.println(phoneBook.find_login(phone));
    }

    public static void find_phones(PhoneBook phoneBook) {
        System.out.println("Поиск номеров по логину");
        System.out.print("Введите логин:");
        String login = input();
        System.out.println(phoneBook.find_phone(login));
    }

    public static void edit(PhoneBook phoneBook) {
        System.out.println("Изменение записи");
        System.out.print("Введите логин:");
        String login = input();
        System.out.println(phoneBook.find_phone(login));
        System.out.print("Введите старый номер телефона:");
        String oldphone = input();
        System.out.print("Введите новый номер телефона:");
        String newphone = input();
        phoneBook.replace_phone_from_login(login, newphone, oldphone);
        System.out.println(phoneBook.find_phone(login));
    }

    /**
     * @param phoneBook
     */
    public static void remove_numbers(PhoneBook phoneBook) {
        System.out.println("Удаление номера телефона");
        System.out.print("Введите номер телефона:");
        String phone = input();
        phoneBook.remove_phone(phone);
    }

    /**
     * Удаление записи телефонной книги по логину
     * @param phoneBook
     */
    public static void remove_login(PhoneBook phoneBook) {
        System.out.println("Удаление записи по логину");
        System.out.print("Введите логин:");
        String login = input();
        phoneBook.remove_login(login);
    }

    /**
     * Вложенное меню Импорта/Экспорта
     * @param phoneBook
     */
    public static void import_export(PhoneBook phoneBook) {
        Menu menuExportImport = new Menu();
        menuExportImport.add("1", "Экспорт в JSON");
        menuExportImport.add("2", "Импорт из JSON");
        menuExportImport.add("Q", "Выход");
        while (true) {
            switch (menuExportImport.run()) {
                case "1":
                    Export_Import.pBexport(phoneBook);
                    break;
                case "2":
                    Export_Import.pBimport(phoneBook);
                    break;
                case "Q":
                    return;
            }
            System.out.println();
        }
    }

    /**
     * Вывод всех записей телефонной книги к консоль
     * @param phoneBook
     */
    public static void view_all(PhoneBook phoneBook) {
        System.out.println("Все записи: ");
        phoneBook.print();
        System.out.println();
    }
}