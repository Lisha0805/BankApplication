package authorization;

import org.apache.log4j.Logger;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;

public class Authorization {

    Scanner scanner = new Scanner(System.in);
    MainPage mainPage = new MainPage();
    Logger logger = Logger.getLogger(Authorization.class);

    public void applicationLogin() throws IOException {
        UserCredentials order = (UserCredentials) ResourceConverter.yamlToObject("authorization.yaml", UserCredentials.class);

        String login, password;
        int attempt = 0;
        do {
            logger.info("Please enter login and password:");
            login = scanner.nextLine();
            password = scanner.nextLine();
            UserCredentials credentials = new UserCredentials();
            credentials.setCredentials(login, password);

            //if (login.equals(order.getLogin()) && password.equals(order.getPassword())) mainPage.display();
            if (credentials.equals(order)) mainPage.display();
            else {logger.warn("Wrong login or password!"); attempt++; }
            if (attempt == 3) {logger.fatal("Ran out of attempts"); System.exit(2);}
        } while (true);
    }
}