/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Adrian
 */
public class TextCleaningHelper {

    public static Map<String, String> forbiddenSignsTranslations = populateForbiddenSignsTranslations();

    public static Map<String, String> populateForbiddenSignsTranslations() {
        Map<String, String> signs = new HashMap<String, String>();
        signs.put("||", "or sign");
        signs.put("&&", "and sign");
        signs.put("^", "caret");
        signs.put("%", "percent sign");
        signs.put("@", "at sign");
        signs.put(">=", "greater or equal than sign");
        signs.put("<=", "less or equal than sign");
        signs.put("<>", "different from sign");
        signs.put("!=", "different from sign");
        signs.put("…", "ellipsis");
        signs.put("...", "ellipsis");
        signs.put("’", "apostrophe");
        signs.put("'", "apostrophe");
        signs.put("|", "vertical bar sign");
        signs.put("(", "opening round bracket");
        signs.put("[", "opening square bracket");
        signs.put("[", "opening curly bracket");
        signs.put(")", "closing round bracket");
        signs.put("]", "closing square bracket");
        signs.put("}", "closing curly bracket");
        signs.put("\\", "backslash");
        signs.put("/", "slash");
        signs.put("⁄", "slash");
        signs.put(":", "colon");
        signs.put(";", "semicolon");
        signs.put(",", "comma");
        signs.put("،", "comma");
        signs.put("、", "comma");
        signs.put("‒", "dash");
        signs.put("—", "dash");
        signs.put("!", "exclamation mark");
        signs.put(".", "period");
        signs.put("-", "minus sign");
        signs.put("?", "question mark");
        signs.put("‘", "opening quotation mark");
        signs.put("’", "closing quotation mark");
        signs.put("“", "opening quotation mark");
        signs.put("”", "closing quotation mark");
        signs.put("'", "quotation mark");
        signs.put("\"", "quotation mark");
        signs.put("×", "cross sign");
        signs.put("*", "multiplication sign");
        signs.put("?", "question mark");
        signs.put("%", "percent sign");
        signs.put("~", "tilde");
        signs.put("#", "hashtag");
        signs.put("&", "ampersands");
        signs.put("/", "slash");
        signs.put("\\", "backslash");
        signs.put("<", "less than sign");
        signs.put(">", "greater than sign");
        signs.put("=", "equals sign");
        signs.put("!", "exclamation mark");
        signs.put("$", "dollar sign");
        signs.put("€", "euro sign");
        signs.put("£", "pound sign");
        signs.put("﷼", "IRRorYER");
        signs.put("₩", "KPWorKRW");
        signs.put("¥", "CNYorJPY");
        signs.put("ج.م", "EGP");
        signs.put("ل.س", "SYP");
        signs.put(".د.ب", "BHD");
        signs.put("؋", "AFN");
        signs.put("৳", "BDT");
        signs.put("฿", "THB");
        signs.put("₡", "CRC");
        signs.put("₦", "NGN");
        signs.put("₪", "ILS");
        signs.put("₫", "VND");
        signs.put("₭", "LAK");
        signs.put("₮", "MNT");
        signs.put("₱", "PHP");
        signs.put("₲", "PYG");
        signs.put("₴", "UAH");
        signs.put("₵", "GHS");
        signs.put("₹", "INR");
        signs.put("Kč", "CZK");
        signs.put("zł", "PLN");
        signs.put("ден", "MKD");
        signs.put("дин", "RSD");
        signs.put("лв", "BGN");
        signs.put("ლ", "GEL");
        signs.put("ج.س.", "SDG");
        signs.put("د. م.", "MAD");
        signs.put("د.إ", "AED");
        signs.put("د.ا", "JOD");
        signs.put("د.ت", "TND");
        signs.put("د.ج", "DZD");
        signs.put("د.ك", "KWD");
        signs.put("د.م.", "MAD");
        signs.put("ر.س", "SAR");
        signs.put("ر.ع.", "OMR");
        signs.put("ر.ق", "QAR");
        signs.put("ع.د", "IQD");
        signs.put("ل.د", "LYD");
        signs.put("ل.ل", "LBP");
        signs.put("元", "CNY");
        signs.put("ل.ل", "LBP");
        signs.put("元", "CNY");
        return signs;
    }

    public static String clean(String s) {
        if (s == null || s == "") {
            return s;
        }
        for (Map.Entry<String, String> entry : forbiddenSignsTranslations.entrySet()) {
            s = s.replace(entry.getKey(), " " + entry.getValue() + " ");
        }
        return s.replaceAll("[^A-Za-z0-9]", " ").replaceAll("\\s+", " ");
    }
}
