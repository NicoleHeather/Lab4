package org.jfree.data.tests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	@Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
		 DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	     values.setValue(7.5, 0, 0);
	     values.setValue(2.5, 1, 0);

	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 10.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	//Test for calculating the sum of invalid values (strings)
		/* @Test
		 public void calculateColumnTotalForInvalidValues() {
		     // setup
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue("a"));
		             one(values).getValue(1, 0);
		             will(returnValue("b"));
		         }
		     });
		     try {
		         DataUtilities.calculateColumnTotal(values, 0);
		         fail("Expected InvalidParameterException");
		     } catch (InvalidParameterException e) {
		     
		 } catch (IllegalStateException e) {
	    	 fail("Expected InvalidParameterException (not IllegalStateException)");
	     }
		     
		 }
		 */
	
	 //Test for calculating the sum of three columns
	 @Test
	    public void calculateColumnTotalForThreeValues() {
	        // setup
		 DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	     values.setValue(3.5, 0, 0);
	     values.setValue(2.0, 1, 0);
	     values.setValue(4.5, 2, 0);
	       //use actual method to compare to mock object
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        // verify
	        assertEquals(result, 10.0, 0.0001); 
	    }
	 
	 //Test for calculating column with array containing 0
	 @Test
	    public void calculateColumnTotalWithZeroInput() {
	        // setup
		 	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        // verify
	        assertEquals(0.0, result, 0.0001);
	    }
	 
	//Test for column sum with 7 (several) columns
	 @Test
	    public void calculateColumnTotalWithMultipleColumns() {
	        // setup		 
		 	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	   
	        values.setValue(3.5, 0, 0);
	        values.setValue(2.0, 1, 0);
	        values.setValue(4.5, 2, 0);
	        values.setValue(1.5, 0, 1);
	        values.setValue(2.5, 1, 1);
	        values.setValue(3.5, 2, 1);
	        
	        double result = DataUtilities.calculateColumnTotal(values, 1);

	        // verify
	        assertEquals(7.5, result, 0.0001); 
	    }
	 
	 //Test for calculating sum with missing value in middle of column
	 @Test
	    public void calculateColumnTotalWithMissingValue() {
	        // setup
		 	DefaultKeyedValues2D values = new DefaultKeyedValues2D();

	        // Add values to the instance
	        values.setValue(3.5, 0, 0);
	        values.setValue(null, 1, 0); // Adding null value
	        values.setValue(4.5, 2, 0);
//	        
	        double result = DataUtilities.calculateColumnTotal(values, 0);

	        // verify
	        assertEquals(8.0, result, 0.0001); 
	    }
	 
	 //Test for calculating sum with one column 
	 @Test
	 public void calculateColumnTotalWithOneColumn() {
	     // setup
		 DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	     values.setValue(3.5, 0, 0);
	     values.setValue(2.0, 1, 0);
	     values.setValue(4.5, 2, 0);

	     
	     double result = DataUtilities.calculateColumnTotal(values, 0); 

	     // verify
	     assertEquals(10.0, result, 0.0001); 
	 }
	 
	// New Tests for calculateColumnTotal(Values2D data, int column, int[] validRows)
	    @Test
	    public void testCalculateColumnTotalThreeArgsWithValidInput() {
	    	
	    	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
		     values.addValue(10, 0, 0);
		     values.addValue(6, 1, 0);
		     values.addValue(6, 2, 0);

		    int column = 0;
	        int[] validRows = new int[] {0, 1,2,3,4};

	        double result = DataUtilities.calculateColumnTotal(values, column, validRows);
	        assertEquals(22, result, 0.000001d); 
	        
	    }
	    
	    @Test
	    public void testCalculateColumnTotalThreeArgsWithNullInput() {
	    	
	    	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
		     values.addValue(10, 0, 0);
		     values.addValue(null, 1, 0);
		     values.addValue(6, 2, 0);
			 
		    int column = 0;
	        int[] validRows = new int[] {0, 1,2,3,4};

	        double result = DataUtilities.calculateColumnTotal(values, column, validRows);
	        assertEquals(16, result, 0.000001d); 
	        
	    }
	 
    @Test
    public void CreateNumberArray_validInput() {
       // Valid input, expects non-null array with correct values
       double[] data = { 1.0, 2.5, 3.7 };
       Number[] result = DataUtilities.createNumberArray(data);

       assertNotNull(result); //check array is not null
       assertEquals(data.length, result.length); //check array is correct length
    // Check each index of the array
       for (int i = 0; i < data.length; i++) { // check each index of the array
           if (result[i] != null) {
           	// if not null, check if value matches
               assertEquals("Value at index " + i + " does not match", data[i], result[i].doubleValue(), 0.001);
           } else {
           	// Fail if any element is unexpectedly null
               fail("Element at index " + i + " is unexpectedly null");
           }
       }
    }
    
    /*@Test
    public void CreateNumberArray_nullData() {
   	 //Null not permitted, Expecting an IllegalArgumentException when null is provided
        try {
            DataUtilities.createNumberArray(null);
            fail("Null input should throw InvalidParameterException");
        } catch (InvalidParameterException e) {
            // Expected exception
        } catch (Exception e) {
       	 fail("Null input should threw "+ e +" instead of InvalidParameterException");
        }
    }
    */
	 
   
	 @Test
	 public void CreateNumberArray_emptyArray() {
		// Empty array, expects an empty array result
		 double[] emptyData = {};
	     Number[] result = DataUtilities.createNumberArray(emptyData);
	     assertEquals("Empty array", 0, result.length);
	 }
	 
	 /*@Test
	 public void CreateNumberArray_invalidData() {
	    // Non-double array, expects InvalidParamaterException
		 double[] charData = {'a', 'b','c'};
		 DataUtilities.createNumberArray(charData);
		 
		 try {
	         DataUtilities.createNumberArray(charData);
	         fail("Non-double input should throw InvalidParameterException");
	     } catch (InvalidParameterException e) {
	         // Expected exception
	     }
	 }
	 */
   @Test
   public void CreateNumberArray_validLargeData() {
   	// Valid large data, expecting a non-null result  with correct values
       double[] validLargeData = {1.1e20, 2.5e30,3.0e25, 4.8e18};
       Number[] result = DataUtilities.createNumberArray(validLargeData);

       assertNotNull(result); //check array is not null
       assertEquals(validLargeData.length, result.length); //check array is correct length
       
       for (int i = 0; i < validLargeData.length; i++) { // check each index of the array
           if (result[i] != null) {
           	// if not null, check if value matches
               assertEquals("Value at index " + i + " does not match", validLargeData[i], result[i].doubleValue(), 0.001);
           } else {
           	// Fail if any element is unexpectedly null
               fail("Element at index " + i + " is unexpectedly null");
           }
       }
   }
   
   @Test
   public void CreateNumberArray_validSmallData() {
   	// Valid small data, expecting a non-null result  with correct values
       double[] validSmallData = {1.1e-20, 2.5e-30,3.0e25, 4.8e-18};
       Number[] result = DataUtilities.createNumberArray(validSmallData);

       assertNotNull(result); //check array is not null
       assertEquals(validSmallData.length, result.length); //check array is correct length
       
       for (int i = 0; i < validSmallData.length; i++) { // check each index of the array
           if (result[i] != null) {
           	// if not null, check if value matches
               assertEquals("Value at index " + i + " does not match", validSmallData[i], result[i].doubleValue(), 0.001);
           } else {
           	// Fail if any element is unexpectedly null
               fail("Element at index " + i + " is unexpectedly null");
           }
       }
   }
   
   // createNumberArray2D() tests
   @Test
   public void CreateNumberArray2D_validData() {
   	// Valid 2D data, expecting a non-null result with correct values
       double[][] validData = {{1.1, 2.1}, {3.2, 4.2}};
       Number[][] result = DataUtilitiesTest.createNumberArray2D(validData);
       //check the array is not null
       assertNotNull(result);
       assertEquals(validData.length, result.length);
       // Check each element in the 2D array
       for (int i = 0; i < validData.length; i++) {
           for (int j = 0; j < validData[i].length; j++) {
           	if (result[i][j] != null) {//if array is not null, check if value matches
           		assertEquals(validData[i][j], result[i][j].doubleValue(), 0.001);
           	} else {
           		// Fail if any element is unexpectedly null
                   fail("Element at index " + "["+i+"]"+"["+j +"]"+ " is unexpectedly null");
               }
               
           }
       }
   }

   /*@Test
   public void CreateNumberArray2D_nullData() {
   	//Null not permitted, Expecting an IllegalArgumentException when null is provided
       try {
           DataUtilitiesTest.createNumberArray2D(null);
           fail("Expected InvalidParameterException, but no exception was thrown");
       } catch (InvalidParameterException e) {
           // Expected exception
       } catch (Exception e) {
      	 fail("Null input should threw "+ e +" instead of InvalidParameterException");
       }
   }
   */
   
   @Test
   public void CreateNumberArray2D_emptyData() {
   	// Empty array, expects an empty array result
       double[][] emptyData = {};
       Number[][] result = DataUtilities.createNumberArray2D(emptyData);
       assertEquals("Empty array", 0, result.length);
   }

   /*@Test
   public void CreateNumberArray2D_invalidData() {
   	// Invalid 2D data, expecting an InvalidParameterException
       double[][] invalidData = {{1.0}, {2.0, 3.0}};
       try {
           DataUtilitiesTest.createNumberArray2D(invalidData);
           fail("Expected InvalidParameterException, but no exception was thrown");
       } catch (InvalidParameterException e) {
           // Expected behavior
       }
   }
   */

   @Test
   public void CreateNumberArray2D_validLargeData() {
   	// Valid large 2D data, expecting a non-null result with correct matching values
       double[][] validLargeData = {{1.1e20, 2.5e30},{3.0e25, 4.8e18}};
       Number[][] result = DataUtilities.createNumberArray2D(validLargeData);
       assertNotNull(result); //check array is not null
       assertEquals(validLargeData.length, result.length); //check array is correct length
       
    // Check each element in the 2D array
       for (int i = 0; i < validLargeData.length; i++) { 
           for (int j = 0; j < validLargeData[i].length; j++) {
           	if (result[i][j] != null) {
           		// if not null, check if value matches
           		assertEquals(validLargeData[i][j], result[i][j].doubleValue(), 0.001);
           	} else {
           		// Fail if any element is unexpectedly null
                   fail("Element at index " + "["+i+"]"+"["+j +"]"+ " is unexpectedly null");
               }
               
           }
       }
   }
   
   @Test
   public void CreateNumberArray2D_validSmallData() {
   	// Valid small 2D data, expecting a non-null result with correct matching values
       double[][] validSmallData = {{1.1e-20, 2.5e-30},{3.0e25, 4.8e-18}};
       Number[][] result = DataUtilities.createNumberArray2D(validSmallData);
       assertNotNull(result); //check array is not null
       assertEquals(validSmallData.length, result.length);//check array is correct length
       
    // Check each element in the 2D array
       for (int i = 0; i < validSmallData.length; i++) {
           for (int j = 0; j < validSmallData[i].length; j++) {
           	if (result[i][j] != null) { 
           		// if not null, check if value matches
           		assertEquals(validSmallData[i][j], result[i][j].doubleValue(), 0.001);
           	} else {
           		// Fail if any element is unexpectedly null
                   fail("Element at index " + "["+i+"]"+"["+j +"]"+ " is unexpectedly null");
               }
               
           }
       }
   }
	 
	 //Test for calculating sum of two row values
	 @Test
	    public void calculateRowTotalForTwoValues() {
	        // setup
		 	DefaultKeyedValues2D values = new DefaultKeyedValues2D();

	        // Add values to the instance
	        values.setValue(7.5, 0, 0);
	        values.setValue(2.5, 0, 1);
	        double result = DataUtilities.calculateRowTotal(values, 0);

	        //verify
	        assertEquals(10.0, result, 0.0001);
	    }
	 
	 //Test for sum calculation with invalid input (0)
	 @Test
	    public void calculateRowTotalWithZeroInput() {
	        // setup
		 	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	        double result = DataUtilities.calculateRowTotal(values, 0);
	        // verify result = 0
	        assertEquals(0.0, result, 0.0001);
	    }
	 
	 //Test for sum calculation with an empty value in row
	 @Test
	 public void calculateRowTotalWithEmptyRow() {
	     // setup
		 DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	     values.setValue(null, 0, 1);
	     values.setValue(null, 0, 2);
	     double result = DataUtilities.calculateRowTotal(values, 0); 

	     // verify
	     assertEquals(0.0, result, 0.0001); 
	 }
	 
	 //Test for sum calculation with different types, like ints, doubles, floats
	 @Test
	 public void calculateRowTotalWithDifferentDataTypes() {
	     // setup
		 
		 DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	     values.setValue(3, 0, 0);
	     values.setValue(2.5, 0, 1);
	     values.setValue(4.5f, 0, 2);
	     double result = DataUtilities.calculateRowTotal(values, 0); 

	     // verify
	     assertEquals(10.0, result, 0.0001);
	 }

	 //Test for sum calculation with values for several rows	 
	 @Test
	 public void calculateRowTotalWithMultipleRows() {
	     // setup
	     DefaultKeyedValues2D values = new DefaultKeyedValues2D();

	     // Add values for each row and column
	     values.setValue(3.5, 0, 0);
	     values.setValue(2.0, 0, 1);
	     values.setValue(4.5, 0, 2);

	     values.setValue(1.5, 1, 0);
	     values.setValue(2.5, 1, 1);
	     values.setValue(3.5, 1, 2);

	     values.setValue(0.5, 2, 0);
	     values.setValue(1.0, 2, 1);
	     values.setValue(1.5, 2, 2);
	     double result = DataUtilities.calculateRowTotal(values, 1); 

	     // verify
	     assertEquals(7.5, result, 0.0001); 
	 }
	 
	 //Test for row calculation with one null row value 
	 @Test
	 public void calculateRowTotalWithMissingValues() {
	     // setup
		 DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	     values.setValue(3.5, 0, 0);
	     // missing for index (0, 1)
	     values.setValue(4.5, 0, 2);
	     double result = DataUtilities.calculateRowTotal(values, 0); 
	     // verify
	     assertEquals(8.0, result, 0.0001);
	 }
	 
	/*//Test for calculating the sum of invalid values (strings)
	 @Test
	 public void calculateRowTotalForInvalidValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 one(values).getColumnCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue("a"));
	                one(values).getValue(0, 1);
	                will(returnValue("b"));
	         }
	     });
	     
//	     DefaultKeyedValues2D values = new DefaultKeyedValues2D();
//	     values.setValue("row1", "col1", "a");
//	     values.setValue("row1", "col2", "b");
	     
	     try {
	         DataUtilities.calculateRowTotal(values, 0);
	         fail("Expected InvalidParameterException");
	     } catch (InvalidParameterException e) {
	         // verify that InvalidParameterException is caught
	     
	 } catch (IllegalStateException e) {
   	 fail("Expected InvalidParameterException (not IllegalStateException)");
    }	     
}
*/
	// New Tests for calculateRowTotal(Values2D data, int row,int[] validCols)
	    @Test
	    public void testCalculateRowTotalThreeArgsWithValidInput() {
	    	
	    	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
		     values.addValue(10, 0, 0);
		     values.addValue(3.2, 0, 1);
		     values.addValue(12.5, 0, 2);
		     values.addValue(6, 2, 0);
		     values.addValue(8, 2, 1);
			 
		    int rows = 0;
	        int[] validCols = new int[] {0, 1,2,3,4};

	        double result = DataUtilities.calculateRowTotal(values, rows, validCols);
	        assertEquals(25.7, result, 0.000001d); 
	        
	    }
	    
	    @Test
	    public void testCalculateRowTotalThreeArgsWithNullInput() {
	    	
	    	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
		     values.addValue(10, 0, 0);
		     values.addValue(null, 0, 1);
		     values.addValue(12.5, 0, 2);
		     values.addValue(6, 2, 0);
		     values.addValue(8, 2, 1);
			 
		    int rows = 0;
	        int[] validCols = new int[] {0, 1,2,3,4};

	        double result = DataUtilities.calculateRowTotal(values, rows, validCols);
	        assertEquals(22.5, result, 0.000001d); 
	        
	    }


	 //getCumulativePercentages() tests
	 
	 //Test for regular testing of percentage calculations with expected values
	 /*@Test
	 public void getCumulativePercentagesWithPositiveValues() {
	     // setup
		 DefaultKeyedValues data = new DefaultKeyedValues();
		 data.addValue((Comparable<Integer>) 0, 20);
		 data.addValue((Comparable<Integer>) 1, 30);
		 data.addValue((Comparable<Integer>) 2, 40);

	     
	     KeyedValues result = DataUtilities.getCumulativePercentages(data);
	     
	     //create arrays for comparison
	     int[] KeysNum = new int[] {0, 1, 2};
	     double[] ValuesNum = new double[] {0.2, 0.6, 1.0}; 
	     // verify 
	     assertEquals(data.getItemCount(), result.getItemCount());
	     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
	    	 assertEquals(KeysNum[i], result.getKey(i));
	    	 assertEquals(ValuesNum[i], result.getValue(i));
	     }
	 }
	 */
	 
	 //Test same as previous (withPositiveValues) but with negative values
	 /*@Test
	 public void getCumulativePercentagesWithNegativeValues() {
	     // setup
		 DefaultKeyedValues data = new DefaultKeyedValues();
		 data.addValue((Comparable<Integer>) 0, -5);
		 data.addValue((Comparable<Integer>) 1, -10);
		 data.addValue((Comparable<Integer>) 2, -15);

	     KeyedValues result = DataUtilities.getCumulativePercentages(data);
	     int[] KeysNum = new int[] {0, 1, 2}; //expected Keys
	     double[] ValuesNum = new double[] {0.2, 0.5, 1.0}; //expected Values
	     // verify
	     assertEquals(data.getItemCount(), result.getItemCount());
	     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
	    	 assertEquals(KeysNum[i], result.getKey(i));
	    	 assertEquals(ValuesNum[i], result.getValue(i));
	     }
	 }
	 */

	 //Test with null object as KeyedValues input
	 @Test
	    public void getCumulativePercentagesWithNullDataObject() {
	        try {
	            // try null object
	            DataUtilities.getCumulativePercentages(null);
	            fail("Expected IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            // verify IllegalArgumentException 
	        }
	        
	        
	    }
	 
	 //Test with a single value as KeyedValues input 
	 @Test
	 public void getCumulativePercentagesWithSingleValue() {
	     // setup
		 
		 DefaultKeyedValues data = new DefaultKeyedValues();
		 data.addValue((Comparable<Integer>) 0, 1);
		 
		 
//	     Mockery mockingContext = new Mockery(); //creating mock object
//	     final KeyedValues data = mockingContext.mock(KeyedValues.class);
//	     mockingContext.checking(new Expectations() {
//	         {
//	             allowing(data).getItemCount(); //single value
//	             will(returnValue(1));
//	             allowing(data).getKey(0);
//	             will(returnValue(0));
//	             allowing(data).getValue(0);
//	             will(returnValue(1));
//	         }
//	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(data);
	     int[] KeysNum = new int[] {0}; 
	     double[] ValuesNum = new double[] {1.0}; 
	     // verify
	     assertEquals(data.getItemCount(), result.getItemCount()); 
	     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
	    	 assertEquals(KeysNum[i], result.getKey(i));
	    	 assertEquals(ValuesNum[i], result.getValue(i));
	     }
	 }
	 
	//Test with an invalid value as KeyedValues input 
		 /*@Test
		 public void getCumulativePercentagesWithInvalidValue() {
		     // setup
		     Mockery mockingContext = new Mockery(); //creating mock object
		     final KeyedValues data = mockingContext.mock(KeyedValues.class);
		     mockingContext.checking(new Expectations() {
		         {
		             allowing(data).getItemCount(); //invalid
		             will(returnValue(1));
		             allowing(data).getKey(0);
		             will(returnValue("a"));
		             allowing(data).getValue(0);
		             will(returnValue("b"));
		         }
		     });
		     // verify
		     try {
		         DataUtilities.getCumulativePercentages(data);
		         fail("Expected InvalidParameterException");
		     } catch (InvalidParameterException e) {
		         // verify that InvalidParameterException is caught
		     } catch (IllegalStateException e) {
		    	 fail("Expected InvalidParameterException (not IllegalStateException)");
		     }
		 }
		 */
		  
		 //NEW TESTS 
		 @Test
		 public void getCumulativePercentagesWithNullValue() {
		     // setup
			 DefaultKeyedValues data = new DefaultKeyedValues();
			 data.addValue((Comparable<Integer>) 0, 9);
			 data.addValue((Comparable<Integer>) 1, 1);
			 data.addValue((Comparable<Integer>) 2, null);
			 
		     KeyedValues result = DataUtilities.getCumulativePercentages(data);
		     int[] KeysNum = new int[] {0, 1, 2}; //expected Keys
		     double[] ValuesNum = new double[] {0.2, 0.5, 1.0}; //expected Values
		     // verify
		     assertEquals(data.getItemCount(), result.getItemCount());
		     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
		    	 assertEquals(KeysNum[i], result.getKey(i));
		     }
		 }
		 
		 // Tests for equal(double[][] a, double[][] b)
		 
		    @Test
		    public void equalNullA() {
		        double[][] a = null;
		        double[][] b = {{1.0, 2.0}, {3.0, 4.0}};
		        assertFalse(DataUtilities.equal(a, b));
		    }

		    @Test
		    public void equalNullB() {
		    	double[][] a = {{1.0, 2.0}, {3.0, 4.0}};
		        double[][] b = null;
		        assertFalse(DataUtilities.equal(a, b));
		    }

		    @Test
		    public void equalBothNull() {
		    	double[][] a = null;
		        double[][] b = null;
		        assertTrue(DataUtilities.equal(a, b));
		    }
		    
		    @Test
		    public void testEqual_LengthMismatch() {
		        double[][] a = {{1.0, 2.0}, {3.0, 4.0}};
		        double[][] b = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
		        assertFalse(DataUtilities.equal(a, b));
		    }
		    @Test
		    public void equalSameLength() {
		    	double[][] a = {{9.0, 5.0}, {8.0, 0.0}};;
		        double[][] b = {{1.0, 2.0}, {3.0, 4.0}};;
		        assertFalse(DataUtilities.equal(a, b));
		    }
		    @Test
		    public void equalBothSame() {
		    	double[][] a = {{1.0, 2.0}, {3.0, 4.0}};;
		        double[][] b = {{1.0, 2.0}, {3.0, 4.0}};;
		        assertTrue(DataUtilities.equal(a, b));
		    }
		    
		    // Tests for clone(double[][] source)
		    @Test
		    public void cloneWithNonNullSource() {
		        double[][] source = {
		            { 1.0, 2.0, 3.0 },
		            { 4.0, 5.0, 6.0 },
		            { 7.0, 8.0, 9.0 }
		        };
		        double[][] result = DataUtilities.clone(source);

		        assertEquals("Result should be equal to source", source, result);
		    }

		    @Test
		    public void cloneWithNullRows() {
		        double[][] source = {
		            null,
		            { 1.0, 2.0, 3.0 },
		            null,
		            { 4.0, 5.0, 6.0 },
		            null
		        };
		        double[][] result = DataUtilities.clone(source);

		        assertEquals("Result should be equal to source", source, result);
		    }
		    
		    @Test
		    public void testCalculateColumnTotalForTwoValues() {
		    	DefaultKeyedValues2D values = new DefaultKeyedValues2D();
			     values.addValue(7.5, 0, 0);
			     values.addValue(2.5, 1, 0);

		        double result = DataUtilities.calculateColumnTotal(values, 0);
		        
		        assertEquals(result, 10.0, 0.000000001d);
		    }
		    
		    
}

