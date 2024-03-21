package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ShiftTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
    // covers two branches of no zero crossing and else of shift with bool
    /**
     * This test covers the shift() method using the exampleRange
     */
    @Test
    public void testShift() {
    	Range exampleRange = new Range(-1, 1);
        Range testRange = new Range(-1.5, 0.5);
        assertEquals("Did not return shifted range", testRange, Range.shift(exampleRange, -0.5));
    }

    /**
     * This test covers the shift() method using the exampleRange with a
     * shift with boolean
     */
    @Test
    public void testFirstBranchShiftWithBool() {
    	Range exampleRange = new Range(-1, 1);
        Range testRange = new Range(-1.5, 0.5);
        assertEquals("Did not return shifted range", testRange, Range.shift(exampleRange, -0.5, true));
    }

    /**
     * This test covers the shift() method using the exampleRange for the
     * else branch for shift with no zero crossing
     */
    @Test
    public void testElseBranchShiftWithNoZeroCrossing() {
        Range specialRange = new Range(0.0, 1);
        Range testRange = new Range(-1, 0);
        assertEquals("Did not return shifted range", testRange, Range.shift(specialRange, -1, false));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}