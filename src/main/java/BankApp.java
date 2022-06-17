import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BankApp {

    public static Scanner scanner = new Scanner(System.in);
    public static Accounts accounts = new Accounts();
    public static Setting setting = new Setting();
    public static Credit credit = new Credit();

    public static void main(String[] args) throws IOException {

        System.out.println("Введите, пожалуйста, логин и пароль:");

        //вводим данные
        String log = scanner.nextLine();
        String pass = scanner.nextLine();
        Map<String, String> copy = new HashMap<>();
        copy.put(log, pass);

        //считываем с файла
        YamlReader reader = new YamlReader();
        Map<String, String> config = reader.read("src/main/resources/authorization.yaml");
        System.out.println(config);

        //проверяем
        for(Map.Entry<String,String>pair1 : config.entrySet()) {
            for (Map.Entry<String, String> pair2 : copy.entrySet()) {
                if (pair1.getValue().equals(pair2.getValue())) {
                    System.out.println("----------");
                    mainMenu();
                }
            }
        }
    }

    public static void mainMenu(){
        int m;

        do {
            System.out.println("Главное меню:");
            System.out.println("1. Счета");
            System.out.println("2. Настройки");
            System.out.println("3. Займы");

            m = scanner.nextInt();

            switch (m) {
                case 1:
                    accounts.menuAccounts();
                    break;

                case 2:
                    System.out.println("2");
                    break;

                case 3:
                    System.out.println("3");
                    break;
                default:
                    System.out.println("Нет такого пункта!");
                    break;
            }
        } while (m > 3);
    }


    public static class YamlReader {
        public Map<String, String> read(String path) throws IOException {
            InputStream input = Files.newInputStream(Paths.get(path));
            Yaml yaml = new Yaml();
            return (Map<String, String>) yaml.load(input);
        }


    }

}
