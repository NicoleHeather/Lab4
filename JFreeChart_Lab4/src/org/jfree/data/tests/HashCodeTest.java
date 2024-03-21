package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class HashCodeTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
    /**
     * This test covers the hashCode() method using the exampleRange
     */
    @Test
    public void testHashCode() {   
    	exampleRange = new Range(-1, 1);
        assertEquals("The expected hash should be", -31457280, exampleRange.hashCode());
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
