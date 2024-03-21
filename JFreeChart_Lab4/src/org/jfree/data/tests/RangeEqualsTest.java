package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeEqualsTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
    /**
     * This test covers the equals() method using the exampleRange with a
     * valid Range object
     */
    @Test
    public void testValidObjectForMethodEquals() {
        Range exampleRange = new Range(-1, 1);
        assertTrue("The given object should be a valid Range object", exampleRange.equals(exampleRange));
    }
    
    /**
     * This test covers the equals() method using the exampleRange with an
     * invalid object, which is an object not of the type Range
     */
    @Test
    public void testInvalidObjectTypeForMethodEquals() {
        Range exampleRange = new Range(-1, 1);
        Number n = 1;
        assertFalse("The given object should not be a valid Range object", exampleRange.equals(n));
    }
    
    /**
     * This test covers the equals() method using the exampleRange with a
     * test Range with the a different lower boundary and same upper
     * boundary
     */
    @Test
    public void testDifferentLowerBoundForMethodEquals() {
        Range exampleRange = new Range(-1, 1);
        assertFalse("The given object should not be a valid Range object", exampleRange.equals(new Range(-2, 1)));
    }
    
    /**
     * This test covers the equals() method using the exampleRange with a
     * test Range with the same lower boundary and different upper
     * boundary
     */
    @Test
    public void testDifferentUpperBoundForMethodEquals() {
        Range exampleRange = new Range(-1, 1);
        assertFalse("The given object should not be a valid Range object", exampleRange.equals(new Range(-1, 2)));
    }
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}