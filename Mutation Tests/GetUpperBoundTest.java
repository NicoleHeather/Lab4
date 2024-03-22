package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class GetUpperBoundTest {
    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Creating first example range, this object will be reused for convenience.
        exampleRange = new Range(10.93, 15.77);
    }

    @Test
    public void getUpperBound_PositiveRange_Decimal() {
        assertEquals("The upper bound should be 15.77", 15.77, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_NegativeRange_Decimal() {
        exampleRange = new Range(-15.77, -10.93);
        assertEquals("The upper bound should be -10.93", -10.93, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_OppositeRange_Decimal() {
        exampleRange = new Range(-5.48, 20.25);
        assertEquals("The upper bound should be 20.25", 20.25, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_ZeroPositiveRange_Decimal() {
        exampleRange = new Range(0, 35.79);
        assertEquals("The upper bound should be 35.79", 35.79, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_ZeroNegativeRange_Decimal() {
        exampleRange = new Range(-35.79, 0);
        assertEquals("The upper bound should be 0", 0, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_EqualNegative_Decimal() {
        exampleRange = new Range(-13.023, -13.023);
        assertEquals("The upper bound should be -13.023", -13.023, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_EqualPositive_Decimal() {
        exampleRange = new Range(13.023, 13.023);
        assertEquals("The upper bound should be 13.023", 13.023, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_LargeRange_Decimal() {
        exampleRange = new Range(-99999.8888, 88888.9999);
        assertEquals("The upper bound should be 88888.9999", 88888.9999, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_SmallRange_Decimal() {
        exampleRange = new Range(1.00000567, 1.00000568);
        assertEquals("The upper bound should be 1.00000568", 1.00000568, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBound_BothZero() {
        exampleRange = new Range(0, 0);
        assertEquals("The upper bound should be 0", 0, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBound_PositiveRange() {
        exampleRange = new Range(5, 10);
        assertEquals("The upper bound should be 10", 10, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_NegativeRange() {
        exampleRange = new Range(-10, -5);
        assertEquals("The upper bound should be -5", -5, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_OppositeRange() {
        exampleRange = new Range(-10, 10);
        assertEquals("The upper bound should be 10", 10, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_ZeroPositiveRange() {
        exampleRange = new Range(0, 7);
        assertEquals("The upper bound should be 7", 7, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_ZeroNegativeRange() {
        exampleRange = new Range(-7, 0);
        assertEquals("The upper bound should be 0", 0, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_EqualNegative() {
        exampleRange = new Range(-10, -10);
        assertEquals("The upper bound should be -10", -10, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_EqualPositive() {
        exampleRange = new Range(10, 10);
        assertEquals("The upper bound should be 10", 10, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_LargeRange() {
        exampleRange = new Range(2, 859746);
        assertEquals("The upper bound should be 859746", 859746, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBound_SmallRange() {
        exampleRange = new Range(17, 19);
        assertEquals("The upper bound should be 19", 19, exampleRange.getUpperBound(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}