package assignment2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestThreshold {

    @Test
    public void testGrayScaleInvalidBinary(){
        String filename = "src/test/resources/assignment2/grayscaleInvalid.png";
        assertEquals(null, Threshold.inBinary(filename));
    }

    @Test
    public void testBWBinary(){
        String filename = "src/test/resources/assignment2/blackAndWhite.png";
        assertNotNull(Threshold.inBinary(filename));
    }

    @Test
    public void testColorInvalidBinary(){
        String filename = "src/test/resources/assignment2/colorInvalid.png";
        assertEquals(null, Threshold.inBinary(filename));
    }

    @Test
    public void testColorBinary(){
        String filename = "src/test/resources/assignment2/colorsBinary.png";
        assertNotNull(Threshold.inBinary(filename));
    }

    @Test
    public void testBinarizationGray(){
        String filename = "src/test/resources/assignment2/grayscaleInvalid.png";
        assertEquals(null, Threshold.binarizeImage(filename));
    }

    @Test
    public void testBinarizationInvalidColor(){
        String filename = "src/test/resources/assignment2/colorInvalid.png";
        assertEquals(null, Threshold.binarizeImage(filename));
    }

    @Test
    public void testBinarizationBW(){
        String filename = "src/test/resources/assignment2/blackAndWhite.png";
        PremadeImage generated = Threshold.binarizeImage(filename);
        assertNotNull(generated);
        generated.save("src/test/resources/assignment2/generatedBlackAndWhite");

        PremadeImage reference = new ImplementedImage("src/test/resources/assignment2/referenceBlackAndWhite.png");
        assertEquals(generated, reference);
    }

    @Test
    public void testBinarizationColor(){
        String filename = "src/test/resources/assignment2/colorsBinary.png";
        PremadeImage generated = Threshold.binarizeImage(filename);
        assertNotNull(generated);
        generated.save("src/test/resources/assignment2/generatedColors");
        PremadeImage reference = new ImplementedImage("src/test/resources/assignment2/referenceColors.png");
        assertEquals(generated, reference);
    }

}
