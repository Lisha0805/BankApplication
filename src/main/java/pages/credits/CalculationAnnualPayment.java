package pages.credits;

import org.apache.log4j.Logger;
import util.ResourceConverter;

import java.io.IOException;
/*
Способ расчета годового платежа:
Базовая ставка - 10% Годовой платеж по кредиту определяется по следующей формуле:
    (<сумма кредита> * (1 + <срок погашения> * (<базовая ставка> + <модификаторы>))) / <срок погашения>
     */

public class CalculationAnnualPayment implements ScoringRule{
    private double payment;
    Logger log = Logger.getLogger("APP1");

    @Override
    public void runScoringRule() throws IOException, InterruptedException {
        Credit credit = new Credit();
        log.info("CALCULATION ANNUAL PAYMENT");
        Thread.sleep(4000);
        payment = (credit.getLoanAmount() * (1 + credit.getLoanTerm()) * credit.getLoanInterestRate()) / (credit.getLoanTerm() * 12);
        payment = Math.pow(payment,2);
        credit.setCreditPayment(payment);
    }

    public double getPayment() {
        return payment;
    }
}