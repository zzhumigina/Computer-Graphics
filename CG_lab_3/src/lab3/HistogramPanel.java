/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Zhumigina Yevgenia
 */
public class HistogramPanel extends JPanel {

    float[] histogram;
    final static int height = 150;
    Color color;
    int wide;

    void setHistogram(float[] histogram, Color color, int wide) {
        this.histogram = histogram;
        this.color = color;
        this.wide = wide;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, histogram.length*wide, height);
        if (histogram == null) {
            return;
        }
        g.setColor(color);
        float max = 0;
        for (int i = 0; i < histogram.length; ++i) {
            if (histogram[i] > max) {
                max = histogram[i];
            }
        }
        for (int i = 0; i < histogram.length; ++i) {
            for (int j = 0; j < wide; ++j) {
                g.drawLine(i * wide + j, height, i * wide + j, height - Math.round((float) height * histogram[i] / max));
            }
        }
    }
}
