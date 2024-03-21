package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ContainsTest {

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
    public void contains_DoesContain() {
        assertTrue("contains() cannot correctly identify valid range", exampleRange.contains(7.8));
    }
    
    /**
     * This test covers to see if the system can identify a invalid value above its range
     */
    @Test
    public void contains_ValueGreaterThan() {
        assertFalse("contains() cannot correctly identify a value to large for the range", exampleRange.contains(909));
    }
    
    /**
     * This test covers to see if the system can identify a invalid value below its range
     */
    @Test
    public void contains_ValueLessThan() {
        assertFalse("contains() cannot correctly identify a value to small for the range", exampleRange.contains(-11));
    }

    /**
     * This test covers to see if the system can identify a valid value that equal lower
     */
    @Test
    public void contains_EqualsLower() {
        assertTrue("contains() cannot correctly identify a value equal to lower", exampleRange.contains(5));
    }
    
 
    /**
     * This test covers to see if the system can identify a valid value that equal upper
     */
    @Test
    public void contains_EqualsUpper() {
        assertTrue("contains() cannot correctly identify a value equal to upper", exampleRange.contains(20));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
