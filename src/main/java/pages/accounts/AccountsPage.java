package pages.accounts;

import pages.MenuPages;

import java.util.Scanner;

public class AccountsPage implements MenuPages {

    @Override
    public void display(){
        int point;
        String menu = """
                Accounts
                1. Add new account
                2. View available accounts
                3. View account statement\s
                4. Back""";
        do {
            System.out.println(menu);
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
                    //BankApp.mainMenu();
                    break;
                default:
                    System.out.println("No such item!");
                    break;
            }
        } while (point > 5);
    }
}
