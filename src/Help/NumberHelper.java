/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class NumberHelper {
    
    public static Double parseDouble(String number) {
        if (number == null || number == "") {
            return null;
        }
        double multiplier = 0.0;
        String[] splittedNumber;
        number = number.replaceAll("\\s+", "").toLowerCase();
        if (number.contains("e+")) {
            splittedNumber = number.split("e+");
            if (splittedNumber.length > 2 || !isNumber(splittedNumber[0]) || !(isNumber(splittedNumber[1]))) {
                return null;
            }
            multiplier = Double.parseDouble(splittedNumber[1]);
            number = splittedNumber[0];
        } else {
            if (number.contains("e-")) {
                splittedNumber = number.split("e-");
                if (splittedNumber.length > 2 || !isNumber(splittedNumber[0]) || !(isNumber(splittedNumber[1]))) {
                    return null;
                }
                multiplier = -1.0 * Double.parseDouble(splittedNumber[1]);
                number = splittedNumber[0];
            }
        }
        if (isNumber(number)) {
            char rightmostSeparator = '*';
            char nextSeparator = '*';

            for (int i = number.length() - 1; i >= 0; i--) {
                char c = number.charAt(i);
                if (c == ' ' || c == '.' || c == ',') {
                    if (rightmostSeparator == '*') {
                        rightmostSeparator = c;
                    } else {
                        if (nextSeparator == '*') {
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
                if (nextSeparator != '*') {
                    number = number.replace(nextString, "");
                    number = number.replace(rightString, ".");
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
        if (number == null || number == "") {
            return false;
        }
        number = number.replaceAll("\\s+", "");
        return number.matches("^[-|+|,|\\.|\\s+]?\\d+([\\s+|,|\\.]?\\d+)*$");
    }
}
