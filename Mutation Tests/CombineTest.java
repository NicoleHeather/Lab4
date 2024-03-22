package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class CombineTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
	@Test
    public void combineValidRanges() {
        Range range1 = new Range(-5, 25);
        Range range2 = new Range(13, 34);
        Range expected = new Range(-5, 34);
        assertEquals("Returned Range object is incorrect", expected, Range.combine(range1, range2));
    }
	
	@Test
    public void combineNullRange1() {
        Range range2 = new Range(13, 34);
        Range expected = new Range(13, 34);
        assertEquals("Returned Range object is incorrect", expected, Range.combine(null, range2));
    }
	
	@Test
    public void combineNullRange2() {
        Range range1 = new Range(-5, 25);
        Range expected = new Range(-5, 25);
        assertEquals("Returned Range object is incorrect", expected, Range.combine(range1, null));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}