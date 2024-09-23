package org.example.utils;

public class ValidationUtil {

    public static int MAX_VALUE = 1500000;
    public static int MIN_VALUE = 0;
    public static int MAX_VALUE_INVESTMENT_TERM = 5;

    public static double validateInput(double inputDoubleValue, String inputName) {
        if (inputDoubleValue < MIN_VALUE) {
            throw new IllegalArgumentException(inputName + " must be a positive number");
        } else if (inputDoubleValue == MIN_VALUE) {
            throw new IllegalArgumentException(inputName + " cannot be zero");
        } else if (inputDoubleValue > MAX_VALUE) {
            throw new IllegalArgumentException(inputName + " cannot be greater than " + Double.MAX_VALUE);
        }
        return inputDoubleValue;
    }

    public static int validateInput(int inputIntValue, String inputName) {
        if (inputIntValue < MIN_VALUE) {
            throw new IllegalArgumentException(inputName + " must be a positive integer");
        } else if (inputIntValue == MIN_VALUE) {
            throw new IllegalArgumentException(inputName + " cannot be zero");
        } else if (inputIntValue > MAX_VALUE_INVESTMENT_TERM) {
            throw new IllegalArgumentException(inputName + " cannot be greater than " + MAX_VALUE_INVESTMENT_TERM);
        }
        return inputIntValue;
    }
}
