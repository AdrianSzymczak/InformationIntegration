/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import java.util.*;

/**
 *
 * @author facu
 */
public class HandlerCountries {

    public static List<List<String>> usedCountries(List<List<String>> countriesTable, List<List<String>> resTable) {
        Set<String> used = new HashSet<String>();
        for (List<String> l : resTable) {
            used.add(l.get(0));
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> l : countriesTable) {
            if (used.contains(l.get(0))) {
                res.add(l);
            }
        }
        res.add(0, Models.Country.headerFull);
        return res;
    }
      
    public static void changeTextToObjects(List<List<String>> table) {
        for (List<String> l : table) {
            new Models.Country(l);
        }
    }

    public List<List<String>> getCountries(List<List<String>> imf,
            List<List<String>> wefe, List<List<String>> wdd) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        //IMF
        for (int i = 1; i < imf.size(); i++) {
            List<String> rowReaded = imf.get(i);
            List<String> rowResult = new ArrayList<String>();

            String iso = rowReaded.get(0);
            String country = rowReaded.get(1);
            String incomingGroup = null;
            String region = null;
            rowResult.add(iso);
            rowResult.add(country);
            rowResult.add(incomingGroup);
            rowResult.add(region);

            result.add(rowResult);

        }

        //WEFD
        for (int i = 1; i < wefe.size(); i++) {
            List<String> rowReaded = wefe.get(i);
            List<String> rowResult = new ArrayList<String>();

            String iso = rowReaded.get(0);
            String country = rowReaded.get(1);
            String incomingGroup = rowReaded.get(2);
            String region = rowReaded.get(3);
            rowResult.add(iso);
            rowResult.add(country);
            rowResult.add(incomingGroup);
            rowResult.add(region);

            result.add(rowResult);

        }

        //WDD
        for (int i = 1; i < wdd.size(); i++) {
            List<String> rowReaded = wdd.get(i);
            List<String> rowResult = new ArrayList<String>();

            String iso = rowReaded.get(0);
            String country = rowReaded.get(1);
            String incomingGroup = null;
            String region = null;
            rowResult.add(iso);
            rowResult.add(country);
            rowResult.add(incomingGroup);
            rowResult.add(region);

            result.add(rowResult);

        }

        //Removing Duplicates
        Set<List<String>> hs = new HashSet<>();
        hs.addAll(result);
        result.clear();
        result.addAll(hs);

        //Adding ID   
        for (int i = 0; i < result.size(); i++) {
            String id = Integer.toString(i + 1);
            result.get(i).add(0, id);
        }

        //Solving duplicate conflicts   
        for (int i = 0; i < result.size(); i++) {
            int count = 0;
            for (int j = 0; j < result.size(); j++) {
                if (result.get(i).get(1).equals(result.get(j).get(1))
                        || result.get(i).get(2).equals(result.get(j).get(2))) {
                    count++;
                }
            }

            if (count > 1) {
                result.remove(i);
                i--;
            }
        }

        return result;

    }

    public List<List<String>> getSourceWithCountryId(List<List<String>> source,
            List<List<String>> countries) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 1; i < source.size(); i++) {
            List<String> rowSource = source.get(i);
            String countryId = this.getCountryID(countries, rowSource);
            rowSource.add(0, countryId);
            result.add(rowSource);
        }

        return result;
    }

    public String getCountryID(List<List<String>> countries,
            List<String> source) throws Exception {
        String id = "-1";

        for (int i = 0; i < countries.size(); i++) {
            List<String> rowCountry = countries.get(i);

            if (rowCountry.get(1).equals(source.get(0))) {
                id = rowCountry.get(0);
            }
        }
        return id;
    }

    public List<List<String>> getWEFDWithCountryId(List<List<String>> wefd,
            List<List<String>> countries) {
        List<String> newFirstRow = wefd.get(0);

        String id;
        for (int i = 2; i < newFirstRow.size(); i++) {
            id = "-1";
            for (int j = 0; j < countries.size(); j++) {
                List<String> rowCountry = countries.get(j);

                if (rowCountry.get(2).equals(newFirstRow.get(i))) {

                    newFirstRow.set(i, rowCountry.get(0));
                }
            }
        }
        wefd.set(0, newFirstRow);
        return wefd;
    }

}
