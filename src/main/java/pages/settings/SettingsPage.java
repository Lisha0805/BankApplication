package pages.settings;

import org.apache.log4j.Logger;
import pages.MenuPages;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.*;
import java.util.Scanner;

public class SettingsPage implements MenuPages {
    Logger loggerToFile = Logger.getLogger("LOG2");
    Logger loggerToConsole = Logger.getLogger("LOG1");
    private MainPage mainPage = new MainPage();
    private Scanner scannerPoint = new Scanner(System.in);
    private Scanner scannerData = new Scanner(System.in);
    private PersonalData pd;

    @Override
    public void display() throws IOException {
        PersonalData pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);

        int point = 0;
        String menu = """
                Settings
                1. View Data
                2. Change Data
                3. Back""";
        do {
            loggerToConsole.info(menu);
            loggerToFile.info(menu);
            point = scannerPoint.nextInt();
            loggerToFile.info(point);
            switch (point) {
                case 1 -> printPersonalData(pd);
                case 2 -> changePersonalDate();
                case 3 -> mainPage.display();
                default -> {
                    loggerToConsole.warn("No such item!");
                    loggerToFile.warn("No such item!");
                }
            }
        }while (point > 3);
    }

        public void changePersonalDate () throws IOException {
            PersonalData pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
            String menuToChange = "Select item to change: " +
                    "\n1. Lastname: " + pd.getLastName() +
                    "\n2. Patronymic: " + pd.getPatronymic() +
                    "\n3. Source of income: " + pd.getSourceOfIncome() +
                    "\n4. Back";

            loggerToConsole.info(menuToChange);
            loggerToFile.info(menuToChange);
            int point = scannerPoint.nextInt();
            loggerToFile.info(point);

            loggerToConsole.info("Enter new value");
            loggerToFile.info("Enter new value");
            switch (point) {
                case 1 -> pd.setLastName(scannerData.nextLine());
                case 2 -> pd.setPatronymic(scannerData.nextLine());
                case 3 -> pd.setSourceOfIncome(scannerData.nextLine());
                case 4 -> display();
                default -> {
                    loggerToConsole.warn("No such item!");
                    loggerToFile.warn("No such item!");
                }
            }
            ResourceConverter.objectToJson("personalData.json", pd);
            display();
        }

        public void printPersonalData (PersonalData personalData) throws IOException {
            String printPersonalData = "Personal Data: " +
                    "\n" + " Firstname: " + personalData.getFirstName() +
                    "\n" + " Lastname: " + personalData.getLastName() +
                    "\n" + " Patronymic: " + personalData.getPatronymic() +
                    "\n" + " Date of Birth: " + personalData.getDateOfBirth() +
                    "\n" + " Sex: " + personalData.getSex() +
                    "\n" + " Source of income: " + personalData.getSourceOfIncome() +
                    "\n" + " Income per year: " + personalData.getIncomePerYear() +
                    "\n" + " Credit rating: " + personalData.getCreditRating();
            loggerToConsole.info(printPersonalData);
            loggerToFile.info(printPersonalData);
            display();
        }
    }