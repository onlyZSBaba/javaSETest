package com.epoch.demo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class CreateImg {
    public static void createFongImg(String path){
        String base = "我爱你";
        try{
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            graphics2D.setFont(new Font("宋体",Font.BOLD,12));
            int index = 0;
            for(int y = 0; y < image.getHeight(); y += 12){
                for (int x = 0; x < image.getWidth(); x += 12){
                    int pxcolor = image.getRGB(x,y);
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream("D:\\F\\img\\temp.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
    };
    public static void main(String args[]){
        CreateImg.createFongImg("D:\\F\\img\\abc.jpg");
        System.out.println("OK");
    }
}
