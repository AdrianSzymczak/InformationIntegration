/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.tests;

import helpers.NumberHelper;
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
        assertEquals(NumberHelper.handleFloat(".2"), 0.2, 0.001);
    }

    @Test
    public void test1() {
        assertTrue(NumberHelper.isNumber("-143.010"));
        assertEquals(NumberHelper.handleFloat("-143.010"), -143.010, 0.001);
    }

    @Test
    public void test2() {
        assertTrue(NumberHelper.isNumber("343,100.370"));
        assertEquals(NumberHelper.handleFloat("343,100.370"), 343100.370, 0.001);
    }

    @Test
    public void test3() {
        assertTrue(NumberHelper.isNumber("0.057"));
        assertEquals(NumberHelper.handleFloat("0.057"), 0.057, 0.001);
    }

    @Test
    public void test4() {
        assertTrue(!NumberHelper.isNumber("n/a"));
        assertNull(NumberHelper.handleFloat("n/a"));
    }

    @Test
    public void test5() {
        assertTrue(!NumberHelper.isNumber(""));
        assertNull(NumberHelper.handleFloat(""));
    }

    @Test
    public void test6() {
        assertTrue(!NumberHelper.isNumber("."));
        assertNull(NumberHelper.handleFloat("."));
    }

    @Test
    public void test7() {
        assertTrue(!NumberHelper.isNumber(".."));
        assertNull(NumberHelper.handleFloat(".."));
    }

    @Test
    public void test8() {
        assertTrue(NumberHelper.isNumber("0"));
        assertEquals(NumberHelper.handleFloat("0"), 0.0, 0.001);
    }

    @Test
    public void test9() {
        assertTrue(NumberHelper.isNumber("144.2"));
        assertEquals(NumberHelper.handleFloat("144.2"), 144.2, 0.001);
    }

    @Test
    public void test10() {
        assertTrue(NumberHelper.isNumber("144,2"));
        assertEquals(NumberHelper.handleFloat("144,2"), 144.2, 0.001);
    }

    @Test
    public void test11() {
        assertTrue(NumberHelper.isNumber("11 144,2"));
        assertEquals(NumberHelper.handleFloat("11 144,2"), 11144.2, 0.001);
    }

    @Test
    public void test12() {
        assertTrue(NumberHelper.isNumber("12.144,2"));
        assertEquals(NumberHelper.handleFloat("12.144,2"), 12144.2, 0.001);
    }

    @Test
    public void test13() {
        assertTrue(NumberHelper.isNumber("12 144.2"));
        assertEquals(NumberHelper.handleFloat("12 144.2"), 12144.2, 0.001);
    }

    @Test
    public void test14() {
        assertTrue(NumberHelper.isNumber("12.144.2"));
        assertEquals(NumberHelper.handleFloat("12.144.2"), 121442, 0.001);
    }

    @Test
    public void test15() {
        assertTrue(NumberHelper.isNumber("12,144,2"));
        assertEquals(NumberHelper.handleFloat("12,144,2"), 121442, 0.001);
    }

    @Test
    public void test16() {
        assertTrue(NumberHelper.isNumber("12 144 2"));
        assertEquals(NumberHelper.handleFloat("12 144 2"), 121442, 0.001);
    }

    @Test
    public void test17() {
        assertEquals(NumberHelper.handleFloat("2.2e+05"), 220000.0, 0.001);
    }

    @Test
    public void test18() {
        assertEquals(NumberHelper.handleFloat("2.2E-05"), 0.000022, 0.001);
    }

    @Test
    public void test19() {
        assertEquals(NumberHelper.handleFloat("2.2e-10"), 0.00000000022, 0.001);
    }

    @Test
    public void test20() {
        assertEquals(NumberHelper.handleFloat("2.2E+10"), 22000000000.0, 0.001);
    }
}
