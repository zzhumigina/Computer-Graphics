/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
    List<Figure> figures;
    int scale;
    
    public PaintPanel(){
        this.scale = 1;
        setScale(scale);
        figures = new ArrayList<>();
    }
    public void setScale(int scale) {
        this.scale = scale;
        this.repaint();
    }
    
    public void addFigure(Figure figure){
        figures.add(figure);
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        AffineTransform atrans = null;
        Graphics2D g2d = (Graphics2D) g;
        atrans = AffineTransform.getScaleInstance(scale, scale);
        if (atrans != null) {
            g2d.setTransform(atrans);
        }
        for(Figure f: figures){
            f.paint(g);
        }
    }
}
