package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ScaleTest {

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
     * This test covers to see if the system can identify a valid value within its range
     */
    @Test
    public void scaleValidFactor() {
        Range exampleRange = new Range(-5, 25);
        Range expected = new Range(-50, 250);
        assertEquals("Returned Range object is incorrect", expected, Range.scale(exampleRange, 10));
    }

    @Test
    public void scaleInvalidFactor() {
        Range exampleRange = new Range(-5, 25);
        Range expected = new Range(-50, 250);
        try {
        	assertEquals("Should throw exception", expected, Range.scale(exampleRange, -10));
        }
        catch(IllegalArgumentException e) {
        	
        }
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
