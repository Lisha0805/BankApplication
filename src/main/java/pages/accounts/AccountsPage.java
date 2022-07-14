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
    Account acc = (Account) ResourceConverter.yamlToObject("accounts.yaml", Account.class);

    public AccountsPage() throws IOException {
    }

    @Override
    public void display() throws IOException {
        int point;
        String menu = """
                Accounts
                1. Add new account
                2. Delete account
                3. View accounts
                4. View account balance
                5. Back""";
        do {
            log.info(menu);
            Scanner scanner = new Scanner(System.in);
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
                    printAccounts(acc);
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

        AccountList accList = new AccountList();

        Scanner sc = new Scanner(System.in);

        log.info("Enter account number:");
        long numberAccount = sc.nextInt();
        log.info("""
                Choose account currency:
                1.USD
                2.BYN
                3.EUR""");
        int pointCurrency = sc.nextInt();
        EnumCurrency cur = EnumCurrency.BYN;

        switch (pointCurrency) {
            case 1 -> cur = EnumCurrency.USD;
            case 2 -> cur = EnumCurrency.BYN;
            case 3 -> cur = EnumCurrency.EUR;
            default -> log.warn("No such item!");
        }
        accList.list.add(new Account(numberAccount, cur, EnumStatus.ACTIVE, 0));

        ResourceConverter.objectToYaml("accounts.yaml", AccountList.class);
        display();
    }

    public void deleteAccount(){

    }

    public void printAccounts(Account account) throws IOException {
        String printAccounts = "Accounts: " +
                "\n" + " Number account: " + account.getNumber()+
                "\n" + " Currency account: " + account.getCurrency() +
                "\n" + " Status account: " + account.getStatus() +
                "\n" + " Balance account " + account.getBalance();
        log.info(printAccounts);
        display();
    }
}