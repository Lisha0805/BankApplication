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

    @Override
    public void display() throws IOException {
        Scanner scanner = new Scanner(System.in);
        AccountsPage accounts = new AccountsPage();
        SettingsPage setting = new SettingsPage();
        CreditsPage credit = new CreditsPage();
        Logger loggerToConsole = Logger.getLogger("APP1");
        Logger loggerToFile = Logger.getLogger("APP2");

        int point;
        String menu = """
                Maim menu:
                1. Accounts
                2. Settings
                3. Credits""";

        do {
            loggerToConsole.info(menu);
            loggerToFile.info(menu);
            point = scanner.nextInt();

            switch (point) {
                case 1 -> accounts.display();
                case 2 -> setting.display();
                case 3 -> credit.display();
                default -> {
                    loggerToConsole.warn("No such item!");
                    loggerToFile.warn("No such item!");
                }
            }
        } while (point > 3);
    }
}
