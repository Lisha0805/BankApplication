import java.util.Scanner;

public class Accounts {

    public BankApp bankApp = new BankApp();

    public void menuAccounts() {
        int point;

        do {
            System.out.println("Счета. Выберете действие");
            System.out.println("1. добавить новый счет");
            System.out.println("2. просмотреть доступные счета");
            System.out.println("3. просмотреть выпсику по счету");
            System.out.println("4. назад");

            Scanner scanner = new Scanner(System.in);
            point = scanner.nextInt();

            switch (point) {
                case 1:
                    ////////////////////
                    break;
                case 2:
                    ////////////////////////
                    break;
                case 3:
                    /////////////////////////
                    break;
                case 4:
                    bankApp.mainMenu();
                    break;
                default:
                    System.out.println("Нет такого пункта!");
                    break;
            }
        }while (point > 5);
    }
}
