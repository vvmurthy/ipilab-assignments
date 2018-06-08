package assignment2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestOpticDisk {

    @Test
    public void TestOpticDisk1(){
        String inputFilename = "src/test/resources/assignment2/eye1.jpg";
        int[] location = OpticDisk.findOpticDisk(inputFilename);

        // Plot the results
        PremadeImage results = new ImplementedImage(inputFilename);
        results.plotImage(location);
        results.save("src/test/resources/assignment2/GeneratedOutput1");

        // check coordinates match
        assertEquals(952, location[1]);
        assertEquals(844, location[0]);

    }

    @Test
    public void TestOpticDisk2(){
        String inputFilename = "src/test/resources/assignment2/eye2.jpg";
        int[] location = OpticDisk.findOpticDisk(inputFilename);

        // Plot the results
        PremadeImage results = new ImplementedImage(inputFilename);
        results.plotImage(location);
        results.save("src/test/resources/assignment2/GeneratedOutput2");

        // check coordinates match
        assertEquals(895, location[1]);
        assertEquals(681, location[0]);
    }

    @Test
    public void TestOpticDisk3(){
        String  inputFilename = "src/test/resources/assignment2/eye3.png";
        int[] location = OpticDisk.findOpticDisk(inputFilename);

        // Plot the results
        PremadeImage results = new ImplementedImage(inputFilename);
        results.plotImage(location);
        results.save("src/test/resources/assignment2/GeneratedOutput3");

        // check coordinates match
        assertEquals(1561, location[1]);
        assertEquals(924, location[0]);
    }



}
