package org.example.service;

import org.example.model.TermDeposit;
import org.example.utils.Frequency;
import org.example.utils.ValidationUtil;

import static org.example.utils.ValidationUtil.validateInput;

public class CalculateService {

    /**
     * Calculating the final balance based on parameters provided
     * @param termDeposit record of {@link TermDeposit}
     * @return the final amount
     */
    public double calculateFinalBalance(TermDeposit termDeposit) {

        double finalBalance;

        double initialAmount = validateInput(termDeposit.initialDepositAmount(), "initial deposit amount");
        double interestRate = validateInput(termDeposit.interestRate() / 100, "interest rate");
        int investmentTerm = validateInput(termDeposit.investmentTerm(), "investment term");
        int frequency = Frequency.getFrequency(termDeposit.frequency());

        /*
         * if term deposit frequency is AT MATURITY then it is a simple interest calculation
         * using formula A=P×(1+r×t) where,
         * A is the final amount.
         * P is the initial deposit.
         * r is the annual interest rate.
         * t is the time the money is invested for (in years).
         */
        if (termDeposit.frequency().equals(Frequency.AT_MATURITY)) {
            // calculating (1+r×t)
            double compoundingFactor = 1 + (interestRate * investmentTerm);
            finalBalance = initialAmount * compoundingFactor;
        } else {
            /*
             * calculating the final amount using formula
             * A = P * (1 + (r / n)) ^ (n * t)
             * where,
             * A is the final amount.
             * P is the initial deposit.
             * r is the annual interest rate.
             * n is the number of times interest is compounded per year.
             * t is the time the money is invested for (in years).
             */

            // calculating (r / n)
            double ratePerPeriod = interestRate / frequency;

            // calculating (n * t)
            double totalPeriods = frequency * investmentTerm;

            // Calculating (1 + (r / n)) ^ (n * t)
            double compoundingFactor = Math.pow((1 + ratePerPeriod), totalPeriods);

            // final amount = P * (1 + (r / n)) ^ (n * t)
            finalBalance = initialAmount * compoundingFactor;

        }

        return Math.round(finalBalance);
    }
}
