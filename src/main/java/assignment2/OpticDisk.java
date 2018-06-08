package assignment2;

public class OpticDisk {


    public static int[] findOpticDisk(String filename){
        PremadeImage image = new ImplementedImage(filename);
        return findOpticDisk(image);
    }


    /**Function to find a point in the optic disk
     * using the green channel values
     *
     * @param image image to find optic disk in
     * @return a built-in array of 2 integers- the first
     * is the row where the optic disk is located (with respect
     * to the 2D array). The second is the column where the
     * optic disk is located.
     */
    public static int[] findOpticDisk(PremadeImage image){

        // initialize image
        int row = 0;
        int col = 0;

        //TODO: Get the optic disk coordinates here

        // return coordinates of optic disk
        int[] coordinates = new int[2];
        coordinates[0] = row;
        coordinates[1] = col;
        return coordinates;
    }
}
