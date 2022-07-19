package pages.credits;

import org.apache.log4j.Logger;
import pages.settings.PersonalData;
import util.ResourceConverter;

import java.io.IOException;

public class CreditRatingVerification implements ScoringRule{
    Logger log = Logger.getLogger("APP1");
    Scoring ref = new Scoring();
    PersonalData pd;

    {
        try {
            pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CreditRatingVerification() throws IOException {
    }

    @Override
    public void runScoringRule() {
        log.info("Credit rating verification");
        log.info("Credit Rating: " + pd.getCreditRating());
        if (pd.getCreditRating() > -2){
            log.info("Verification passed");}
        else {
            log.info("Verification failed");
            ref.refusal();}
    }
}
