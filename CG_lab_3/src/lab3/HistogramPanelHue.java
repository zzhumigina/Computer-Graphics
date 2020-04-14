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
public class HistogramPanelHue extends JPanel {

    float[] histogram;
    int height = 150;

    void setHistogramHue(float[] histogram) {
        this.histogram = histogram;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (histogram == null) {
            return;
        }
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, histogram.length, height);
        float max = 0;
        for (int i = 0; i < histogram.length; ++i) {
            if (histogram[i] > max) {
                max = histogram[i];
            }
        }
        for (int i = 0; i < histogram.length; ++i) {
            float[] rgb = Filters.HSVtoRGB(i, 100, 100);
            int R = Math.round(rgb[0]);
            int G = Math.round(rgb[1]);
            int B = Math.round(rgb[2]);
            int value = 0xFF000000 | (R << 16) | (G << 8) | B;
            g.setColor(new Color(value));
            g.drawLine(i, height, i, height - Math.round((float) height * histogram[i] / max));
        }
    }
}
