/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author Zhumigina Yevgenia
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JLabel {

    private BufferedImage image;
    

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        //to create grayscale image
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);  
        Graphics g = img.getGraphics();
        g.drawImage(image, 0, 0, null);
        this.image = img;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            float x1 = image.getWidth();
            float x2 = getWidth();
            float y1 = image.getHeight();
            float y2 = getHeight();
            float scale = Math.max(x1 / x2, y1 / y2);
            if (image != null) {
                Image dimg = image.getScaledInstance(Math.round(x1 / scale), Math.round(y1 / scale),
                        Image.SCALE_SMOOTH);
                g.drawImage(dimg, 0, 0, null);
            }
        }
    }

}
