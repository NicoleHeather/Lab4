package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ToStringTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Creating first example range, this object will be reused for convenience.
        exampleRange = new Range(6.7898, 17.6453);
    }

    @Test
    public void toString_PositiveRange() {
        exampleRange = new Range(5, 10);
        assertEquals("The string should be: Range[5.0,10.0]", "Range[5.0,10.0]", exampleRange.toString());
    }

    @Test
    public void toString_NegativeRange() {
        exampleRange = new Range(-10, -5);
        assertEquals("The string should be: Range[-10.0,5.0]", "Range[-10.0,-5.0]", exampleRange.toString());
    }

    @Test
    public void toString_OppositeRange() {
        exampleRange = new Range(-10, 10);
        assertEquals("The string should be: Range[-10.0,10.0]", "Range[-10.0,10.0]", exampleRange.toString());
    }

    @Test
    public void toString_ZeroPositiveRange() {
        exampleRange = new Range(0, 7);
        assertEquals("The string should be: Range[0.0,7.0]", "Range[0.0,7.0]", exampleRange.toString());
    }

    @Test
    public void toString_ZeroNegativeRange() {
        exampleRange = new Range(-7, 0);
        assertEquals("The string should be: Range[-7.0,0.0]", "Range[-7.0,0.0]", exampleRange.toString());
    }

    @Test
    public void toString_BothZero() {
        exampleRange = new Range(0, 0);
        assertEquals("The string should be: Range[0.0,0.0]", "Range[0.0,0.0]", exampleRange.toString());
    }

    @Test
    public void toString_EqualNegative() {
        exampleRange = new Range(-10, -10);
        assertEquals("The string should be: Range[-10.0,-10.0]", "Range[-10.0,-10.0]", exampleRange.toString());
    }

    @Test
    public void toString_EqualPositive() {
        exampleRange = new Range(10, 10);
        assertEquals("The string should be: Range[10.0,10.0]", "Range[10.0,10.0]", exampleRange.toString());
    }

    @Test
    public void toString_LargeRange() {
        exampleRange = new Range(2, 859746);
        assertEquals("The string should be: Range[2.0,859746.0]", "Range[2.0,859746.0]", exampleRange.toString());
    }

    @Test
    public void toString_SmallRange() {
        exampleRange = new Range(17, 19);
        assertEquals("The string should be: Range[17.0,19.0]", "Range[17.0,19.0]", exampleRange.toString());
    }

    @Test
    public void toString_PositiveRange_Decimal() {
        exampleRange = new Range(6.7898, 17.6453);
        assertEquals("The string should be: Range[6.7898,17.6453]", "Range[6.7898,17.6453]", exampleRange.toString());
    }

    @Test
    public void toString_NegativeRange_Decimal() {
        exampleRange = new Range(-17.6453, -6.7898);
        assertEquals("The string should be: Range[-17.6453,-6.7898]", "Range[-17.6453,-6.7898]", exampleRange.toString());
    }

    @Test
    public void toString_OppositeRange_Decimal() {
        exampleRange = new Range(-9.097, 10.3242);
        assertEquals("The string should be: Range[-9.097,10.3242]", "Range[-9.097,10.3242]", exampleRange.toString());
    }

    @Test
    public void toString_ZeroPositiveRange_Decimal() {
        exampleRange = new Range(0, 23.353);
        assertEquals("The string should be: Range[0.0,23.353]", "Range[0.0,23.353]", exampleRange.toString());
    }

    @Test
    public void toString_ZeroNegativeRange_Decimal() {
        exampleRange = new Range(-68.48947, 0);
        assertEquals("The string should be: Range[-68.48947,0.0]", "Range[-68.48947,0.0]", exampleRange.toString());
    }

    @Test
    public void toString_BothZero_Decimal() {
        exampleRange = new Range(0, 0);
        assertEquals("The string should be: Range[0.0,0.0]", "Range[0.0,0.0]", exampleRange.toString());
    }

    @Test
    public void toString_EqualNegative_Decimal() {
        exampleRange = new Range(-34.4334, -34.4334);
        assertEquals("The string should be: Range[-34.4334,-34.4334]", "Range[-34.4334,-34.4334]", exampleRange.toString());
    }

    @Test
    public void toString_EqualPositive_Decimal() {
        exampleRange = new Range(34.4334, 34.4334);
        assertEquals("The string should be: Range[34.4334,34.4334]", "Range[34.4334,34.4334]", exampleRange.toString());
    }

    @Test
    public void toString_LargeRange_Decimal() {
        exampleRange = new Range(-9999.9999, 9999.9999);
        assertEquals("The string should be: Range[-9999.9999,9999.9999]", "Range[-9999.9999,9999.9999]", exampleRange.toString());
    }

    @Test
    public void toString_SmallRange_Decimal() {
        exampleRange = new Range(0.900055, 0.900057);
        assertEquals("The string should be: Range[0.900055,0.900057]", "Range[0.900055,0.900057]", exampleRange.toString());
    }
   
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
