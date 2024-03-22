package org.jfree.data.tests;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class intersectsTest {
	
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	//Creating first example range, this object will be reused for convenience. 
    	exampleRange = new Range(0.1, 5.0);
    }

    //This test covers if getCentralValue returns the correct value if lower and upper are positive values, both are legal Range values. 
    @Test
    public void testIntersectsB0EqualsLowerBoundB1BiggerThanLowerBound() {
        // Arrange

        // Act & Assert
        assertTrue(exampleRange.intersects(0.1, 3.0));
    }
    
   /* @Test
    public void testIntersectsB0EqualsLowerBoundB1LessThanLowerBound() {
        // Arrange

        // Act & Assert
        assertTrue(exampleRange.intersects(0.1, 0.05));
    }
   */
   
    @Test
    public void testIntersectsB1BiggerThanLowerBound() {
        // Arrange

        // Act & Assert
        assertFalse(exampleRange.intersects(0.2, 0.05));
    }
    
    @Test
    public void testIntersectsB0LowerThanUpperAndB1isEqualB0() {
        // Arrange

        // Act & Assert
        assertTrue(exampleRange.intersects(0.2, 0.2));
    }
    @Test
    public void testIntersectsB0LowerThanUpperAndB1isLessThanB0() {
        // Arrange

        // Act & Assert
        assertFalse(exampleRange.intersects(0.2, 0.1));
    }
   
    @Test
    public void testIntersectsB0BiggerThanUpperAndB1isLessThanB0() {
        // Arrange

        // Act & Assert
        assertFalse(exampleRange.intersects(6.0, 0.1));
    }
    @Test
    public void testIntersectsB0BiggerThanUpperAndB1isBiggerThanB0() {
        // Arrange

        // Act & Assert
        assertFalse(exampleRange.intersects(6.0, 0.7));
    }
   
   
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}