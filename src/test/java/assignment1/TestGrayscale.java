package assignment1;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestGrayscale {
    @Test
    public void convertToGrayscale1(){

        int r = 1;
        int g = 2;
        int b = 1;

        int expectedOutput = 1;

        assertEquals(expectedOutput, Grayscale.convertToGrayscale(r, g, b));
    }

    @Test
    public void convertToGrayscale2(){

        int r = 1;
        int g = 2;
        int b = 2;

        int expectedOutput = 2;

        assertEquals(expectedOutput, Grayscale.convertToGrayscale(r, g, b));
    }

    @Test
    public void inGrayscale1(){

        int r = 1;
        int g = 2;
        int b = 2;
        boolean expectedOutput = false;
        assertEquals(expectedOutput, Grayscale.inGrayScale(r, g, b));
    }

    @Test
    public void inGrayscaleWhite(){
        int r = 255;
        int g = 255;
        int b = 255;
        boolean expectedOutput = true;
        assertEquals(expectedOutput, Grayscale.inGrayScale(r, g, b));
    }

    @Test
    public void inGrayscaleBlack(){
        int r = 0;
        int g = 0;
        int b = 0;
        boolean expectedOutput = true;
        assertEquals(expectedOutput, Grayscale.inGrayScale(r, g, b));
    }

    @Test
    public void inGrayScaleGray(){
        int r = 200;
        int g = 200;
        int b = 200;
        boolean expectedOutput = true;
        assertEquals(expectedOutput, Grayscale.inGrayScale(r, g, b));
    }

    @Test
    public void inGrayScaleInvalid(){
        int r = 200;
        int g = 200;
        int b = -1;
        boolean expectedOutput = false;
        assertEquals(expectedOutput, Grayscale.inGrayScale(r, g, b));
    }

    @Test
    public void inGrayScaleGrayInvalid2(){
        int r = 256;
        int g = 200;
        int b = 200;
        boolean expectedOutput = false;
        assertEquals(expectedOutput, Grayscale.inGrayScale(r, g, b));
    }
}
