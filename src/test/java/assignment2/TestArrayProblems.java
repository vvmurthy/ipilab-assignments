package assignment2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestArrayProblems {

    /*
    Checks the array 1 | 2 | 3 | 4 | 5 becomes
    5 | 4 | 3 | 2 | 1
     */
    @Test
    public void testReverseArray1(){

        int[] numbers = {1, 2, 3, 4, 5};
        int[] answer = {5, 4, 3, 2, 1};


        int[] yourAnswer  = ArrayProblems.reverseArray(numbers);
        for(int i = 0 ; i < numbers.length ; i++){
            assertEquals(answer[i], yourAnswer[i]);
        }
    }

    /*
    Checks that reversing a 1-element array
    leaves it unchanged.
     */
    @Test
    public void testReverseArray1Element(){
        int[] numbers = {1};
        int[] answer = {1};


        int[] yourAnswer  = ArrayProblems.reverseArray(numbers);
        for(int i = 0 ; i < numbers.length ; i++){
            assertEquals(answer[i], yourAnswer[i]);
        }
    }

    /*
    Tests that in the array
    1 | 2
    3 | 4
    that 4 is found as the max value
     */
    @Test
    public void testFindMaxValue(){
        double[][] numbers = new double[2][2];
        numbers[0][0] = 1;
        numbers[0][1] = 2;
        numbers[1][0] = 3;
        numbers[1][1] = 4;
        double maxValue = 4;
        assertEquals(maxValue, ArrayProblems.findMaxValue(numbers));
    }

    /*
    Tests that the number contained within a
    1-element array is returned, as it is
    the maximum value of the 1 element array
     */
    @Test
    public void testFindMax1Element(){
        double[][] numbers = new double[1][1];
        numbers[0][0] = 10;
        double maxValue = 10;
        assertEquals(maxValue, ArrayProblems.findMaxValue(numbers));
    }

    /*
    Tests that the maximum is found even if
    all the elements in the array are the same
     */
    @Test
    public void testFindMaxSameElements(){
        double[][] numbers = new double[2][2];
        numbers[0][0] = 2;
        numbers[0][1] = 2;
        numbers[1][0] = 2;
        numbers[1][1] = 2;
        double maxValue = 2;
        assertEquals(maxValue, ArrayProblems.findMaxValue(numbers));
    }

    /*
    Tests that the maximum is found even if
    there are negative values in the array
     */
    @Test
    public void testFindMaxNegativeValues(){
        double[][] numbers = new double[2][2];
        numbers[0][0] = -1;
        numbers[0][1] = -2;
        numbers[1][0] = -3;
        numbers[1][1] = -4;
        double maxValue = -1;
        assertEquals(maxValue, ArrayProblems.findMaxValue(numbers));
    }
}
