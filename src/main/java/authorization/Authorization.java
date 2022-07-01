package authorization;

import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;

public class Authorization {

    Scanner scanner = new Scanner(System.in);
    MainPage mainPage = new MainPage();

    public void applicationLogin() throws IOException {
        UserCredentials order = (UserCredentials) ResourceConverter.yamlToObject("authorization.yaml", UserCredentials.class);

        String login, password;
        int attempt = 0;
        do {
            System.out.println("Please enter login and password:");
            login = scanner.nextLine();
            password = scanner.nextLine();
            //инициализировать кредо с логином и паролем
            UserCredentials credentials = new UserCredentials();
            credentials.setCredentials(login, password);

            //сделать сравнение объектов
            //if (login.equals(order.getLogin()) && password.equals(order.getPassword())) mainPage.display();
            if (credentials.equals(order)) mainPage.display();
            else {System.out.println("Wrong login or password!"); attempt++; }

            if (attempt == 3) {System.out.println("Ran out of attempts"); System.exit(2);}
        } while (true);
    }
}