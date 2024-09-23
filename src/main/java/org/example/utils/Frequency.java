package org.example.utils;

public class Frequency {
    public static final String MONTHLY = "monthly";
    public static final String QUARTERLY = "quarterly";
    public static final String ANNUALLY = "annually";
    public static final String AT_MATURITY = "at maturity";

    public static String getFrequencyFromSelection(int frequencySelection) {
        return switch (frequencySelection) {
            case 1 -> Frequency.MONTHLY;
            case 2 -> Frequency.QUARTERLY;
            case 3 -> Frequency.ANNUALLY;
            case 4 -> Frequency.AT_MATURITY;
            default -> throw new IllegalArgumentException("Invalid frequency selection: " + frequencySelection);
        };
    }


    public static int getFrequency(String frequency) {
        return switch (frequency) {
            case MONTHLY -> 12;
            case QUARTERLY -> 4;
            case ANNUALLY, AT_MATURITY -> 1;
            default -> throw new IllegalArgumentException("Invalid frequency: " + frequency);
        };
    }
}
