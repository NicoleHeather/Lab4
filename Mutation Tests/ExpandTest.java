package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ExpandTest {

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
     * This test covers an expansion for both boundaries for the expand() method using the exampleRange
     */
   /* @Test
    public void testFullExpansionForMethodExpand() {
        Range expectedRange = new Range(-3, 3);
        assertEquals("The expected range should be {-3,3}", expectedRange, Range.expand(exampleRange, 1, 1));
    }
    */
    
    /**
     * This test covers an expansion for the upper boundary for the expand() method using the exampleRange
     */
    /*@Test
    public void testUpperExpansionForMethodExpand() {
        Range expectedRange = new Range(-1, 3);
        assertEquals("The expected range should be {-1,3}", expectedRange, Range.expand(exampleRange, 0, 1));
    }
    */
    
    /**
     * This test covers a negative expansion for the upper boundary for the expand() method using the exampleRange
     */
   /* @Test
    public void testNegativeUpperBoundaryExpansionForMethodExpand() {
        Range expectedRange = new Range(-2, -2);
        assertEquals("The expected range should be {-2,-2}", expectedRange, Range.expand(exampleRange, 0, -2));
    }
    */

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}