package main.Java.HomeWork4;
import static main.Java.HomeWork4.Export_Import.pBimport;
public class MainApp {
    public static PhoneBook phoneBook;

    public static void main(String[] args) {
        phoneBook = new PhoneBook();
        pBimport(phoneBook); // если есть файл phonеbook.json то подгрузим из него данные
        mainMenuLoop();
    }

    private static void mainMenuLoop() {
        // главное меню
        Menu menu = new Menu();
        menu.add("1", "Добавить запись");
        menu.add("2", "Вывод всех записей");
        menu.add("3", "Поиск логина по номеру");
        menu.add("4", "Поиск номера(ов) по логину");
        menu.add("5", "Изменить запись");
        menu.add("6", "Удаление номера");
        menu.add("7", "Удаление записи по логину");
        menu.add("8", "Импорт/Экспорт");
        menu.add("Q", "Выход");
        while (true) {
            switch (menu.run()) {
                case "1":
                    Action.add_number(phoneBook);
                    break;
                case "2":
                    Action.view_all(phoneBook);
                    break;
                case "3":
                    Action.find_login(phoneBook);
                    break;
                case "4":
                    Action.find_phones(phoneBook);
                    break;
                case "5":
                    Action.edit(phoneBook);
                    break;
                case "6":
                    Action.remove_numbers(phoneBook);
                    break;
                case "7":
                    Action.remove_login(phoneBook);
                    break;
                case "8":
                    Action.import_export(phoneBook);
                    break;
                case "Q":
                    System.out.println("Удачи!");
                    return;
            }
            System.out.println();
        }
    }
}