package assignment3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


/*
Test class for grayscale images

Run all of these tests by right clicking on `public class TestGrayScale` or run
each of them individually by right clicking on the function declaration then running
 */
public class TestGrayScale {

    /**
     * tests your code will thrown an exception of type RGBException if
     * there is a RGB value > 255 in the image
     */
    @Test
    public void testExceptionIsThrown(){
        GrayScaleImage g = new GrayScaleImage("src/test/resources/assignment2/eye1.jpg");
        int[] invalidRGB = {260, 0, 0};
        g.setRGB(0,0, invalidRGB);
        try{
            g.convertToGrayScale();
            fail("exception not thrown");
        }catch (GrayScaleImage.RGBException e){}
    }

    /**
     * tests your code will thrown an exception of type RGBException if
     * there is a RGB value < 0 in the image
     */
    @Test
    public void testExceptionIsThrownNegativeValues(){
        GrayScaleImage g = new GrayScaleImage("src/test/resources/assignment2/eye1.jpg");
        int[] invalidRGB = {0, -1, 0};
        g.setRGB(0,0, invalidRGB);
        try{
            g.convertToGrayScale();
            fail("exception not thrown");
        }catch (GrayScaleImage.RGBException e){}
    }

    /**
     * tests your code will thrown an exception of type RGBException if
     * there is an invalid RGB value in the blue channel of the image
     */
    @Test
    public void testExceptionIsThrownBlueChannel(){
        GrayScaleImage g = new GrayScaleImage("src/test/resources/assignment2/eye1.jpg");
        int[] invalidRGB = {0, 0, -1};
        g.setRGB(0,0, invalidRGB);
        try{
            g.convertToGrayScale();
            fail("exception not thrown");
        }catch (GrayScaleImage.RGBException e){}
    }


    /**
     * Converting a grayscale image to grayscale shouldn't do
     * anything
     *
     * This builds a grayscale image, and saves it as Input1
     * Then "converts" it to grayscale.
     *
     * Your program should not change any values in the image
     */
    @Test
    public void testGrayScaleConversionGrayscale(){
        GrayScaleImage g = new GrayScaleImage(2,2);
        int grayIntensity = 120;
        int[] gray = {grayIntensity, grayIntensity, grayIntensity};
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                g.setRGB(i,j, gray);
            }
        }

        g.save("src/test/resources/assignment3/Input1");
        try{
            g.convertToGrayScale();
            g.save("src/test/resources/assignment3/GeneratedOutput1");
        }catch (GrayScaleImage.RGBException e){
            fail("Exception should not be thrown");
        }

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                int[] rgb = g.getRGB(i,j);
                for(int index = 0 ; index < 3 ; index++){
                    assertEquals(grayIntensity, rgb[index]);
                }
            }
        }
    }

    /**
     * This image checks that a few different RGB values
     * have the same grayscale value
     */
    @Test
    public void testGrayScaleConversionColor(){
        GrayScaleImage g = new GrayScaleImage(2,2);
        int red = 120;
        int blue = 200;
        int green = 2;
        List<Integer> colors = new ArrayList<>();
        colors.add(red);
        colors.add(green);
        colors.add(blue);
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){

                int[] pixelColors = new int[3];
                for(int k = 0 ; k < colors.size() ; k++){
                    pixelColors[k] = colors.get((k + i + j) % colors.size());
                }

                g.setRGB(i,j, pixelColors);
            }
        }

        g.save("src/test/resources/assignment3/Input2");
        try{
            g.convertToGrayScale();
            g.save("src/test/resources/assignment3/GeneratedOutput2");
        }catch (GrayScaleImage.RGBException e){
            fail("Exception should not be thrown");
        }

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                int[] rgb = g.getRGB(i,j);
                for(int index = 0 ; index < 3 ; index++){
                    assertEquals(g.getRGB(0,0)[index], rgb[index]);
                }
            }
        }
    }



}
