package assignment2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ThresholdTestCases {

    private static void generateTestCase(java.util.List<Color> colors, String name){
        int width = 100;
        int height = 100;

        Random rand = new Random();

        PremadeImage premadeImage = new ImplementedImage(height, width);
        for(int i = 0 ; i < height ; i++){
            Color c = colors.get(rand.nextInt(colors.size()));
            int[] rgb = new int[3];
            rgb[0] = c.getRed();
            rgb[1] = c.getGreen();
            rgb[2] = c.getBlue();
            for(int j = 0 ; j < width ; j++){
                premadeImage.setRGB(i,j,rgb);
            }
        }

        premadeImage.save("src/test/resources/assignment2/" + name);
    }

    private static void makeTestCases(){

        // Grayscale (not binary)
        java.util.List<Color> colors = new ArrayList<>();
        colors.add(Color.BLACK);
        colors.add(Color.GRAY);
        colors.add(Color.LIGHT_GRAY);
        colors.add(Color.WHITE);
        generateTestCase(colors, "grayscaleInvalid");


        // Black and white binary
        colors.clear();
        colors.add(Color.BLACK);
        colors.add(Color.WHITE);
        generateTestCase(colors, "blackAndWhite");

        // color binary
        colors.clear();
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        generateTestCase(colors, "colorsBinary");

        // unary (invalid)
        colors.clear();
        colors.add(Color.BLUE);
        generateTestCase(colors, "colorInvalid");
    }

    public static void main(String[] args){
        ThresholdTestCases.makeTestCases();
    }
}
