package assignment2;

import java.awt.image.BufferedImage;

public interface PremadeImage {

    /**
     * Gets the green channel of the image pixel
     * being accessed
     *
     * @param row row of pixel being accessed in 2D array
     * @param col column of pixel being access in 2D array
     * @return green channel value of pixel being accessed
     */
     int getGreenChannel(int row, int col);


    /**
     * Gets the RGB values of the image pixel being accessed
     *
     * @param row row of pixel being accessed in 2D array
     * @param col column of pixel being access in 2D array
     * @return built in array of length 3- first element is
     * red, second element is green and third element is blue
     * channel of array
     */
     int[] getRGB(int row, int col);

    /**
     * Sets the RGB value of the pixel being accessed
     *
     * @param row row of pixel being accessed
     * @param col column of pixel being accessed
     * @param rgb built in array of length 3- first element is
     *            the red intensity to set the pixel to, second
     *            is green intensity to set pixel to, third is
     *            blue intensity to set pixel to
     */
     void setRGB(int row, int col, int[] rgb);

    /**
     * Returns height (number of rows) of image
     * @return height in pixels (number of rows)
     */
    int getHeight();

    /**
     * Returns width (number of columns) of image
     * @return width of image in pixels (number of rows)
     */
    int getWidth();

    /**
     * Plots a circle around a given location of the image,
     * centered at the input location
     * used for overlaying coordinates over the image
     *
     * @param coordinates built in array of 2 coordinates- first is row, second is column
     */
    void plotImage(int[] coordinates);

    /**
     * Saves an image to a given file location
     * @param filename the location to save the file to in relative path
     */
    void save(String filename);

    /**
     * checks whether two images are equal (same values at every pixel)
     * @param another another image
     * @return false if they are not equal, true if they are
     */
    @Override
    boolean equals(Object another);
}
