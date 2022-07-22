package pages.credits;

import org.apache.log4j.Logger;
import pages.MenuPages;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;

public class CreditsPage implements MenuPages {
    private MainPage mainPage = new MainPage();
    Logger log = Logger.getLogger("APP1");
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() throws IOException, InterruptedException {
        int point;
        String menu = """
                Accounts
                1. Apply for a loan
                2. View information on the latest loan
                3.
                4.
                5. Back""";
        do {
            log.info(menu);
            point = scanner.nextInt();
            log.info(point);

            switch (point) {
                case 1:
                    log.info("Start of scoring");
                    Scoring sc = new Scoring();
                    sc.runScoring();
                    break;
                case 2:
                    Credit credit = (Credit) ResourceConverter.jsonToObject("credit.json", Credit.class);
                    log.info(credit.toString());
                    display();
                    break;
                case 3:
                    /////////
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
}