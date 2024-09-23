package org.example.model;

/**
 * @param initialDepositAmount principal or initial deposit
 * @param interestRate         annual interest rate
 * @param investmentTerm       time the money is invested for (in years)
 * @param frequency            number of times interest is compounded per year (e.g., monthly = 12, annually = 1)
 */
public record TermDeposit(double initialDepositAmount, double interestRate, int investmentTerm,
                          String frequency) {

}
