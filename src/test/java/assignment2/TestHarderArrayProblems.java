package assignment2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestHarderArrayProblems {


    public void checkTranspose(double[][] a, double[][] newA){
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                assertEquals(a[i][j], newA[j][i]);
            }
        }
    }

    /**
     * Checks function works with a single element
     */
    @Test
    public void testCreateTranspose1(){
        double[][] a = new double[1][1];
        a[0][0] = Math.random();
        double[][] newA = HarderArrayProblems.createTranspose(a);
        checkTranspose(a, newA);
    }

    /**
     * Checks function works with random 5 x 5 array
     */
    @Test
    public void testCreateTranspose2(){
        double[][] a = new double[5][5];
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = Math.random();
            }
        }
        double[][] newA = HarderArrayProblems.createTranspose(a);
        checkTranspose(a, newA);
    }

    /**
     * Checks function works with random 4 x 2 array
     */
    @Test
    public void testCreateTranspose3(){
        double[][] a = new double[4][2];
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = Math.random();
            }
        }
        double[][] newA = HarderArrayProblems.createTranspose(a);
        checkTranspose(a, newA);
    }

    /**
     * Checks creation of row indices in the event
     * there are no 1s in the array
     */
    @Test
    public void testCreateRowIndices1(){

        double[][] input = new double[4][3];
        int[][] myIndices = HarderArrayProblems.createRowIndices(input);
        assertEquals(0, myIndices.length);
        assertEquals(0, myIndices[0].length);
    }

    /**
     * Checks functionality with rectangular arrays
     */
    @Test
    public void testCreateRowIndices2(){
        int[][] a = new int[4][2];
        a[0][0] = 0;
        a[0][1] = 0;
        a[1][0] = 0;
        a[1][1] = 1;
        a[2][0] = 0;
        a[2][1] = 2;
        a[3][0] = 2;
        a[3][1] = 1;

        double[][] input = new double[4][3];

        for(int i = 0 ; i < a.length ; i++){
            input[a[i][0]][a[i][1]] = 1;
        }

        int[][] myIndices = HarderArrayProblems.createRowIndices(input);
        for(int i = 0 ; i < a.length ; i++){
            assertEquals(a[i][0], myIndices[i][0]);
            assertEquals(a[i][1], myIndices[i][1]);
        }

    }

    /**
     * Checks functionality with square arrays
     */
    @Test
    public void testCreateRowIndices3(){
        int[][] a = new int[4][2];
        a[0][0] = 0;
        a[0][1] = 0;
        a[1][0] = 0;
        a[1][1] = 1;
        a[2][0] = 0;
        a[2][1] = 2;
        a[3][0] = 2;
        a[3][1] = 1;

        double[][] input = new double[4][4];

        for(int i = 0 ; i < a.length ; i++){
            input[a[i][0]][a[i][1]] = 1;
        }

        int[][] myIndices = HarderArrayProblems.createRowIndices(input);
        for(int i = 0 ; i < a.length ; i++){
            assertEquals(a[i][0], myIndices[i][0]);
            assertEquals(a[i][1], myIndices[i][1]);
        }
    }

    public void checkRotate(double[][] a, double[][] newA){
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                assertEquals(a[i][j], newA[j][a.length - 1 - i]);
            }
        }
    }

    /**
     * Checks rotation with square array
     */
    @Test
    public void testRotate90Degrees1(){
        double[][] a = new double[5][5];
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = Math.random();
            }
        }
        double[][] newA = HarderArrayProblems.rotateArray90(a);
        checkRotate(a, newA);
    }

    /**
     * Checks rotation with rectangular array
     */
    @Test
    public void testRotate90Degrees2(){
        double[][] a = new double[2][3];
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a[0].length ; j++){
                a[i][j] = Math.random();
            }
        }
        double[][] newA = HarderArrayProblems.rotateArray90(a);
        checkRotate(a, newA);
    }
}
