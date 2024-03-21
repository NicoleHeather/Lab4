package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ConstrainTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
	@Test
    public void constrainNormalValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(9.98) == 9.98);
    }
	
	@Test
    public void constrainReturnLowerValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(-10) == -5);
    }
	
	@Test
    public void constrainReturnUpperValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(800) == 25);
    }
	
	@Test
    public void constrainReturnEqualLowerValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(-5) == -5);
    }
	
	@Test
    public void constrainReturnEqualUpperValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(25) == 25);
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}