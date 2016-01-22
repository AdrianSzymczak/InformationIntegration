/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class NumberHelper {

    public static Double handleFloat(String number) {
        if (number == null || number == "") {
            return null;
        }
        double multiplier = 0.0;
        String[] splittedNumber;
        number = number.replace("\\s+", "").toLowerCase();
        if (number.contains("e+")) {
            splittedNumber = number.split("e+");
            multiplier = Double.parseDouble(splittedNumber[1]);
            number = splittedNumber[0];
        } else {
            if (number.contains("e-")) {
                splittedNumber = number.split("e-");
                multiplier = -1.0 * Double.parseDouble(splittedNumber[1]);
                number = splittedNumber[0];
            }
        }
        if (isNumber(number)) {
            char rightmostSeparator = '-';
            char nextSeparator = '-';

            for (int i = number.length() - 1; i >= 0; i--) {
                char c = number.charAt(i);
                if (c == ' ' || c == '.' || c == ',') {
                    if (rightmostSeparator == '-') {
                        rightmostSeparator = c;
                    } else {
                        if (nextSeparator == '-') {
                            nextSeparator = c;
                        }
                    }
                }
            }

            char[] a = new char[1];
            a[0] = rightmostSeparator;
            char[] b = new char[1];
            b[0] = nextSeparator;
            String rightString = String.copyValueOf(a);
            String nextString = String.copyValueOf(b);

            if (nextSeparator == rightmostSeparator) {
                number = number.replace(rightString, "");
            } else {
                if (nextSeparator != '-') {
                    number = number.replace(nextString, "");
                }
            }
            number = number.replace(",", ".");
        } else {
            return null;
        }

        return Double.parseDouble(number) * Math.pow(
                10, multiplier);
    }

    public static boolean isNumber(String number) {
        return number.matches("^[-+,\\.]?\\d+(.\\d+)*$");
    }
}
