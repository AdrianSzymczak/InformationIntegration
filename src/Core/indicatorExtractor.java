/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author facu 
 */
public class indicatorExtractor {

    public List<List<String>> getIndicators(List<List<String>> imf,
            List<List<String>> wefm, List<List<String>> wddm) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        //IMF
        for (int i = 1; i < imf.size(); i++) {
            List<String> rowReaded = imf.get(i);
            List<String> rowResult = new ArrayList<String>();

            String code = null;
            String notes = rowReaded.get(4);
            String descriptor = rowReaded.get(3);
            String units = rowReaded.get(5);
            String scale = rowReaded.get(6);
            String source = null;
            String countryNotes = rowReaded.get(7);

            rowResult.add(code);
            rowResult.add(notes);
            rowResult.add(descriptor);
            rowResult.add(units);
            rowResult.add(scale);
            rowResult.add(source);
            rowResult.add(countryNotes);

            result.add(rowResult);

        }

        //WEFM
        for (int i = 1; i < wefm.size(); i++) {
            List<String> rowReaded = wefm.get(i);
            List<String> rowResult = new ArrayList<String>();

            String code = rowReaded.get(0);
            String notes = rowReaded.get(5);
            String descriptor = rowReaded.get(1);
            String units = rowReaded.get(2);
            String scale = rowReaded.get(6);
            String source = rowReaded.get(4);
            String countryNotes = null;

            rowResult.add(code);
            rowResult.add(notes);
            rowResult.add(descriptor);
            rowResult.add(units);
            rowResult.add(scale);
            rowResult.add(source);
            rowResult.add(countryNotes);

            result.add(rowResult);

        }

        //WDD
        for (int i = 1; i < wddm.size(); i++) {
            List<String> rowReaded = wddm.get(i);
            List<String> rowResult = new ArrayList<String>();

            String code = rowReaded.get(0);
            String notes = rowReaded.get(2);
            String descriptor = rowReaded.get(1);
            String units = null;
            String scale = null;
            String source = rowReaded.get(3);
            String countryNotes = null;

            rowResult.add(code);
            rowResult.add(notes);
            rowResult.add(descriptor);
            rowResult.add(units);
            rowResult.add(scale);
            rowResult.add(source);
            rowResult.add(countryNotes);

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
//            
//            List<String> rowReaded= result.get(i);
//            System.out.println(rowReaded.get(0));
//            System.out.println(rowReaded.get(1));
//            System.out.println(rowReaded.get(2));
//            System.out.println(rowReaded.get(3));
//            System.out.println(rowReaded.get(4));
        }

        return result;

    }

    public List<List<String>> getIMFWithIndicatorId(List<List<String>> source,
            List<List<String>> indicators) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 1; i < source.size(); i++) {
            List<String> rowSource = source.get(i);
            String indicatorId = this.getIndicatorIDIMF(indicators, rowSource);
            rowSource.set(3, indicatorId);
            result.add(rowSource);
        }

        return result;
    }

    public List<List<String>> getWDDWithIndicatorId(List<List<String>> source,
            List<List<String>> indicators) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 1; i < source.size(); i++) {
            List<String> rowSource = source.get(i);
            String indicatorId = this.getIndicatorIDWDD(indicators, rowSource);
            rowSource.add(0, indicatorId);
            result.add(rowSource);
        }

        return result;
    }

    public List<List<String>> getWEFDWithIndicatorId(List<List<String>> source,
            List<List<String>> indicators) throws Exception {

        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 0; i < source.size(); i++) {
            List<String> rowSource = source.get(i);
            String indicatorId = this.getIndicatorIDWEFD(indicators, rowSource);
            rowSource.add(0, indicatorId);
            result.add(rowSource);
        }

        return result;
    }

    public String getIndicatorIDIMF(List<List<String>> indicators,
            List<String> source) throws Exception {
        String id = "-1";

        for (int i = 0; i < indicators.size(); i++) {
            List<String> rowIndicator = indicators.get(i);

            if ((rowIndicator.get(2)!=null)&&rowIndicator.get(2).equals(source.get(4))) {
                //System.out.println(rowIndicator.get(2));
                id = rowIndicator.get(0);
            }
        }
        return id;
    }

    public String getIndicatorIDWDD(List<List<String>> indicators,
            List<String> source) throws Exception {
        String id = "-1";

        for (int i = 0; i < indicators.size(); i++) {
            List<String> rowIndicator = indicators.get(i);

            if ((rowIndicator.get(1) != null)&&(rowIndicator.get(1).equals(source.get(3)))) {
                id = rowIndicator.get(0);
            }
        }
        return id;
    }

    public String getIndicatorIDWEFD(List<List<String>> indicators,
            List<String> source) throws Exception {
        String id = "-1";

        for (int i = 0; i < indicators.size(); i++) {
            List<String> rowIndicator = indicators.get(i);

            if ((rowIndicator.get(1) != null)&&(rowIndicator.get(1).equals(source.get(1)))) {
                id = rowIndicator.get(0);
            }
        }
        return id;
    }

}
