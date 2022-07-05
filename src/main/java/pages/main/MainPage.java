package pages.main;

import authorization.Authorization;
import org.apache.log4j.Logger;
import pages.MenuPages;
import pages.accounts.AccountsPage;
import pages.credits.CreditsPage;
import pages.settings.SettingsPage;

import java.io.IOException;
import java.util.Scanner;

public class MainPage implements MenuPages {
    Logger logger = Logger.getLogger(MainPage.class);

    @Override
    public void display() throws IOException {
        Scanner scanner = new Scanner(System.in);
        AccountsPage accounts = new AccountsPage();
        SettingsPage setting = new SettingsPage();
        CreditsPage credit = new CreditsPage();

        int point;
        String menu = "Maim menu: \n1. Accounts \n2. Settings \n3. Credits";
        do {
            logger.info(menu);
            point = scanner.nextInt();

            switch (point) {
                case 1 -> accounts.display();
                case 2 -> setting.display();
                case 3 -> credit.display();
                default -> logger.info("No such item!");
            }
        } while (point > 3);
    }
}
