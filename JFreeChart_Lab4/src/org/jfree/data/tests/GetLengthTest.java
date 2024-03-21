package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class GetLengthTest {
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
    public void getLength_PositiveRange_Decimal() {
        assertEquals("The length should be 4.84", 4.84, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_NegativeRange_Decimal() {
        exampleRange = new Range(-15.77, -10.93);
        assertEquals("The length should be 4.84", 4.84, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_OppositeRange_Decimal() {
        exampleRange = new Range(-5.48, 20.25);
        assertEquals("The length should be 25.73", 25.73, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_ZeroPositiveRange_Decimal() {
        exampleRange = new Range(0, 35.79);
        assertEquals("The length should be 35.79", 35.79, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_ZeroNegativeRange_Decimal() {
        exampleRange = new Range(-35.79, 0);
        assertEquals("The length should be 35.79", 35.79, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_EqualNegative_Decimal() {
        exampleRange = new Range(-13.023, -13.023);
        assertEquals("The length should be 0", 0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_EqualPositive_Decimal() {
        exampleRange = new Range(13.023, 13.023);
        assertEquals("The length should be 0", 0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_LargeRange_Decimal() {
        exampleRange = new Range(-99999.8888, 88888.9999);
        assertEquals("The length should be 188888.8887", 188888.8887, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_SmallRange_Decimal() {
        exampleRange = new Range(1.00000567, 1.00000568);
        assertEquals("The length should be 0.00000001", 0.00000001, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_BothZero() {
        exampleRange = new Range(0, 0);
        assertEquals("The length should be 0", 0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_PositiveRange() {
        assertEquals("The length should be 4.84", 4.84, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_NegativeRange() {
        exampleRange = new Range(-10, -5);
        assertEquals("The length should be 5", 5, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_OppositeRange() {
        exampleRange = new Range(-10, 10);
        assertEquals("The length should be 20", 20, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_ZeroPositiveRange() {
        exampleRange = new Range(0, 7);
        assertEquals("The length should be 7", 7, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_ZeroNegativeRange() {
        exampleRange = new Range(-7, 0);
        assertEquals("The length should be 7", 7, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_EqualNegative() {
        exampleRange = new Range(-10, -10);
        assertEquals("The length should be 0", 0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_EqualPositive() {
        exampleRange = new Range(10, 10);
        assertEquals("The length should be 0", 0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_LargeRange() {
        exampleRange = new Range(2, 859746);
        assertEquals("The length should be 859744", 859744, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLength_SmallRange() {
        exampleRange = new Range(17, 19);
        assertEquals("The length should be 2", 2, exampleRange.getLength(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}