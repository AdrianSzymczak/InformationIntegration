/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Help.TextCleaningHelper;
import Models.Country;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Adrian
 */
public class TableOperations {

    public static Double replacemementNumber = 0.0;
    public static String replacemementNumberString = replacemementNumber.toString();

    public static Comparator<String> comparatorSingle = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int i = Integer.parseInt(o1);
            int j = Integer.parseInt(o2);
            if (i > j) {
                return 1;
            }
            if (i < j) {
                return -1;
            }
            return 0;
        }
    };

    public static Comparator<List<String>> comparatorLists = new Comparator<List<String>>() {
        @Override
        public int compare(List<String> o1, List<String> o2) {
            int i = Integer.parseInt(o1.get(2));
            int j = Integer.parseInt(o2.get(2));
            if (i > j) {
                return 1;
            }
            if (i < j) {
                return -1;
            }
            return 0;
        }
    };

    public static List<List<String>> prepareSingleCountry(List<List<String>> array, Set<String> indicators) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> localIndicators = new HashMap<String, List<String>>();
        String country = array.get(0).get(1);
        for (int i = 0; i < array.size(); i++) {
            localIndicators.put(array.get(i).get(2), array.get(i));
        }
        for (String s : indicators) {
            if (!localIndicators.containsKey(s)) {
                List<String> newList = new ArrayList<String>(45);
                newList.add(replacemementNumberString);
                newList.add(country);
                newList.add(s);
                for (int i = 3; i < array.get(0).size(); i++) {
                    newList.add(replacemementNumberString);
                }
                result.add(newList);
            }
        }
        for (List<String> l : localIndicators.values()) {
            result.add(l);
        }
        Collections.sort(result, comparatorLists);
        return result;
    }

    public static List<List<String>> splitByCountry(List<List<String>> table, List<List<String>> cTable, List<List<String>> iTable) {
        Set<String> indicators = new HashSet<String>();
        Set<String> countries = new HashSet<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<List<String>>> byCountry = new HashMap<String, List<List<String>>>();
        Set<String> indicatorsTable = new HashSet<String>();
        Set<String> countriesTable = new HashSet<String>();

        for (List<String> l : cTable) {
            countriesTable.add(l.get(0));
        }
        for (List<String> l : iTable) {
            indicatorsTable.add(l.get(0));
        }
        for (int i = 0; i < table.size(); i++) {
            if (indicatorsTable.contains(table.get(i).get(2))
                    && countriesTable.contains(table.get(i).get(1))) {
                indicators.add(table.get(i).get(2));
                countries.add(table.get(i).get(1));
                if (!byCountry.containsKey(table.get(i).get(1))) {
                    byCountry.put(table.get(i).get(1), new ArrayList<List<String>>());
                }
                byCountry.get(table.get(i).get(1)).add(table.get(i));
            }
        }

        for (Entry<String, List<List<String>>> singleCountry : byCountry.entrySet()) {
            if (!singleCountry.getValue().isEmpty()
                    || singleCountry.getValue().get(0) == null
                    || singleCountry.getValue().get(0).size() == 0
                    || singleCountry.getValue().get(0).isEmpty()) {
                res.addAll(
                        createView(
                                transpose(
                                        prepareSingleCountry(singleCountry.getValue(), indicators)),
                                singleCountry.getKey()));
            }
        }

        ArrayList<String> header = new ArrayList<String>();
        header.add("Country");
        header.add("Year");
        List<String> list = new ArrayList<String>(indicators);
        Collections.sort(list, comparatorSingle);
        for (String s : list) {
            header.add("indicator-" + String.valueOf(s));
        }
        header.addAll(Country.header);
        res.add(0, header);
        return res;
    }

    public static List<List<String>> createView(List<List<String>> table, String countryName) {
        List<List<String>> result = new ArrayList<List<String>>();
        int rowsToCutFromStart = 3;
        int rowsToCutFromEnd = 1;
        int yearsCounter = 1980;
        for (int i = rowsToCutFromStart; i < table.size() - rowsToCutFromEnd; i++) {
            ArrayList<String> k = new ArrayList<String>(table.get(i).size() + 2);
            k.add(0, countryName);
            k.add(1, String.valueOf(yearsCounter++));
            k.addAll(table.get(i));
            k.addAll(Models.Country.countriesMap.get(countryName).toList());
            result.add(k);
        }
        return result;
    }

    static <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<T>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }

    public static List<List<String>> standarizeTable(List<List<String>> table) {
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                table.get(i).set(j, TextCleaningHelper.clean(table.get(i).get(j)));
            }
        }
        return table;
    }

    public static List<List<String>> getCleanSubset(List<List<String>> table) {
        Set<Integer> firstCoordinates = new HashSet<Integer>();
        Set<Integer> secondCoordinates = new HashSet<Integer>();
        boolean consider = false;
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
                consider = false;
                try {
                    if (table.get(i).get(j) == null) {
                        consider = true;
                    }
                    Double d = Double.parseDouble(table.get(i).get(j));
                    if (d == 0.0) {
                        consider = true;
                    }
                } catch (NumberFormatException e) {
                    consider = true;
                } finally {
                    if (consider) {
                        firstCoordinates.add(i);
                        secondCoordinates.add(j);
                    }
                }
            }
        }
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(i).size(); j++) {
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
