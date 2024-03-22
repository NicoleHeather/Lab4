package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class IntersectsRangeTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Creating first example range, this object will be reused for convenience.
        exampleRange = new Range(5, 20);
    }
    
    @Test
    public void intersects_DoesIntersect() {
    	Range compareRange = new Range(10, 15);
        assertTrue("contains() cannot correctly identify valid intersection", exampleRange.intersects(compareRange));
    }
    
    @Test
    public void intersects_DoesNotIntersect() {
    	Range compareRange = new Range(-1, 0);
        assertFalse("contains() cannot correctly identify invalid intersection", exampleRange.intersects(compareRange));
    }
   
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}