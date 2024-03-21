package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ExpandToIncludeTest {

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
     * This test covers a null input range for the expandToInclude() method
     */
    @Test
    public void testNullRangeForMethodExpandToInclude() {
        exampleRange = null;
        Range expectedRange = new Range(25, 25);
        assertEquals("The expected range should be {25,25}", expectedRange, Range.expandToInclude(null, 25));
    }
    
    /**
     * This test covers a below lower boundary value for the expandToInclude() method using the exampleRange
     */
    /*@Test
    public void testLowerExpansionForMethodExpandToInclude() {
        Range expectedRange = new Range(-5, 1);
        assertEquals("The expected range should be {-5,1}", expectedRange, Range.expandToInclude(exampleRange, -5));
    }
    */
    
    /**
     * This test covers an above upper boundary value for the expandToInclude() method using the exampleRange
     */
    /*@Test
    public void testUpperExpansionForMethodExpandToInclude() {
        Range expectedRange = new Range(-1, 5);
        assertEquals("The expected range should be {-1,5}", expectedRange, Range.expandToInclude(exampleRange, 5));
    }
    */

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}