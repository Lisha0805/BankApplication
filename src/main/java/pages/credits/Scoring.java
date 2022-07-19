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

    public void runScoring() throws IOException {
        AgeVerification av = new AgeVerification();
        av.runScoringRule();
    }

    public void refusal(){
        log.info("Loan denied");
        MainPage mainPage = new MainPage();
        try {
            mainPage.display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    Условия выдачи кредита:
    Если возраст превышает пенсионный возраст на момент возврата кредита --> кредит не выдаётся
    Если результат деления запрошенной суммы на срок погашения в годах более трети годового дохода --> кредит не выдаётся
    Если кредитный рейтинг -2 --> кредит не выдаётся
    Если в источнике дохода указано "безработный" --> кредит не выдаётся
    Если годовой платёж (включая проценты) больше половины дохода --> кредит не выдаётся
     */


}