/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.tests;

import Core.FileHandler;
import helpers.NumberHelper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian
 */
public class NumberHelperJUnitTest {

    public NumberHelperJUnitTest() {
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
    public void test0() {
        assertTrue(NumberHelper.isNumber(".2"));
        assertEquals(NumberHelper.parseDouble(".2"), 0.2, 0.001);
    }

    @Test
    public void test1() {
        assertTrue(NumberHelper.isNumber("-143.010"));
        assertEquals(NumberHelper.parseDouble("-143.010"), -143.010, 0.001);
    }

    @Test
    public void test2() {
        assertTrue(NumberHelper.isNumber("343,100.370"));
        assertEquals(NumberHelper.parseDouble("343,100.370"), 343100.370, 0.001);
    }

    @Test
    public void test3() {
        assertTrue(NumberHelper.isNumber("0.057"));
        assertEquals(NumberHelper.parseDouble("0.057"), 0.057, 0.001);
    }

    @Test
    public void test4() {
        assertTrue(!NumberHelper.isNumber("n/a"));
        assertNull(NumberHelper.parseDouble("n/a"));
    }

    @Test
    public void test5() {
        assertTrue(!NumberHelper.isNumber(""));
        assertNull(NumberHelper.parseDouble(""));
    }

    @Test
    public void test6() {
        assertTrue(!NumberHelper.isNumber("."));
        assertNull(NumberHelper.parseDouble("."));
    }

    @Test
    public void test7() {
        assertTrue(!NumberHelper.isNumber(".."));
        assertNull(NumberHelper.parseDouble(".."));
    }

    @Test
    public void test8() {
        assertTrue(NumberHelper.isNumber("0"));
        assertEquals(NumberHelper.parseDouble("0"), 0.0, 0.001);
    }

    @Test
    public void test9() {
        assertTrue(NumberHelper.isNumber("144.2"));
        assertEquals(NumberHelper.parseDouble("144.2"), 144.2, 0.001);
    }

    @Test
    public void test10() {
        assertTrue(NumberHelper.isNumber("144,2"));
        assertEquals(NumberHelper.parseDouble("144,2"), 144.2, 0.001);
    }

    @Test
    public void test11() {
        assertTrue(NumberHelper.isNumber("11 144,2"));
        assertEquals(NumberHelper.parseDouble("11 144,2"), 11144.2, 0.001);
    }

    @Test
    public void test12() {
        assertTrue(NumberHelper.isNumber("12.144,2"));
        assertEquals(NumberHelper.parseDouble("12.144,2"), 12144.2, 0.001);
    }

    @Test
    public void test13() {
        assertTrue(NumberHelper.isNumber("12 144.2"));
        assertEquals(NumberHelper.parseDouble("12 144.2"), 12144.2, 0.001);
    }

    @Test
    public void test14() {
        assertTrue(NumberHelper.isNumber("12.144.2"));
        assertEquals(NumberHelper.parseDouble("12.144.2"), 121442, 0.001);
    }

    @Test
    public void test15() {
        assertTrue(NumberHelper.isNumber("12,144,2"));
        assertEquals(NumberHelper.parseDouble("12,144,2"), 121442, 0.001);
    }

    @Test
    public void test16() {
        assertTrue(NumberHelper.isNumber("12 144 2"));
        assertEquals(NumberHelper.parseDouble("12 144 2"), 121442, 0.001);
    }

    @Test
    public void test17() {
        assertTrue(NumberHelper.isNumber("2.2"));
        assertTrue(NumberHelper.isNumber("05"));
        assertEquals(NumberHelper.parseDouble("2.2e+05"), 220000.0, 0.001);
    }

    @Test
    public void test18() {
        assertTrue(NumberHelper.isNumber("2.2"));
        assertTrue(NumberHelper.isNumber("05"));
        assertEquals(NumberHelper.parseDouble("2.2E-05"), 0.000022, 0.001);
    }

    @Test
    public void test19() {
        assertTrue(NumberHelper.isNumber("10"));
        assertTrue(NumberHelper.isNumber("2.2"));
        assertEquals(NumberHelper.parseDouble("2.2e-10"), 0.00000000022, 0.001);
    }

    @Test
    public void test20() {
        assertTrue(NumberHelper.isNumber("10"));
        assertTrue(NumberHelper.isNumber("2.2"));
        assertEquals(NumberHelper.parseDouble("2.2E+10"), 22000000000.0, 0.001);
    }

    @Test
    public void test21() {
        assertTrue(NumberHelper.isNumber("4,7706186"));
        assertEquals(NumberHelper.parseDouble("4,7706186"), 4.7706186, 0.001);
    }

    @Test
    public void test22() {
        assertTrue(NumberHelper.isNumber("5339189000"));
        assertEquals(NumberHelper.parseDouble("5339189000"), 5339189000.0, 0.001);
    }

    @Test
    public void test23() {
        assertTrue(NumberHelper.isNumber("4,816575151"));
        assertEquals(NumberHelper.parseDouble("4,816575151"), 4.816575151, 0.001);
    }

    @Test
    public void test24() {
        assertTrue(NumberHelper.isNumber("4,816,575.151"));
        assertEquals(NumberHelper.parseDouble("4,816,575.151"), 4816575.151, 0.001);
    }

    @Test
    public void test25() {
        assertTrue(NumberHelper.isNumber("4 816 575.151"));
        assertEquals(NumberHelper.parseDouble("4 816 575.151"), 4816575.151, 0.001);
    }

    @Test
    public void test26() {
        assertTrue(NumberHelper.isNumber("4 816 575,151"));
        assertEquals(NumberHelper.parseDouble("4 816 575,151"), 4816575.151, 0.001);
    }

    @Test
    public void test27() {
        assertTrue(NumberHelper.isNumber("4,816,575,151"));
        assertEquals(NumberHelper.parseDouble("4,816,575,151"), 4816575151.0, 0.001);
    }

    @Test
    public void test28() {
        assertTrue(NumberHelper.isNumber("4.816.575.151"));
        assertEquals(NumberHelper.parseDouble("4.816.575.151"), 4816575151.0, 0.001);
    }

    @Test
    public void test29() {
        assertTrue(NumberHelper.isNumber("4,816575151"));
        assertEquals(NumberHelper.parseDouble("4,816575151"), 4.816575151, 0.000001);
    }

    @Test
    public void test30() {
        assertTrue(NumberHelper.isNumber("4,816575151\r"));
        assertEquals(NumberHelper.parseDouble("4,816575151\r"), 4.816575151, 0.000001);
    }
    
    @Test
    public void test31() {
        assertTrue(NumberHelper.isNumber("4,816575151\n"));
        assertEquals(NumberHelper.parseDouble("4,816575151\n"), 4.816575151, 0.000001);
    }
    
    
    public static int nulls = 0;
    public static int errors = 0;
    public static int total = 0;

    public Set<String> testArray(List<List<String>> temparray) throws Exception {
        Set<String> nullsSoFar = new HashSet<>();
        for (int i = 0; i < temparray.size(); i++) {
            for (int j = 0; j < temparray.get(0).size(); j++) {
                try {
                    String d = temparray.get(i).get(j);
                    Double k = NumberHelper.parseDouble(d);
                    if (k == null) {
                        nullsSoFar.add(d);
                        nulls++;
                    } else {
                        total++;
                    }
                } catch (NumberFormatException ex) {
                    errors++;
                }
            }
        }
        return nullsSoFar;
    }

    @Test
    public void test() throws Exception {
        FileHandler fl = new FileHandler();
        Set<String> nullsSoFar = new HashSet<String>();

        nullsSoFar.addAll(testArray(fl.loadStringToTable(fl.loadDocument("data/IMF-data.tsv"), "\n", "\t")));
        nullsSoFar.addAll(testArray(fl.loadStringToTable(fl.loadDocument("data/WEF-data.tsv"), "\n", "\t")));
        nullsSoFar.addAll(testArray(fl.loadStringToTable(fl.loadDocument("data/WD-data.csv"), "\n", ";")));

        for (String s : nullsSoFar) {
            if (s.length() < 30) {
                System.out.println(s);
            }
        }

        System.out.println(nulls);
        System.out.println(errors);
        System.out.println(total);
    }
}
