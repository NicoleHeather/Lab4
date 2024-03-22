package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class CombineIgnoringNanTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Creating first example range, this object will be reused for convenience.
        exampleRange = new Range(5, 20);
    }
    
    /**
     * This test covers two valid ranges for the combineIgnoringNaN() method
     */
    @Test
    public void testValidRangesForMethodCombineIgnoringNaN() {
        Range rangeOne = new Range(-1, 1);
        Range rangeTwo = new Range(-2, 2);
        Range expectedRange = new Range(-2, 2);
        assertEquals("The expected range should be {-1,2}", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
     * This test covers a null first range and valid second range for the combineIgnoringNaN() method
     */
    @Test
    public void testNullRangeOneValidRangeTwoForMethodCombineIgnoringNAN() {
        Range rangeOne = null;
        Range rangeTwo = new Range(-2, 2);
        Range expectedRange = rangeTwo;
        assertEquals("The expected range should be {-1,2}", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
     * This test covers a valid first range and NaN second range for the combineIgnoringNaN() method
     */
    @Test
    public void testValidRangeOneNaNRangeTwoForMethodCombineIgnoringNAN() {
        Range rangeOne = new Range(-1, 1);
        Range rangeTwo = new Range(Double.NaN, Double.NaN);
        Range expectedRange = rangeOne;
        assertEquals("The expected value should be null", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
     * This test covers a valid first range and null second range for the combineIgnoringNaN() method
     */
    @Test
    public void testValidRangeOneNullRangeTwoForMethodCombineIgnoringNAN() {
        Range rangeOne = new Range(-1, 1);
        Range rangeTwo = null;
        Range expectedRange = rangeOne;
        assertEquals("The expected range should be {-1,1}", expectedRange, Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
     * This test covers a null first range and valid NaN range for the combineIgnoringNaN() method
     */
    @Test
    public void testNullRangeOneNaNRangeTwoForMethodCombineIgnoringNAN() {
        Range rangeOne = null;
        Range rangeTwo = new Range(Double.NaN, Double.NaN);
        assertNull("The expected value should be null", Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
     * This test covers a NaN first range and null second range for the combineIgnoringNaN() method
     */
    @Test
    public void testNaNRangeOneNullRangeTwoForMethodCombineIgnoringNAN() {
        Range rangeOne = new Range(Double.NaN, Double.NaN);
        Range rangeTwo = null;
        assertNull("The expected value should be null", Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }
    
    /**
     * This test covers a NaN first range and NaN second range for the combineIgnoringNaN() method
     */
    @Test
    public void testNaNBothRangesForMethodCombineIgnoringNAN() {
        Range rangeOne = new Range(Double.NaN, Double.NaN);
        Range rangeTwo = new Range(Double.NaN, Double.NaN);
        assertNull("The expected value should be null", Range.combineIgnoringNaN(rangeOne, rangeTwo));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}