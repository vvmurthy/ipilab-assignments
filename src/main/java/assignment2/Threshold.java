package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Threshold {

    /** Determines if an image contains only 2
     * distinct RGB values, thus being
     * in "binary"
     *
     * @param filename filename of image to determine
     *                 if in binary
     * @return null if image is not in binary, or
     * the two values in a list if the image is
     */
    public static List<int[]> inBinary(String filename){

        PremadeImage image = new ImplementedImage(filename);

        List<int[]> l = new ArrayList<>();

        // TODO: determine if the image is in binary here

        return l;
    }


    /**
     * Binarizes an image so that the pixels where
     * the sum of the RGB values is greater are white,
     * and the pixels where the sum of the RGB values are
     * lower is black.
     *
     * If the image does not contain only 2 distinct RGB values,
     * returns null. Otherwise, returns the binarized image.
     */
    public static PremadeImage binarizeImage(String filename){

        // TODO: delete the line below and replace with your
        // implementation
        return new ImplementedImage(filename);
    }
}
