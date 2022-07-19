package pages.accounts;

import org.apache.log4j.Logger;
import pages.MenuPages;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;

public class AccountsPage implements MenuPages {
    private MainPage mainPage = new MainPage();
    Logger log = Logger.getLogger("APP1");
    AccountList accountList = (AccountList) ResourceConverter.yamlToObject("accounts.yaml", AccountList.class);
    Scanner scanner = new Scanner(System.in);

    public AccountsPage() throws IOException { }

    @Override
    public void display() throws IOException {
        int point;
        String menu = """
                Accounts
                1. Add new account
                2. Delete account
                3. View accounts
                4.
                5. Back""";
        do {
            log.info(menu);
            point = scanner.nextInt();
            log.info(point);

            switch (point) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    ////////////////////////
                    break;
                case 3:
                    printAccountsInfo();
                    break;
                case 4:
                    //BankApp.mainMenu();
                    break;
                case 5:
                    mainPage.display();
                    break;
                default:
                    log.warn("No such item!");
                    break;
            }
        } while (point > 5);
    }

    public void addAccount() throws IOException {
        Account accToAdd = new Account();
        enterAccountNumber(accToAdd);
        enterAccountCurrency(accToAdd);
        accountList.list.add(accToAdd);
        log.info("Account added");
        display();
    }

    public void enterAccountNumber(Account acc){
        log.info("Enter account number");
        long numberAccount = scanner.nextLong();
        acc.setNumber(numberAccount);
    }

    public void enterAccountCurrency(Account acc){
        Scanner sc = new Scanner(System.in);
        log.info("Choose account currency: USD, BYN, EUR");
        String cur;
        cur = sc.nextLine();

        try {
            AccountCurrency enteredCurrency = AccountCurrency.valueOf(cur);
            acc.setCurrency(enteredCurrency);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        /*switch (cur) {
            case "USD" -> acc.setCurrency(AccountCurrency.USD);
            case "BYN" -> acc.setCurrency(AccountCurrency.BYN);
            case "EUR" -> acc.setCurrency(AccountCurrency.EUR);
            default -> log.warn("No such item!");
        }*/
    }

    public void printAccountsInfo() throws IOException {
        accountList.printAccountList();
        display();
    }
}