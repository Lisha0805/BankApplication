package pages.credits;

import org.apache.log4j.Logger;
import pages.main.MainPage;
import pages.settings.PersonalData;
import util.ResourceConverter;

import java.io.IOException;

public class Scoring {
    Logger log = Logger.getLogger("APP1");
    PersonalData pd;

    public Scoring() throws IOException {
        pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
    }

    /*
    Условия выдачи кредита:
    Если возраст превышает пенсионный возраст на момент возврата кредита --> кредит не выдаётся
    Если результат деления запрошенной суммы на срок погашения в годах более трети годового дохода --> кредит не выдаётся
    Если кредитный рейтинг -2 --> кредит не выдаётся
    Если в источнике дохода указано "безработный" --> кредит не выдаётся
    Если годовой платёж (включая проценты) больше половины дохода --> кредит не выдаётся
     */
    public void ageVerification() throws IOException {     //60 лет
        log.info("Age verification");
        pd.calculateAge();
        log.info("Age: " + pd.getAge());
        if (pd.getAge() >= 18 && pd.getAge() < 60){log.info("Verification passed"); creditRatingVerification();}
        else {log.info("Verification failed"); refusal();}
    }

    public void creditRatingVerification() throws IOException {     //60 лет
        log.info("Credit rating verification");
        log.info("Credit Rating: " + pd.getCreditRating());
        if (pd.getCreditRating() > -2){log.info("Verification passed");}
        else {log.info("Verification failed"); refusal();}
    }

    public void refusal() throws IOException {
        log.info("Loan denied");
        MainPage mainPage = new MainPage();
        mainPage.display();
    }
}
