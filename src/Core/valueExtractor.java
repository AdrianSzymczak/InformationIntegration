/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import helpers.NumberHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author facu
 */
public class valueExtractor {

    public static int errorsCounter = 0;
    public static Map<String, Integer> setOfErrors = new HashMap<>();

    private void handleNumberCell(List<String> rowResult, String value) {
        if (rowResult == null) {
            return;
        }
        if (value == null) {
            rowResult.add(null);
        } else {
            Double temp = NumberHelper.parseDouble(value);
            if (temp == null) {
                if (setOfErrors.containsKey(value)) {
                    setOfErrors.put(value, setOfErrors.get(value) + 1);
                } else {
                    setOfErrors.put(value, 1);
                }

                rowResult.add(null);
            } else {
                rowResult.add(temp.toString());
            }
        }
    }

    public List<List<String>> getValues(List<List<String>> imf, List<List<String>> wefd,
            List<List<String>> wefe, List<List<String>> wefm, List<List<String>> wdd,
            List<List<String>> wdm) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        //IMF
        for (int i = 0; i < imf.size(); i++) {
            List<String> rowReaded = imf.get(i);
            List<String> rowResult = new ArrayList<String>();

            String fk_country = rowReaded.get(0);
            String fk_indicator = rowReaded.get(3);
            rowResult.add(fk_country);
            rowResult.add(fk_indicator);

            for (int k = 8; k < 50; k++) {
                handleNumberCell(rowResult, rowReaded.get(k));
            }

            result.add(rowResult);
        }

        //WD
        for (int i = 0; i < wdd.size(); i++) {
            List<String> rowReaded = wdd.get(i);
            List<String> rowResult = new ArrayList<String>();

            String fk_country = rowReaded.get(1);
            String fk_indicator = rowReaded.get(0);

            rowResult.add(fk_country);
            rowResult.add(fk_indicator);

            // these years don't exist in this dataset
            for (int k = 1980; k < 1996; k++) {
                handleNumberCell(rowResult, null);
            }

            for (int k = 5; k < 25; k++) {
                handleNumberCell(rowResult, rowReaded.get(k));
            }

            // these years don't exist in this dataset plus column estimates
            for (int k = 2016; k < 2022; k++) {
                handleNumberCell(rowResult, null);
            }

            result.add(rowResult);
        }

        //WEF
        List<String> wfedFiltered = getWEFDIndicatorsFiltered(wefd);
        List<String> firstRow = wefd.get(0);
        for (int i = 3; i < 154; i++) {

            for (int j = 0; j < wfedFiltered.size(); j++) {

                List<String> rowResult = new ArrayList<String>();
                rowResult.add(firstRow.get(i)); //FkCountry
                rowResult.add(wfedFiltered.get(j)); //FkIndicator

                List<List<String>> valuesOfIndicator = this.getValuesOfIndicator(wfedFiltered.get(j), wefd);

                for (int z = valuesOfIndicator.size(); z <= 35 - valuesOfIndicator.size(); z++) {
                    rowResult.add(null); //Years without information 1980-2005
                }

//            System.out.println(valuesOfIndicator.size());
                for (int z = 0; z < valuesOfIndicator.size(); z++) {
                    handleNumberCell(rowResult, valuesOfIndicator.get(z).get(i));
                }

                for (int z = 0; z < 44 - rowResult.size(); rowResult.add(null)) {
                    //rowResult.add( null); //Years without information 2016-end
                }
                result.add(rowResult);

            }

        }

        for (int i = 0; i < result.size(); i++) {
            String id = Integer.toString(i + 1);
            result.get(i).add(0, id);
        }

        return result;
    }

    public String getIndicatorFKWD(String code, List<List<String>> wdm) {
        String result = "-2";//new String();

        for (int i = 0; i < wdm.size(); i++) {
            List<String> rowIndicator = wdm.get(i);
            if (rowIndicator.get(1).equals(code)) {
                result = rowIndicator.get(0);
            }
        }

        return result;
    }

    public List<List<String>> getValuesOfIndicator(String indicator,
            List<List<String>> wefd) {

        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 0; i < wefd.size(); i++) {
            if (wefd.get(i).get(0).equals(indicator)) {
                result.add(wefd.get(i));
            }
        }

        return result;
    }

    public List<String> getWEFDIndicatorsFiltered(List<List<String>> wefd) {
        List<String> result = new ArrayList<String>();

        for (int i = 1; i < wefd.size(); i++) {
            result.add(wefd.get(i).get(0));
        }

        //Removing Duplicates
        Set<String> hs = new HashSet<>();
        hs.addAll(result);
        result.clear();
        result.addAll(hs);

        return result;
    }
}
