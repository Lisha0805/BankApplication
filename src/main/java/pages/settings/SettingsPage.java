package pages.settings;

import pages.MenuPages;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.*;
import java.util.Scanner;

public class SettingsPage implements MenuPages {
    private MainPage mainPage = new MainPage();
    private Scanner scanner = new Scanner(System.in);
    private PersonalData pd;

    public SettingsPage() throws IOException {
        pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
    }

    @Override
    public void display() throws IOException {
        String menu = "Settings" +
                "\n1. View Data" +
                "\n2. Change Data" +
                "\n3. Back";

        int point = 0;
        do {
            System.out.println(menu);
            point = scanner.nextInt();
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
            int point;

            String menuToChange = "Select item to change: " +
                    "\n1. Lastname: " + pd.getLastName() +
                    "\n2. Patronymic: " + pd.getPatronymic() +
                    "\n3. Source of income: " + pd.getSourceOfIncome() +
                    "\n4. Income per year: " + pd.getIncomePerYear() +
                    "\n5. Back";
            System.out.println(menuToChange);
            point = scanner.nextInt();
            String value; int value1;
            if (point == 1) {System.out.println("Enter new value"); value = scanner.nextLine(); pd.setLastName(value);}
            else if (point == 2){System.out.println("Enter new value"); value = scanner.nextLine(); pd.setPatronymic(value);}
            else if (point == 3) {System.out.println("Enter new value"); value = scanner.nextLine();pd.setSourceOfIncome(value);}
            else if (point == 4){System.out.println("Enter new value"); value1 = scanner.nextInt(); pd.setIncomePerYear(value1);}
            else if (point == 5) display();
            else System.out.println("No such item!");

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