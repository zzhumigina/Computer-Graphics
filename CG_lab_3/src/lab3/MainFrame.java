/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Dimension;
import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Zhumigina Yevgenia
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("Image filters");
        imagePanel = new ImagePanel();
        imagePanel.setLayout(null);
        imagePanel.setSize(new Dimension(500, 500));
        this.setResizable(false);
        this.getContentPane().add(imagePanel);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterGroup = new javax.swing.ButtonGroup();
        colorSchemaGroup = new javax.swing.ButtonGroup();
        loadImageButton = new javax.swing.JButton();
        segSpinner = new javax.swing.JSpinner();
        segButton = new javax.swing.JRadioButton();
        //GaussButton = new javax.swing.JRadioButton();
        //GaussSpinner = new javax.swing.JSpinner();
        performButton = new javax.swing.JButton();
        equalButton = new javax.swing.JRadioButton();
        contrastButton = new javax.swing.JRadioButton();
        RGBhist = new javax.swing.JRadioButton();
        HSVhist = new javax.swing.JRadioButton();
        histogramButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loadImageButton.setText("Load");
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        segSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        filterGroup.add(segButton);
        segButton.setSelected(true);
        segButton.setText("Segmentation");

        //filterGroup.add(GaussButton);
        //GaussButton.setText("Gauss filter");

        //GaussSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        performButton.setText("Perform");
        performButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performButtonActionPerformed(evt);
            }
        });

        filterGroup.add(equalButton);
        equalButton.setText("Histogram equalization");

        filterGroup.add(contrastButton);
        contrastButton.setText("Linear contrast");

        colorSchemaGroup.add(RGBhist);
        RGBhist.setSelected(true);
        RGBhist.setText("RGB");

        colorSchemaGroup.add(HSVhist);
        HSVhist.setText("HSV");

        histogramButton.setText("Show histogram");
        histogramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(549, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    //.addComponent(GaussButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        //.addComponent(GaussSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(segSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(segButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(equalButton)
                    .addComponent(contrastButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HSVhist)
                            .addComponent(RGBhist)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(histogramButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(performButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addComponent(loadImageButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(segButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(segSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                //.addComponent(GaussButton)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(GaussSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(equalButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RGBhist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HSVhist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contrastButton)
                .addGap(35, 35, 35)
                .addComponent(loadImageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(histogramButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(performButton)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG Images", "jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showDialog(null, "Открыть файл");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage img = ImageIO.read(chooser.getSelectedFile());
                imagePanel.setImage(img);
            } catch (Exception e) {

            }
        }


    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void performButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performButtonActionPerformed
        BufferedImage oldImage = imagePanel.getImage();
        if (oldImage == null) {
            return;
        }
        BufferedImage newImage = null;
        if (segButton.isSelected()) {
            newImage = Filters.segmentation(oldImage, (int) segSpinner.getValue());
        //} else if (GaussButton.isSelected()) {
        //    newImage = Filters.GaussFilter(oldImage, (int) GaussSpinner.getValue());
        } else if (equalButton.isSelected()) {
            if (RGBhist.isSelected()) {
                newImage = Filters.EqualizationFilterRGB(oldImage);
            } else if (HSVhist.isSelected()) {
                newImage = Filters.EqualizationFilterHSV(oldImage);
            }
        } else if (contrastButton.isSelected()) {
            newImage = Filters.LinearContrastFilter(oldImage);
        }
        imagePanel.setImage(newImage);
    }//GEN-LAST:event_performButtonActionPerformed

    private void histogramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histogramButtonActionPerformed
        BufferedImage image = imagePanel.getImage();
        if (image != null) {
            HistogramDialog hd = new HistogramDialog(this, true,
                    Filters.makeHistogramRGB(image), Filters.makeHistogramHSV(image));
            hd.setVisible(true);
        }
    }//GEN-LAST:event_histogramButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    //private javax.swing.JRadioButton GaussButton;
    //private javax.swing.JSpinner GaussSpinner;
    private javax.swing.JRadioButton HSVhist;
    private javax.swing.JRadioButton RGBhist;
    private javax.swing.JRadioButton segButton;
    private javax.swing.JSpinner segSpinner;
    private javax.swing.ButtonGroup colorSchemaGroup;
    private javax.swing.JRadioButton contrastButton;
    private javax.swing.JRadioButton equalButton;
    private javax.swing.ButtonGroup filterGroup;
    private javax.swing.JButton histogramButton;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JButton performButton;
    // End of variables declaration//GEN-END:variables
    ImagePanel imagePanel;

}
