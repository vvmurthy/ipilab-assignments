package assignment4;

public class MathOperations {

    public static class ValueError extends Exception{
        ValueError(String message){
            System.err.println(message);
        }
    }

    public static double[][] dotProduct(double[][] X, double[][] w) throws ValueError{

        // todo: fill in. Remember to delete the line below
        // and fill in with the return your function needs
        return new double[1][1];
    }

    public static void RELU(double[][] X){
        // todo: fill in
    }

    public static void ELU(double[][] X){
        // todo: fill in
    }

    public static void reluDerivative(double[][] X){
        // todo: fill in
    }

    public static void eluDerivative(double[][] X){
        // todo: fill in
    }

    public static double[][] Convolution(double[][] X, double[][] w){

        // todo: fill in. Remember to delete the line below
        // and fill in with the return your function needs
        return new double[1][1];
    }
}
