package assignment3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImplementedImage implements PremadeImage {

    private int[][] red;
    private int[][] blue;
    private int[][] green;

    ImplementedImage(String filename){
        try{
            BufferedImage bimg = ImageIO.read(new File(filename));
            setImplementedImage(bimg);
        }catch (IOException e){}
    }

    ImplementedImage(int height, int width){
        red = new int[height][width];
        blue = new int[height][width];
        green = new int[height][width];
    }

    private ImplementedImage(BufferedImage bimg){
        setImplementedImage(bimg);
    }

    private void setImplementedImage(BufferedImage bimg){
        red = new int[bimg.getHeight()][bimg.getWidth()];
        blue = new int[bimg.getHeight()][bimg.getWidth()];
        green = new int[bimg.getHeight()][bimg.getWidth()];

        for(int i = 0 ; i < bimg.getHeight() ; i++){
            for(int j = 0 ; j < bimg.getWidth() ; j++){
                Color c = new Color(bimg.getRGB(j,i));
                red[i][j] = c.getRed();
                green[i][j] = c.getGreen();
                blue[i][j] = c.getBlue();
            }
        }
    }

    public int getGreenChannel(int row, int col){
        return green[row][col];
    }
    public int getBlueChannel(int row, int col){
        return blue[row][col];
    }
    public int getRedChannel(int row, int col){
        return red[row][col];
    }

    public int[] getRGB(int row, int col){
        int[] toReturn = new int[3];
        toReturn[0] = red[row][col];
        toReturn[1] = green[row][col];
        toReturn[2] = blue[row][col];
        return toReturn;
    }

    public void setRGB(int row, int col, int[] rgb){

        red[row][col] = rgb[0];
        green[row][col] = rgb[1];
        blue[row][col] = rgb[2];
    }

    public int getHeight(){return red.length;}
    public int getWidth(){return red[0].length;}

    @Override
    public void plotImage(int[] coordinates){
        throw new AssertionError("This function should not be called in assignment 3");
    }

    @Override
    public PremadeImage returnImage(int[] coordinates) {
        BufferedImage toReturn = new BufferedImage(getWidth(),getHeight(),
                BufferedImage.TYPE_INT_ARGB);

        for(int i = 0 ; i < toReturn.getHeight() ; i++){
            for(int j = 0 ; j < toReturn.getWidth() ; j++){
                Color c = new Color(red[i][j], green[i][j], blue[i][j]);
                toReturn.setRGB(j, i, c.getRGB());
            }
        }
        Graphics g = toReturn.getGraphics();
        int radius = 10;
        g.fillOval(coordinates[1] - radius/2,coordinates[0] - radius/2, 2*radius, 2*radius);
        g.dispose();
        return new ImplementedImage(toReturn);
    }

    @Override
    public void save(String filename, BufferedImage bimg) {
        try{
            ImageIO.write(bimg, "png", new File(filename + ".png"));
        }catch (IOException e){}
    }

    @Override
    public boolean equals(Object another){
        if(another == null || !(another instanceof ImplementedImage) ||
                ((ImplementedImage) another).getHeight() != getHeight() ||
                ((ImplementedImage) another).getWidth() != getWidth()){
            return false;
        }
        for(int i =0 ; i < getHeight() ; i++){
            for(int j = 0 ; j < getWidth() ; j++){
                int[] rgb1 = ((ImplementedImage) another).getRGB(i,j);
                int[] rgb2 = getRGB(i,j);
                for(int k = 0 ; k < rgb1.length ; k++){
                    if(rgb1[k] != rgb2[k]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void save(String filename) {
        BufferedImage bimg = new BufferedImage(red[0].length, red.length, BufferedImage.TYPE_INT_ARGB);
        for(int i =0 ; i < getHeight() ; i++){
            for(int j = 0 ; j < getWidth() ; j++){
                bimg.setRGB(j,i, new Color(red[i][j], green[i][j], blue[i][j]).getRGB());
            }
        }

        try{
            ImageIO.write(bimg, "png", new File(filename + ".png"));
        }catch (IOException e){}
    }


    public BufferedImage renderableImage(){
        BufferedImage bimg = new BufferedImage(red[0].length, red.length, BufferedImage.TYPE_INT_ARGB);
        for(int i =0 ; i < getHeight() ; i++){
            for(int j = 0 ; j < getWidth() ; j++){
                bimg.setRGB(j,i, new Color(red[i][j], green[i][j], blue[i][j]).getRGB());
            }
        }
        return bimg;
    }
}
