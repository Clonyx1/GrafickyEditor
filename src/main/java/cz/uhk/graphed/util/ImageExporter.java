package cz.uhk.graphed.util;

import cz.uhk.graphed.gui.Canvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageExporter {

    public void saveCanvasAsPng(Canvas canvas){
        BufferedImage img =  new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();

        canvas.paint(g2);

        try{
            File outputFile = new File("canvas.png");
            ImageIO.write(img, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException("Error trying to save image " + e.getMessage());
        }
    }
}
