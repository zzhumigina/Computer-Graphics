/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Color;

/**
 *
 * @author Zhumigina Yevgenia
 */
public class HistogramDialog extends javax.swing.JDialog {

    /**
     * Creates new form HistogramDialog
     */
    public HistogramDialog(java.awt.Frame parent, boolean modal, float[][] rgb, float[][] hsv) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        histogramPanelR.setHistogram(rgb[0], Color.RED, 1);
        histogramPanelG.setHistogram(rgb[1], Color.GREEN, 1);
        histogramPanelB.setHistogram(rgb[2], Color.BLUE, 1);
        histogramPanelHue.setHistogramHue(hsv[0]);
        histogramPanelS.setHistogram(hsv[1], Color.BLACK, 2);
        histogramPanelV.setHistogram(hsv[2], Color.BLACK, 2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        histogramPanelR = new HistogramPanel();
        histogramPanelG = new HistogramPanel();
        histogramPanelB = new HistogramPanel();
        histogramPanelS = new HistogramPanel();
        histogramPanelV = new HistogramPanel();
        histogramPanelHue = new HistogramPanelHue();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        histogramPanelR.setMaximumSize(new java.awt.Dimension(255, 150));
        histogramPanelR.setPreferredSize(new java.awt.Dimension(255, 150));

        javax.swing.GroupLayout histogramPanelRLayout = new javax.swing.GroupLayout(histogramPanelR);
        histogramPanelR.setLayout(histogramPanelRLayout);
        histogramPanelRLayout.setHorizontalGroup(
            histogramPanelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        histogramPanelRLayout.setVerticalGroup(
            histogramPanelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        histogramPanelG.setMaximumSize(new java.awt.Dimension(255, 150));
        histogramPanelG.setPreferredSize(new java.awt.Dimension(255, 150));

        javax.swing.GroupLayout histogramPanelGLayout = new javax.swing.GroupLayout(histogramPanelG);
        histogramPanelG.setLayout(histogramPanelGLayout);
        histogramPanelGLayout.setHorizontalGroup(
            histogramPanelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        histogramPanelGLayout.setVerticalGroup(
            histogramPanelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        histogramPanelB.setMaximumSize(new java.awt.Dimension(255, 150));
        histogramPanelB.setPreferredSize(new java.awt.Dimension(255, 150));

        javax.swing.GroupLayout histogramPanelBLayout = new javax.swing.GroupLayout(histogramPanelB);
        histogramPanelB.setLayout(histogramPanelBLayout);
        histogramPanelBLayout.setHorizontalGroup(
            histogramPanelBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        histogramPanelBLayout.setVerticalGroup(
            histogramPanelBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        histogramPanelS.setMaximumSize(new java.awt.Dimension(200, 150));
        histogramPanelS.setPreferredSize(new java.awt.Dimension(200, 150));

        javax.swing.GroupLayout histogramPanelSLayout = new javax.swing.GroupLayout(histogramPanelS);
        histogramPanelS.setLayout(histogramPanelSLayout);
        histogramPanelSLayout.setHorizontalGroup(
            histogramPanelSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        histogramPanelSLayout.setVerticalGroup(
            histogramPanelSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        histogramPanelV.setMaximumSize(new java.awt.Dimension(200, 150));
        histogramPanelV.setPreferredSize(new java.awt.Dimension(200, 150));

        javax.swing.GroupLayout histogramPanelVLayout = new javax.swing.GroupLayout(histogramPanelV);
        histogramPanelV.setLayout(histogramPanelVLayout);
        histogramPanelVLayout.setHorizontalGroup(
            histogramPanelVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        histogramPanelVLayout.setVerticalGroup(
            histogramPanelVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        histogramPanelHue.setMaximumSize(new java.awt.Dimension(360, 150));
        histogramPanelHue.setMinimumSize(new java.awt.Dimension(360, 150));

        javax.swing.GroupLayout histogramPanelHueLayout = new javax.swing.GroupLayout(histogramPanelHue);
        histogramPanelHue.setLayout(histogramPanelHueLayout);
        histogramPanelHueLayout.setHorizontalGroup(
            histogramPanelHueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        histogramPanelHueLayout.setVerticalGroup(
            histogramPanelHueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(histogramPanelR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(histogramPanelG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(histogramPanelB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(histogramPanelHue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(histogramPanelS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(histogramPanelV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(histogramPanelB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(histogramPanelG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(histogramPanelR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(histogramPanelS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(histogramPanelV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(histogramPanelHue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private HistogramPanel histogramPanelB;
    private HistogramPanel histogramPanelG;
    private HistogramPanelHue histogramPanelHue;
    private HistogramPanel histogramPanelR;
    private HistogramPanel histogramPanelS;
    private HistogramPanel histogramPanelV;
    // End of variables declaration//GEN-END:variables
}
