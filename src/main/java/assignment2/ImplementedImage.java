package assignment2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImplementedImage implements PremadeImage{

    private BufferedImage bimg;

    ImplementedImage(String filename){
        try{
            bimg = ImageIO.read(new File(filename));
        }catch (IOException e){}
    }

    ImplementedImage(int height, int width){
        bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public int getGreenChannel(int row, int col){
        return new Color(bimg.getRGB(col, row)).getGreen();
    }

    public int[] getRGB(int row, int col){
        Color c = new Color(bimg.getRGB(col, row));
        int[] toReturn = new int[3];
        toReturn[0] = c.getRed();
        toReturn[1] = c.getGreen();
        toReturn[2] = c.getBlue();
        return toReturn;
    }

    public void setRGB(int row, int col, int[] rgb){
        bimg.setRGB(col, row, new Color(rgb[0], rgb[1], rgb[2]).getRGB());
    }

    public int getHeight(){return bimg.getHeight();}
    public int getWidth(){return bimg.getWidth();}


    @Override
    public void plotImage(int[] coordinates) {
        BufferedImage toReturn = new BufferedImage(bimg.getWidth(), bimg.getHeight(),
                bimg.getType());
        Graphics g = toReturn.getGraphics();
        g.drawImage(bimg, 0, 0, null);
        g.setColor(Color.RED);
        int radius = 10;
        g.fillOval(coordinates[1] - radius/2,coordinates[0] - radius/2, 2*radius, 2*radius);
        g.dispose();
        bimg = toReturn;
    }

    @Override
    public void save(String filename) {
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
}
