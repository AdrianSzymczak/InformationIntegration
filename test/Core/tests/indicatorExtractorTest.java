package Core.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utils.FileHandler;
import Handlers.HandlerIndicators;
import Handlers.HandlerCountries;
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
public class indicatorExtractorTest {

    public indicatorExtractorTest() {
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
    public void testIndicatorTableID() throws Exception {
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

        HandlerIndicators ie = new HandlerIndicators();
        List<List<String>> indicatorTable = ie.getIndicators(imf, wefm, wdm);

        assertEquals(indicatorTable.get(11).get(0), "12");
        assertEquals(indicatorTable.get(11).get(1), "SI.POV.DDAY");
        assertEquals(indicatorTable.get(11).get(2), "Poverty headcount ratio at $1.90 a day is the percentage of the population living on less than $1.90 a day at 2011 international prices. As a result of revisions in PPP exchange rates  poverty rates for individual countries cannot be compared with poverty rates reported in earlier editions. Note: five countries -- Bangladesh  Cabo Verde  Cambodia  Jordan  and Lao PDR -- use the 2005 PPP conversion factors and corresponding $1.25 a day and $2 a day poverty lines. This is due to the large deviations in the rate of change in PPP factors relative to the rate of change in domestic consumer price indexes. See Box 1.1 in the Global Monitoring Report 2015/2016 (http://www.worldbank.org/en/publication/global-monitoring-report) for a detailed explanation.");

    }

    @Test
    public void testIndicatorIDIMF() throws Exception {
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

        HandlerIndicators ie = new HandlerIndicators();
        List<List<String>> indicatorsTable = ie.getIndicators(imf, wefm, wdm);
        imf = ie.getIMFWithIndicatorId(imf, indicatorsTable);
        wefm = ie.getWEFDWithIndicatorId(wefe, indicatorsTable);
        wdm = ie.getWDDWithIndicatorId(wdd, indicatorsTable);

        assertEquals(imf.get(0).get(4), "Annual percentages of constant price GDP are year-on-year changes; the base year is country-specific . Expenditure-based GDP is total final expenditures at purchasers? prices (including the f.o.b. value of exports of goods and services), less the f.o.b. value of imports of goods and services. [SNA 1993]");
        assertEquals(imf.get(0).get(3), "4556");

    }

    @Test
    public void testIndicatorTableLength() throws Exception {
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

        HandlerIndicators ie = new HandlerIndicators();
        List<List<String>> indicatorsTable = ie.getIndicators(imf, wefm, wdm);
        
        int firstRowSize = indicatorsTable.get(0).size();
        for (int i = 1; i < indicatorsTable.size(); i++) {
            List<String> rowReaded = indicatorsTable.get(i);
            assertEquals(firstRowSize, rowReaded.size());
        }

    }
}
