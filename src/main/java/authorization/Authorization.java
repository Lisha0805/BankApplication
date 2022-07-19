package authorization;

import org.apache.log4j.Logger;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;

public class Authorization {

    Scanner scanner = new Scanner(System.in);
    Logger log = Logger.getLogger("APP1");

    public void applicationLogin() throws IOException {
        UserCredentials order = (UserCredentials) ResourceConverter.yamlToObject("authorization.yaml", UserCredentials.class);

        String login, password;
        int attempt = 0;
        do {
            log.info("Please enter login and password:");
            login = scanner.nextLine();
            password = scanner.nextLine();
            UserCredentials credentials = new UserCredentials();
            credentials.setCredentials(login, password);

            if (credentials.equals(order)) {
                MainPage mainPage = new MainPage();
                mainPage.display();
                log.info("Successful login");}
            else {
                log.warn("Wrong login or password!");
                attempt++; }

            if (attempt == 3) {
                log.fatal("Ran out of attempts");
                System.exit(2);}
        } while (attempt < 3);
    }
}