package org.jfree.data.tests;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.Values2D;
import org.jfree.data.DataUtilities;

public class MutationTest {
 
    @Test(expected = IllegalArgumentException.class)
    public void testClone_NullSourceArray_ThrowsIllegalArgumentException() {
        DataUtilities.clone(null);
    }/* mutations:
    102 1
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray_NullData_ThrowsIllegalArgumentException() {
        DataUtilities.createNumberArray(null);
    }

    @Test
    public void testCreateNumberArray2D_EmptyData_ReturnsEmptyArray() {
        double[][] data = new double[0][0];
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertEquals(0, result.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentages_NullData_ThrowsIllegalArgumentException() {
        DataUtilities.getCumulativePercentages(null);
    }
     
    @Test
    public void testGetLowerBound() {
        Range range = new Range(0.0, 10.0);
        assertEquals(0.0, range.getLowerBound(), 0.0001);
    }

    @Test
    public void testGetUpperBound() {
        Range range = new Range(0.0, 10.0);
        assertEquals(10.0, range.getUpperBound(), 0.0001);
    }

    @Test
    public void testGetLength() {
        Range range = new Range(0.0, 10.0);
        assertEquals(10.0, range.getLength(), 0.0001);
    }

    @Test
    public void testGetCentralValue() {
        Range range = new Range(0.0, 10.0);
        assertEquals(5.0, range.getCentralValue(), 0.0001);
    }

    @Test
    public void testContains() {
        Range range = new Range(0.0, 10.0);
        assertTrue(range.contains(5.0));
        assertFalse(range.contains(15.0));
    }

    @Test
    public void testIntersects() {
        Range range = new Range(0.0, 10.0);
        assertTrue(range.intersects(5.0, 15.0));
        assertFalse(range.intersects(15.0, 20.0));
    }

    @Test
    public void testCombine() {
        Range range1 = new Range(0.0, 10.0);
        Range range2 = new Range(5.0, 15.0);
        Range combinedRange = Range.combine(range1, range2);
        assertEquals(0.0, combinedRange.getLowerBound(), 0.0001);
        assertEquals(15.0, combinedRange.getUpperBound(), 0.0001);
    }

    @Test
    public void testExpandToInclude() {
        Range range = new Range(0.0, 10.0);
        Range expandedRange = Range.expandToInclude(range, 15.0);
        assertEquals(0.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals(15.0, expandedRange.getUpperBound(), 0.0001);
    } /* mutations: 
    305 2
    308 2
    309 1 */
    

    @Test
    public void testExpand() {
        Range range = new Range(0.0, 10.0);
        Range expandedRange = Range.expand(range, 0.1, 0.1);
        assertEquals(-1.0, expandedRange.getLowerBound(), 0.0001);
        assertEquals(11.0, expandedRange.getUpperBound(), 0.0001);
    } /* mutations:
    331 1 + 2
    332 1 + 2
    333 2
    337 1 */
    
    @Test
    public void testShift() {
        Range range = new Range(0.0, 10.0);
        Range shiftedRange = Range.shift(range, 5.0);
        assertEquals(5.0, shiftedRange.getLowerBound(), 0.0001);
        assertEquals(15.0, shiftedRange.getUpperBound(), 0.0001);
    }
    /* mutations:
     390 1 + 2 */

    @Test
    public void testScale() {
        Range range = new Range(0.0, 10.0);
        Range scaledRange = Range.scale(range, 2.0);
        assertEquals(0.0, scaledRange.getLowerBound(), 0.0001);
        assertEquals(20.0, scaledRange.getUpperBound(), 0.0001);
    }
    
}