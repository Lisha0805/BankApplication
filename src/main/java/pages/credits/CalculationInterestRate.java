package pages.credits;

import org.apache.log4j.Logger;
import pages.settings.PersonalData;
import pages.settings.PersonalDataSourceOfIncome;

import java.io.IOException;
/*
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
*/

public class CalculationInterestRate implements ScoringRule{
    private double mod;
    Logger log = Logger.getLogger("APP1");
    Credit cr = new Credit();
    PersonalData pd = new PersonalData();

    @Override
    public void runScoringRule() throws IOException, InterruptedException {
        log.info("CALCULATION INTEREST RATE");
        Thread.sleep(4000);
        mod = 0;
        if (cr.getCreditPurpose() == CreditPurpose.MORTGAGE) mod = mod -2;
        else if (cr.getCreditPurpose() == CreditPurpose.BUSINESS) mod = mod - 0.5;
        else if (cr.getCreditPurpose() == CreditPurpose.CONSUMER) mod = mod + 1.5;

        if (pd.getCreditRating() == -1) mod = mod + 1.5;
        else if (pd.getCreditRating() == 1) mod = mod -0.25;
        else if (pd.getCreditRating() == 2) mod = mod - 0.75;

        if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.OWN_BUSINESS) mod = mod + 0.25;
        else if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.PASSIVE_INCOME) mod = mod + 0.5;
        else if (pd.getSourceOfIncome() == PersonalDataSourceOfIncome.EMPLOYEE) mod = mod - 0.25;
    }

    public double getMod() {
        return mod;
    }
}