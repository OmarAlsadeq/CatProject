package com.example.demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader extends JPanel {
    private BufferedImage image;

    public ImageLoader(String fileName){
        try{
            image= ImageIO.read(new File(fileName));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Image Loader");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageLoader imageLoader = new ImageLoader("salem_Cat.jpg");
        frame.add(imageLoader);
        frame.setVisible(true);
    }
}
