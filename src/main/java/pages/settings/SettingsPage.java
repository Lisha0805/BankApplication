package pages.settings;

import pages.MenuPages;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.*;
import java.util.Scanner;

public class SettingsPage implements MenuPages {
    private MainPage mainPage = new MainPage();
    private Scanner scannerPoint = new Scanner(System.in);
    private Scanner scannerData = new Scanner(System.in);
    private PersonalData pd;

    public SettingsPage() throws IOException {
        pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
    }

    @Override
    public void display() throws IOException {
        String menu = """
                Settings
                1. View Data
                2. Change Data
                3. Back""";

        int point = 0;
        do {
            System.out.println(menu);
            point = scannerPoint.nextInt();
            switch (point) {
                case 1 -> printPersonalData(pd);
                case 2 -> changePersonalDate();
                case 3 -> mainPage.display();
                default -> System.out.println("No such item!");

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

            System.out.println(menuToChange);
            int point = scannerPoint.nextInt();

            System.out.println("Enter new value");
            switch (point) {
                case 1 -> pd.setLastName(scannerData.nextLine());
                case 2 -> pd.setPatronymic(scannerData.nextLine());
                case 3 -> pd.setSourceOfIncome(scannerData.nextLine());
                case 4 -> display();
                default -> System.out.println("No such item!");
            }
            ResourceConverter.objectToJson("personalData.json", pd);
            display();
        }

        public void printPersonalData (PersonalData personalData) throws IOException {
            System.out.println("Personal Data: " +
                    "\n" + " Firstname: " + personalData.getFirstName() +
                    "\n" + " Lastname: " + personalData.getLastName() +
                    "\n" + " Patronymic: " + personalData.getPatronymic() +
                    "\n" + " Date of Birth: " + personalData.getDateOfBirth() +
                    "\n" + " Sex: " + personalData.getSex() +
                    "\n" + " Source of income: " + personalData.getSourceOfIncome() +
                    "\n" + " Income per year: " + personalData.getIncomePerYear() +
                    "\n" + " Credit rating: " + personalData.getCreditRating());
            display();
        }
    }