package assignment4;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestMathOperations {

    // You needn't concern yourself with this function
    private void placeIntoArray(double[][] X, double[] contentsX){
        int k = 0;
        for(int i = 0 ; i < X.length ; i++){
            for(int j = 0 ; j < X[0].length ; j++){
                X[i][j] = contentsX[k];
                k++;
            }
        }
    }

    // Checks that an output array matches the values expected
    // expected values are stored in a 1D array in row-major order (values vary by column
    // then by row)
    private void checkOutputContents(double[][] output, double[] outputContents){
        int k = 0;
        for(int i = 0 ; i < output.length ; i++){
            for(int j = 0 ; j < output[0].length ; j++){
                assertEquals(outputContents[k], output[i][j]);
                k++;
            }
        }
    }

    // Tests the example from the README
    @Test
    public void testDotProduct1(){
        double[][] I = new double[2][2];
        double[] contentsI = {1,2,2,3};
        placeIntoArray(I, contentsI);

        double[][] w = new double[2][1];
        double[] contentsW = {1,2};
        placeIntoArray(w, contentsW);

        try{
            double[][] output = MathOperations.dotProduct(I, w);
            double[] outputContents = {5,8};
            checkOutputContents(output, outputContents);
        }catch (MathOperations.ValueError e){
            fail("Exception thrown");
        }
    }

    // Tests multiplication against identity matrix
    @Test
    public void testDotProduct2(){
        double[][] I = new double[2][2];
        double[] contentsI = {1,2,2,3};
        placeIntoArray(I, contentsI);

        double[][] w = new double[2][2];
        double[] contentsW = {1,0,0,1};
        placeIntoArray(w, contentsW);

        try{
            double[][] output = MathOperations.dotProduct(I, w);
            checkOutputContents(output, contentsI);
        }catch (MathOperations.ValueError e){
            fail("Exception thrown");
        }
    }

    // Tests invalid dot product
    @Test
    public void testDotProductInvalid(){
        double[][] I = new double[2][3];

        double[][] w = new double[2][1];
        double[] contentsW = {1,2};
        placeIntoArray(w, contentsW);

        try{
            double[][] output = MathOperations.dotProduct(I, w);
            fail("Exception not thrown");
        }catch (MathOperations.ValueError e){
        }
    }

    // Tests relu works for positive, zero and negative values
    @Test
    public void testRELU(){
        double[][] I = new double[3][3];
        double[] contentsI = {1,0,-1, 0.1, -0.1, 2, 3, 5, -10};
        double[] contentsOutput = {1, 0, 0, 0.1, 0, 2, 3, 5, 0};
        placeIntoArray(I, contentsI);

        MathOperations.RELU(I);
        checkOutputContents(I, contentsOutput);
    }

    // Tests RELU derivative for positive, negative and zero values
    @Test
    public void testReluDerivative(){
        double[][] I = new double[3][3];
        double[] contentsI = {1,0,-1, 0.1, -0.1, 2, 3, 5, -10};
        double[] contentsOutput = {1, 0, 0, 1, 0, 1, 1, 1, 0};
        placeIntoArray(I, contentsI);

        MathOperations.reluDerivative(I);
        checkOutputContents(I, contentsOutput);
    }

    // Tests ELU for postive, negative and zero values
    @Test
    public void testElu(){
        double[][] I = new double[3][3];
        double[] contentsI = {1,0,-1, 0.1, -0.1, 2, 3, 5, -10};
        double[] contentsOutput = {1, 0, Math.exp(-1) - 1, 0.1, Math.exp(-0.1) - 1, 2, 3, 5, Math.exp(-10) -1};
        placeIntoArray(I, contentsI);

        MathOperations.ELU(I);
        checkOutputContents(I, contentsOutput);
    }


    // Tests ELU derivative for postive, negative and zero values
    @Test
    public void testEluDerivative(){
        double[][] I = new double[3][3];
        double[] contentsI = {1,0,-1, 0.1, -0.1, 2, 3, 5, -10};
        double[] contentsOutput = {1, 1, Math.exp(-1), 1, Math.exp(-0.1), 1, 1, 1, Math.exp(-10)};
        placeIntoArray(I, contentsI);

        MathOperations.eluDerivative(I);
        checkOutputContents(I, contentsOutput);
    }

    // Tests the example from the README
    @Test
    public void testConv1(){

        double[][] w = new double[3][3];
        double[] contentsW = {0,1,0,1,1,0,0,1,0};
        placeIntoArray(w, contentsW);

        // Read values into X
        double[][] X = new double[4][4];
        double[] contentsX = {1, 2, 4, 5, 2, 3, 4, 5, 10, 11, 12, 13, 0, 1, 3, 8};
        int k = 0;
        for(int i = 0 ; i < X.length ; i++){
            for(int j = 0 ; j < X[0].length ; j++){
                X[i][j] = contentsX[k];
                k++;
            }
        }

        double[][] output = MathOperations.Convolution(X, w);
        assertEquals(4, output.length);
        assertEquals(4, output[0].length);

        double[] contentsOutput = {3,6,10,14,13,18,23,27,12,25,30,38,10,12,16,24};
        k = 0;
        for(int i = 0 ; i < X.length ; i++){
            for(int j = 0 ; j < X[0].length ; j++){
                assertEquals(contentsOutput[k], output[i][j]);
                k++;
            }
        }
    }

    // Test convolutional identity (weight matrix of 1)
    @Test
    public void testConv2(){
        double[][] w = new double[1][1];
        w[0] = new double[1];
        w[0][0] = 1;

        // Read values into X
        double[][] X = new double[4][4];
        double[] contentsX = {1, 2, 4, 5, 2, 3, 4, 5, 10, 11, 12, 13, 0, 1, 3, 8};
        placeIntoArray(X, contentsX);

        double[][] output = MathOperations.Convolution(X, w);
        assertEquals(4, output.length);
        assertEquals(4, output[0].length);
        int k = 0;
        for(int i = 0 ; i < X.length ; i++){
            for(int j = 0 ; j < X[0].length ; j++){
                assertEquals(contentsX[k], output[i][j]);
                k++;
            }
        }
    }

    // Tests rectangular weight dimensions
    // Where height != width
    @Test
    public void testConv3(){
        double[][] w = new double[1][3];
        w[0][0] = 1;
        w[0][1] = 1;
        w[0][2] = 0;
        double[] contentsX = {1,2,3,2,3,4,10,11,12};
        double[][] X = new double[3][3];
        placeIntoArray(X, contentsX);

        double[][] output = MathOperations.Convolution(X, w);
        double[] contentsOutput = {1, 3, 5, 2, 5, 7, 10, 21, 23};
        assertEquals(3, output.length);
        assertEquals(3, output[0].length);
        int k = 0;
        for(int i = 0 ; i < X.length ; i++){
            for(int j = 0 ; j < X[0].length ; j++){
                assertEquals(contentsOutput[k], output[i][j]);
                k++;
            }
        }
    }
}
