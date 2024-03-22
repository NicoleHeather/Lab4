package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class GetCentralValueTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Creating first example range, this object will be reused for convenience.
        exampleRange = new Range(10.93, 15.77);
    }

    // This test covers if getCentralValue returns the correct value if lower and upper are positive values, both are legal Range values.
    @Test
    public void getCentralValue_PositiveRange_Decimal() {
        // Validation.
        assertEquals("The central value should be 13.35", 13.35, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower and upper are negative values, both are legal inputs.
    @Test
    public void getCentralValue_NegativeRange_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-15.77, -10.93);
        // Validation.
        assertEquals("The central value should be -13.35", -13.35, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower is negative and upper is positive, both are legal inputs.
    @Test
    public void getCentralValue_OppositeRange_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-5.48, 20.25);
        // Validation.
        assertEquals("The central value should be 7.385", 7.385, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower is 0 and upper is positive, both are legal inputs.
    @Test
    public void getCentralValue_ZeroPositiveRange_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(0, 35.79);
        // Validation.
        assertEquals("The central value should be 17.895", 17.895, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower is negative and upper is 0, both are legal inputs.
    @Test
    public void getCentralValue_ZeroNegativeRange_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-35.79, 0);
        // Validation.
        assertEquals("The central value should be -17.895", -17.895, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower and upper are equal negative values, both are legal inputs.
    @Test
    public void getCentralValue_EqualNegative_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-13.023, -13.023);
        // Validation.
        assertEquals("The central value should be -13.023", -13.023, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower and upper are equal positive values, both are legal inputs.
    @Test
    public void getCentralValue_EqualPositive_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(13.023, 13.023);
        // Validation.
        assertEquals("The central value should be 13.023", 13.023, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower is a large negative value and upper is a large positive value, both are legal inputs.
    @Test
    public void getCentralValue_LargeRange_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-99999.8888, 88888.9999);
        // Validation.
        assertEquals("The central value should be -5555.44445", -5555.44445, exampleRange.getCentralValue(), .000000001d);
    }

    // This test covers if getCentralValue returns the correct value if lower is a small positive value and upper is a small positive value, both are legal inputs.
    @Test
    public void getCentralValue_SmallRange_Decimal() {
        // Setting new values for lower and upper.
        exampleRange = new Range(1.00000567, 1.00000568);
        // Validation.
        assertEquals("The central value should be 1.000005675", 1.000005675, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValue_BothZero() {
        // Setting new values for lower and upper.
        exampleRange = new Range(0, 0);
        // Validation.
        assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValue_PositiveRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(5, 10);
        // Validation.
        assertEquals("The central value should be 7.5", 7.5, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValue_NegativeRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-10, -5);
        // Validation.
        assertEquals("The central value should be -7.5", -7.5, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValue_OppositeRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-10, 10);
        // Validation.
        assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValue_ZeroPositiveRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(0, 7);
        // Validation.
        assertEquals("The central value should be 3.5", 3.5, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValue_ZeroNegativeRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-7, 0);
        // Validation.
        assertEquals("The central value should be -3.5", -3.5, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValue_EqualNegative() {
        // Setting new values for lower and upper.
        exampleRange = new Range(-10, -10);
        // Validation.
        assertEquals("The central value should be -10", -10, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValue_EqualPositive() {
        // Setting new values for lower and upper.
        exampleRange = new Range(10, 10);
        // Validation.
        assertEquals("The central value should be 10", 10, exampleRange.getCentralValue(), .000000001d);
    }

    /*@Test
    public void getCentralValue_LargeRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(2, 859746);
        // Validation.
        assertEquals("The central value should be 429874.5", 429874.5, exampleRange.getCentralValue(), .000000001d);
    }
    */

    @Test
    public void getCentralValue_SmallRange() {
        // Setting new values for lower and upper.
        exampleRange = new Range(17, 19);
        // Validation.
        assertEquals("The central value should be 18", 18, exampleRange.getCentralValue(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}