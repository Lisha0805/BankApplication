package authorization;

import org.apache.log4j.Logger;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;

public class Authorization {

    Scanner scanner = new Scanner(System.in);
    MainPage mainPage = new MainPage();
    Logger loggerToConsole = Logger.getLogger("APP1");
    Logger loggerToFile = Logger.getLogger("APP2");

    public void applicationLogin() throws IOException {
        UserCredentials order = (UserCredentials) ResourceConverter.yamlToObject("authorization.yaml", UserCredentials.class);

        String login, password;
        int attempt = 0;
        do {
            loggerToConsole.info("Please enter login and password:");
            loggerToFile.info("Please enter login and password");
            login = scanner.nextLine();
            password = scanner.nextLine();
            UserCredentials credentials = new UserCredentials();
            credentials.setCredentials(login, password);

            //if (login.equals(order.getLogin()) && password.equals(order.getPassword())) mainPage.display();
            if (credentials.equals(order)) {
                mainPage.display();
                loggerToFile.info("Successful login");
            }
            else {
                loggerToConsole.warn("Wrong login or password!");
                loggerToFile.warn("Wrong login or password!");
                attempt++;
            }
            if (attempt == 3) {
                loggerToConsole.fatal("Ran out of attempts");
                loggerToFile.fatal("Ran out of attempts");
                System.exit(2);}
        } while (true);
    }
}