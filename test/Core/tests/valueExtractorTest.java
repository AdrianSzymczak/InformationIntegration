package Core.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Core.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author facu
 */
public class valueExtractorTest {
    
    public valueExtractorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void testValueTableID()throws Exception{
        FileHandler fl = new FileHandler();

        List<List<String>> imf = fl.loadStringToTable(fl.loadDocument("data/IMF-data.tsv"), "\n", "\t");
        List<List<String>> wefd = fl.loadStringToTable(fl.loadDocument("data/WEF-data.tsv"), "\n", "\t");
        List<List<String>> wefe = fl.loadStringToTable(fl.loadDocument("data/WEF-entities.tsv"), "\n", "\t");
        List<List<String>> wefm = fl.loadStringToTable(fl.loadDocument("data/WEF-metadata.tsv"), "\n", "\t");
        List<List<String>> wdm = fl.loadStringToTable(fl.loadDocument("data/WD-metadata.tsv"), "\n", "\t");
        List<List<String>> wdd = fl.loadStringToTable(fl.loadDocument("data/WD-data.csv"), "\n", ";");

        countryExtractor ce = new countryExtractor();
        List<List<String>> countriesTable = ce.getCountries(imf, wefe, wdd);
        imf= ce.getSourceWithCountryId(imf,countriesTable);
        wefe= ce.getSourceWithCountryId(wefe,countriesTable);
        wdd= ce.getSourceWithCountryId(wdd,countriesTable);
        
        indicatorExtractor ie = new indicatorExtractor();
        List<List<String>> indicatorsTable = ie.getIndicators(imf, wefm, wdm);
        imf= ie.getIMFWithIndicatorId(imf,indicatorsTable);
        wefm= ie.getWEFMWithIndicatorId(wefe,indicatorsTable);
        wdd= ie.getWDDWithIndicatorId(wdd,indicatorsTable);
        
        valueExtractor ve = new valueExtractor();
        List<List<String>> valuesTable = ve.getValues(imf, wefd, wefe, wefm, wdd,wdm);

        assertEquals(valuesTable.get(0).get(0),"1");
        assertEquals(valuesTable.get(0).get(1),"141");
        assertEquals(valuesTable.get(0).get(2),"4556");
     }
    
        @Test
        public void testValueTableLength()throws Exception{
        FileHandler fl = new FileHandler();

        List<List<String>> imf = fl.loadStringToTable(fl.loadDocument("data/IMF-data.tsv"), "\n", "\t");
        List<List<String>> wefd = fl.loadStringToTable(fl.loadDocument("data/WEF-data.tsv"), "\n", "\t");
        List<List<String>> wefe = fl.loadStringToTable(fl.loadDocument("data/WEF-entities.tsv"), "\n", "\t");
        List<List<String>> wefm = fl.loadStringToTable(fl.loadDocument("data/WEF-metadata.tsv"), "\n", "\t");
        List<List<String>> wdm = fl.loadStringToTable(fl.loadDocument("data/WD-metadata.tsv"), "\n", "\t");
        List<List<String>> wdd = fl.loadStringToTable(fl.loadDocument("data/WD-data.csv"), "\n", ";");

        countryExtractor ce = new countryExtractor();
        List<List<String>> countriesTable = ce.getCountries(imf, wefe, wdd);
        imf= ce.getSourceWithCountryId(imf,countriesTable);
        wefe= ce.getSourceWithCountryId(wefe,countriesTable);
        wdd= ce.getSourceWithCountryId(wdd,countriesTable);
        
        indicatorExtractor ie = new indicatorExtractor();
        List<List<String>> indicatorsTable = ie.getIndicators(imf, wefm, wdm);
        imf= ie.getIMFWithIndicatorId(imf,indicatorsTable);
        wefm= ie.getWEFMWithIndicatorId(wefe,indicatorsTable);
        wdd= ie.getWDDWithIndicatorId(wdd,indicatorsTable);
        
        valueExtractor ve = new valueExtractor();
        List<List<String>> valuesTable = ve.getValues(imf, wefd, wefe, wefm, wdd,wdm);

        int firstRowSize = valuesTable.get(0).size();
        for(int i = 1; i < valuesTable.size(); i++) {
            List<String> rowReaded= valuesTable.get(i);
            assertEquals(firstRowSize,rowReaded.size());
        }
        

     }
}
