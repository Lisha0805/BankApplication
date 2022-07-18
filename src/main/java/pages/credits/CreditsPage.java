package pages.credits;

import org.apache.log4j.Logger;
import pages.MenuPages;
import pages.main.MainPage;

import java.io.IOException;
import java.util.Scanner;

public class CreditsPage implements MenuPages {
    private MainPage mainPage = new MainPage();
    Logger log = Logger.getLogger("APP1");

    /*
Суммы кредита:
Если работают несколько условий по сумме кредита - выбирается наименьшая
При пассивном доходе выдаётся кредит на сумму до 1 млн, наёмным работникам - до 5 млн, собственное дело - до 10 млн
При кредитном рейтинге -1 выдаётся кредит на сумму до 1 млн, при 0 - до 5 млн, при 1 или 2 - до 10 млн

Условия изменения базовой ставки:
Все модификаторы процентной ставки суммируются, применяется итоговый модификатор
            -2% для ипотеки,
            -0.5% для развития бизнеса,
            +1.5% для потребительского кредита
            +1.5% для кредитного рейтинга -1,
            0% для кредитного рейтинга 0,
            -0.25% для кредитного рейтинга 1,
            -0.75% для кредитного рейтинга 2

Модификатор в зависимости от запрошенной суммы рассчитывается по формуле [-log(sum)];
например, для 0.1 млн изменение ставки составит +1%, для 1 млн - 0%, для 10 млн изменение ставки составит -1%
        Для пассивного дохода ставка повышается на 0.5%,
        для наемных работников ставка снижается на 0.25%,
        для заемщиков с собственным бизнесом ставка повышается на 0.25%

Способ расчета годового платежа:
Базовая ставка - 10% Годовой платеж по кредиту определяется по следующей формуле: (<сумма кредита> * (1 + <срок погашения> * (<базовая ставка> + <модификаторы>))) / <срок погашения>
     */

    @Override
    public void display() throws IOException {
        int point;

        String menu = """
                Accounts
                1.
                2. Apply for a loan
                3.
                4.
                5. Back""";
        do {
            log.info(menu);
            Scanner scanner = new Scanner(System.in);
            point = scanner.nextInt();
            log.info(point);

            switch (point) {
                case 1:
                    log.info("Start of scoring");
                    Scoring sc = new Scoring();
                    sc.ageVerification();
                    break;
                case 2:
///////////////
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
