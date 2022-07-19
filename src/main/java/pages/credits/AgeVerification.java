package pages.credits;

import org.apache.log4j.Logger;
import pages.settings.PersonalData;
import util.ResourceConverter;

import java.io.IOException;

public class AgeVerification implements ScoringRule{
    Logger log = Logger.getLogger("APP1");
    CreditRatingVerification crv = new CreditRatingVerification();
    PersonalData pd;
    {
        try {
            pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AgeVerification() throws IOException {
    }

    @Override
    public void runScoringRule() throws IOException {
        log.info("Age verification");
        pd.calculateAge();
        log.info("Age: " + pd.getAge());
        if (pd.getAge() >= 18 && pd.getAge() < 60){
            log.info("Verification passed");
            crv.runScoringRule();
        }
        else {
            log.info("Verification failed");
            Scoring refusal = new Scoring();
            refusal.refusal();
        }
    }
}
