package main.Java.HomeWork4;

import com.owlike.genson.Genson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Export_Import {
    /**
     * Экспорт записей книги в формат JSON в файл phonebook.json
     * @param phoneBook
     */
    static void pBexport(PhoneBook phoneBook) {
        String json = phoneBook.get_json();
        File jsonFile = new File("phonebook.json");
        try (FileWriter jsonFileWriter = new FileWriter(jsonFile)) {
            jsonFileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Импорт данных из файла JSON phonebook.json
     *
     * @param phoneBook
     */
    static void pBimport(PhoneBook phoneBook) {
        class Phones extends HashMap {
        }
        String jsonStringForMap = null;
        try {
            jsonStringForMap = new String(Files.readAllBytes(Paths.get("phonebook.json")));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла phonebook.json");
            e.printStackTrace();
            return;
        }

        Genson genson = new Genson();
        Map<String, Phones> jsonRead = genson.deserialize(jsonStringForMap, Map.class);
        phoneBook.reset();

        List<String> phNumbers;
        for (String login : jsonRead.keySet()) {
            phNumbers = (List<String>) ((Map) jsonRead.get(login)).get("phone");
            for (String phNumber : phNumbers) {
                phoneBook.add(login, phNumber);
            }
        }
    }
}
