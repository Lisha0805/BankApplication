package pages.credits;

import org.apache.log4j.Logger;
import pages.settings.PersonalData;
import pages.settings.PersonalDataSourceOfIncome;
import util.ResourceConverter;

import java.io.IOException;
/*Суммы кредита: Если работают несколько условий по сумме кредита - выбирается наименьшая
/done        При пассивном доходе выдаётся кредит на сумму до 1 млн, наёмным работникам - до 5 млн, собственное дело - до 10 млн
/done        При кредитном рейтинге -1 выдаётся кредит на сумму до 1 млн, при 0 - до 5 млн, при 1 или 2 - до 10 млн*

/done        Если безработный -> кредит не выдается
/done        Если кредитный рейтинг -2 -> кредит не выдается
 */
public class CalculationOfTheAmount implements ScoringRule{
    private long totalAmount;
    Logger log = Logger.getLogger("APP1");
    PersonalData pd = (PersonalData) ResourceConverter.jsonToObject("personalData.json", PersonalData.class);
    Scoring ref = new Scoring();

    public CalculationOfTheAmount() throws IOException {
    }

    @Override
    public void runScoringRule() throws IOException, InterruptedException {
        long maxAmountFromTheSource = 0; long maxAmountFromTheCreditRating = 0;
        log.info("SOURCE OF INCOME VERIFICATION");
        Thread.sleep(4000);

        if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.PASSIVE_INCOME) {
            maxAmountFromTheSource = 1000000;
            log.info("Verification passed");}
        else if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.EMPLOYEE) {
            maxAmountFromTheSource = 5000000;
            log.info("Verification passed");}
        else if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.OWN_BUSINESS) {
            maxAmountFromTheSource = 10000000;
            log.info("Verification passed");}
        else if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.UNEMPLOYED) {
            log.info("Verification failed!");
            ref.refusal();}

        Thread.sleep(1000);
        log.info("CREDIT RATING CHECK");
        Thread.sleep(4000);
        if (pd.getCreditRating() == -1) {
            maxAmountFromTheCreditRating = 1000000;
            log.info("Verification passed");}
        else if (pd.getCreditRating() == 0) {
            maxAmountFromTheCreditRating = 5000000;
            log.info("Verification passed");}
        else if (pd.getCreditRating() >= 1) {
            maxAmountFromTheCreditRating = 10000000;
            log.info("Verification passed");}
        else if (pd.getCreditRating() >= -2) {
            log.info("Verification failed");
            ref.refusal();}

        Thread.sleep(1000);
        log.info("CALCULATION OF THE LOAN AMOUNT");
        Thread.sleep(4000);
        totalAmount = Math.min(maxAmountFromTheSource,maxAmountFromTheCreditRating);
        log.info("Maximum available loan amount: " + totalAmount);
    }

    public long getTotalAmount() {
        return totalAmount;
    }
}