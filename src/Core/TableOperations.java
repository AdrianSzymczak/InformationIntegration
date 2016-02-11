/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import helpers.TextCleaningHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adrian
 */
public class TableOperations {

    public static List<List<String>> standarizeTable(List<List<String>> table) {
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                table.get(i).set(j, TextCleaningHelper.clean(table.get(i).get(j)));
            }
        }
        return table;
    }

    public static boolean validateTable(List<List<String>> table) {
        int n = table.get(0).size();
        for (int i = 1; i < table.size(); i++) {
            if (n != table.get(i).size()) {
                return false;
            }
        }
        return true;
    }

    public static List<String> copyRow(List<List<String>> table, int num) {
        return table.get(num);
    }

    public static List<String> cutColumnByNum(List<List<String>> table, int num) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < table.size(); i++) {
            result.add(table.get(i).get(num));
            table.get(i).remove(num);
        }
        return result;
    }

    public static List<String> copyColumnByNum(List<List<String>> table, int num) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < table.size(); i++) {
            result.add(table.get(i).get(num));
        }
        return result;
    }

    public static List<String> copyColumnByName(List<List<String>> table, String name) {
        int num = -1;
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < table.get(0).size(); i++) {
            if (table.get(0).get(i).equalsIgnoreCase(name)) {
                num = i;
                break;
            }
        }

        if (num >= 0) {
            for (int i = 0; i < table.size(); i++) {
                result.add(table.get(i).get(num));
            }
        }
        return result;
    }

    public static List<String> cutColumnByName(List<List<String>> table, String name) {
        int num = -1;
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < table.get(0).size(); i++) {
            if (table.get(0).get(i).equalsIgnoreCase(name)) {
                num = i;
                break;
            }
        }

        if (num >= 0) {
            for (int i = 0; i < table.size(); i++) {
                result.add(table.get(i).get(num));
                table.get(i).remove(num);
            }
        }
        return result;
    }
}
