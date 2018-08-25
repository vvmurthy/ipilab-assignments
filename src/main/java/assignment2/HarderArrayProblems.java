package assignment2;

public class HarderArrayProblems {

    /**
     * Creates the transpose of an array.
     * To create the transpose of an array, the 0th
     * row becomes the 0th column of the transpose array,
     * the 1st row becomes the 1st column of the transpose
     * array, so on.
     *
     * Example:
     *
     * 1 2 3        1 4 7
     * 4 5 6   ->   2 5 8
     * 7 8 9        3 6 9
     */
    public static double[][] createTranspose(double[][] a){
        return new double[1][1]; // TODO: delete and replace with your code
    }

    /**
     * Finds all 1s in the array, and saves each coordinate of a found
     * 1 as a row in a 2D built array in (row, col) format.
     *
     * Note you will need TWO sets of for loops to solve this problem
     * in order to use built-in arrays
     *
     * Example:
     *
     * 0 1 1          0 1
     * 0 0 0    ->    0 2
     * 1 0 0          2 0
     */
    public static int[][] createRowIndices(double[][] a){
        return new int[1][1]; // TODO: delete and replace
    }

    /**
     * Rotates a 2D array 90 degrees.
     *
     * Note that this is equivalent to
     * taking the transpose of the input array, then reversing the order
     * of each column so that the column in the jth index is moved to the
     * column at the a[0].length - 1 - j index.
     *
     * Example:
     *
     * 1 2 3         7 4 1
     * 4 5 6    ->   8 5 2
     * 7 8 9         9 6 3
     */
    public static double[][] rotateArray90(double[][] a){
        return new double[1][1]; // TODO: delete and replace
    }
}
