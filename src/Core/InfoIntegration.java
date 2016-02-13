/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Utils.FileHandler;
import Utils.TableOperations;
import Handlers.HandlerVaules;
import Handlers.HandlerIndicators;
import Handlers.HandlerCountries;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class InfoIntegration {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        FileHandler fl = new FileHandler();

        List<List<String>> imf = fl.loadStringToTable(fl.loadDocument("data/IMF-data.tsv"), "\n", "\t");
        List<List<String>> wefd = fl.loadStringToTable(fl.loadDocument("data/WEF-data.tsv"), "\n", "\t");
        List<List<String>> wefe = fl.loadStringToTable(fl.loadDocument("data/WEF-entities.tsv"), "\n", "\t");
        List<List<String>> wefm = fl.loadStringToTable(fl.loadDocument("data/WEF-metadata.tsv"), "\n", "\t");
        List<List<String>> wdm = fl.loadStringToTable(fl.loadDocument("data/WD-metadata.tsv"), "\n", "\t");
        List<List<String>> wdd = fl.loadStringToTable(fl.loadDocument("data/WD-data.csv"), "\n", ";");

        HandlerCountries ce = new HandlerCountries();
        List<List<String>> countriesTable = ce.getCountries(imf, wefe, wdd);
        imf = ce.getSourceWithCountryId(imf, countriesTable);
        wefe = ce.getSourceWithCountryId(wefe, countriesTable);
        wdd = ce.getSourceWithCountryId(wdd, countriesTable);
        wefd = ce.getWEFDWithCountryId(wefd, countriesTable);
        countriesTable = TableOperations.standarizeTable(countriesTable);
        HandlerCountries.changeTextToObjects(countriesTable);

        HandlerIndicators ie = new HandlerIndicators();
        List<List<String>> indicatorsTable = ie.getIndicators(imf, wefm, wdm);
        imf = ie.getIMFWithIndicatorId(imf, indicatorsTable);
        wefd = ie.getWEFDWithIndicatorId(wefd, indicatorsTable);
        wdd = ie.getWDDWithIndicatorId(wdd, indicatorsTable);
        indicatorsTable = TableOperations.standarizeTable(indicatorsTable);

        HandlerVaules ve = new HandlerVaules();
        List<List<String>> valuesTable = ve.getValues(imf, wefd, wefe, wefm, wdd, wdm);

        List<List<String>> resTable = TableOperations.splitByCountry(valuesTable, countriesTable, indicatorsTable);
        List<List<String>> countries = HandlerCountries.usedCountries(countriesTable, resTable);
        List<List<String>> indicators = HandlerIndicators.usedIndicators(indicatorsTable, resTable);

        fl.saveTableToDocument(countriesTable, "\n", "\t", "data/new/country.tsv");
        fl.saveTableToDocument(indicatorsTable, "\n", "\t", "data/new/indicator.tsv");
        fl.saveTableToDocument(valuesTable, "\n", "\t", "data/new/value.tsv");
        fl.saveTableToDocument(resTable, "\n", "\t", "data/new/view-values.tsv");
        fl.saveTableToDocument(countries, "\n", "\t", "data/new/view-countries.tsv");
        fl.saveTableToDocument(indicators, "\n", "\t", "data/new/view-indicators.tsv");
    }
}
