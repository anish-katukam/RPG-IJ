package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDrawer extends JComponent {
    public static BufferedImage[] listOfImages = new BufferedImage[4]; //array of images
    private int image_index; //index of image in array

    public ImageDrawer(int index) {
        try {
            //get all images from resources folder and resize to screen size, add them to array
            listOfImages[0] = Util.resizeImg(Util.screen_size, ImageIO.read(new File("src/com/company/resources/Splashes/OpeningSplash.jpg")));
            listOfImages[1] = Util.resizeImg(Util.screen_size, ImageIO.read(new File("src/com/company/resources/chapter1.jpg")));
            listOfImages[2] = Util.resizeImg(Util.screen_size, ImageIO.read(new File("src/com/company/resources/chapter2.jpg")));
            listOfImages[3] = Util.resizeImg(Util.screen_size, ImageIO.read(new File("src/com/company/resources/chapter3.jpg")));
        } catch (IOException e) {
        }

        image_index = index; //set current index from the explicit parameter of the constructor
    }

    public static BufferedImage getImage(int index) //get image at index
    {
        return listOfImages[index]; //return the image specified by index
    }

    public void paintComponent(Graphics g) //paint component
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(listOfImages[image_index], 0, 0, this); //draw the image across the entire screen
    }
}
