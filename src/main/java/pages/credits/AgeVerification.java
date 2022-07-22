package pages.credits;

import org.apache.log4j.Logger;
import pages.settings.PersonalData;
import util.ResourceConverter;

import java.io.IOException;

public class AgeVerification implements ScoringRule{
    Logger log = Logger.getLogger("APP1");
    CalculationOfTheAmount crv = new CalculationOfTheAmount();
    PersonalData pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);

    public AgeVerification() throws IOException {
    }

    @Override
    public void runScoringRule() throws IOException, InterruptedException {
        log.info("AGE VERIFICATION");
        Thread.sleep(4000);
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