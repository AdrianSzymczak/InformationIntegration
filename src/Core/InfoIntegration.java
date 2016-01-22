/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class InfoIntegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        FileHandler fl = new FileHandler();

        List<List<String>> imf = fl.loadStringToTable(fl.loadDocument("/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/IMF-data.tsv"), "\n", "\t");
        List<List<String>> wefd = fl.loadStringToTable(fl.loadDocument("/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/WEF-data.tsv"), "\n", "\t");
        List<List<String>> wefe = fl.loadStringToTable(fl.loadDocument("/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/WEF-entities.tsv"), "\n", "\t");
        List<List<String>> wefm = fl.loadStringToTable(fl.loadDocument("/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/WEF-metadata.tsv"), "\n", "\t");
        List<List<String>> wdm = fl.loadStringToTable(fl.loadDocument("/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/WD-metadata.tsv"), "\n", "\t");
        List<List<String>> wdd = fl.loadStringToTable(fl.loadDocument("/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/WD-data.csv"), "\n", ";");

        countryExtractor ce = new countryExtractor();
        List<List<String>> countriesTable = ce.getCountries(imf, wefe, wdd);
        imf= ce.getSourceWithCountryId(imf,countriesTable);
        wefe= ce.getSourceWithCountryId(wefe,countriesTable);
        wdd= ce.getSourceWithCountryId(wdd,countriesTable);
        
        indicatorExtractor ie = new indicatorExtractor();
        List<List<String>> indicatorsTable = ie.getIndicators(imf, wefm, wdm);
        imf= ie.getIMFWithIndicatorId(imf,indicatorsTable);
        wefm= ie.getWEFMWithIndicatorId(wefe,indicatorsTable);
        wdm= ie.getWDMWithIndicatorId(wdd,indicatorsTable);
        
        valueExtractor ve = new valueExtractor();
        List<List<String>> valuesTable = ve.getValues(imf, wefd, wefe, wefm, wdd,wdm);
        
       
        
        fl.saveTableToDocument(imf, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/imf.tsv");
        fl.saveTableToDocument(wefd, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/wefd.tsv");
        fl.saveTableToDocument(wefe, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/wefe.tsv");
        fl.saveTableToDocument(wefm, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/wefm.tsv");
        fl.saveTableToDocument(wdm, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/wdm.tsv");
        fl.saveTableToDocument(wdd, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/wdd.tsv");
        fl.saveTableToDocument(countriesTable, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/country.tsv");
        fl.saveTableToDocument(indicatorsTable, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/indicator.tsv");
        fl.saveTableToDocument(valuesTable, "\n\r", "\t", "/home/facu/NetBeansProjects/InformationIntegration/InformationIntegration/data/new/value.tsv");
    }
}
