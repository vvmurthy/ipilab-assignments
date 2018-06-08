package assignment3;

public class GrayScaleImage extends ImplementedImage implements PremadeImage{

    // This is the type of exception Grayscale must throw
    public static class RGBException extends Exception{ }


    GrayScaleImage(String filename){
        super(filename);
    }

    GrayScaleImage(int height, int width){
        super(height, width);
    }


    /**
     * Converts the image from color to grayscale
     */
    public void convertToGrayScale() throws RGBException{

        // TODO: write code here
    }

}
