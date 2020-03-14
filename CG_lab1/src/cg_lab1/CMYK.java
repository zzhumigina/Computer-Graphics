/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg_lab1;


public class CMYK {

    private javax.swing.JSlider mCMYKSliderB;
    private javax.swing.JSlider mCMYKSliderC;
    private javax.swing.JSlider mCMYKSliderM;
    private javax.swing.JSlider mCMYKSliderY;
    private javax.swing.JTextField mCMYKTextFieldB;
    private javax.swing.JTextField mCMYKTextFieldC;
    private javax.swing.JTextField mCMYKTextFieldM;
    private javax.swing.JTextField mCMYKTextFieldY;
    RGB rgb;

    public CMYK(javax.swing.JSlider mCMYKSliderB,
            javax.swing.JSlider mCMYKSliderC,
            javax.swing.JSlider mCMYKSliderM,
            javax.swing.JSlider mCMYKSliderY,
            javax.swing.JTextField mCMYKTextFieldB,
            javax.swing.JTextField mCMYKTextFieldC,
            javax.swing.JTextField mCMYKTextFieldM,
            javax.swing.JTextField mCMYKTextFieldY,
            RGB rgb) {
        this.mCMYKSliderC = mCMYKSliderC;
        this.mCMYKSliderM = mCMYKSliderM;
        this.mCMYKSliderY = mCMYKSliderY;
        this.mCMYKSliderB = mCMYKSliderB;
        this.mCMYKTextFieldC = mCMYKTextFieldC;
        this.mCMYKTextFieldM = mCMYKTextFieldM;
        this.mCMYKTextFieldY = mCMYKTextFieldY;
        this.mCMYKTextFieldB = mCMYKTextFieldB;
        this.rgb = rgb;

    }

    public void updateAll() {
        float r = rgb.getR();
        float g = rgb.getG();
        float b = rgb.getB();
        float chB = 1 - Math.max(Math.max(r, b), g);
        mCMYKSliderB.setValue(Math.round(chB * mCMYKSliderB.getMaximum()));
        mCMYKSliderC.setValue(Math.round((1 - r - chB) / (1 - chB) * mCMYKSliderC.getMaximum()));
        mCMYKSliderM.setValue(Math.round((1 - g - chB) / (1 - chB) * mCMYKSliderM.getMaximum()));
        mCMYKSliderY.setValue(Math.round((1 - b - chB) / (1 - chB) * mCMYKSliderY.getMaximum()));

        mCMYKTextFieldC.setText(String.format("%.3f", (float) mCMYKSliderC.getValue() / mCMYKSliderC.getMaximum()));
        mCMYKTextFieldM.setText(String.format("%.3f", (float) mCMYKSliderM.getValue() / mCMYKSliderM.getMaximum()));
        mCMYKTextFieldY.setText(String.format("%.3f", (float) mCMYKSliderY.getValue() / mCMYKSliderY.getMaximum()));
        mCMYKTextFieldB.setText(String.format("%.3f", (float) mCMYKSliderB.getValue() / mCMYKSliderB.getMaximum()));
    }

    public void sliderChanged() {
        float k = (float) mCMYKSliderB.getValue() / mCMYKSliderB.getMaximum();

        rgb.setR((1 - (float) mCMYKSliderC.getValue() / mCMYKSliderC.getMaximum()) * (1 - k));
        rgb.setG((1 - (float) mCMYKSliderM.getValue() / mCMYKSliderM.getMaximum()) * (1 - k));
        rgb.setB((1 - (float) mCMYKSliderY.getValue() / mCMYKSliderY.getMaximum()) * (1 - k));

        mCMYKTextFieldC.setText(String.format("%.3f", (float) mCMYKSliderC.getValue() / mCMYKSliderC.getMaximum()));
        mCMYKTextFieldM.setText(String.format("%.3f", (float) mCMYKSliderM.getValue() / mCMYKSliderM.getMaximum()));
        mCMYKTextFieldY.setText(String.format("%.3f", (float) mCMYKSliderY.getValue() / mCMYKSliderY.getMaximum()));
        mCMYKTextFieldB.setText(String.format("%.3f", (float) mCMYKSliderB.getValue() / mCMYKSliderB.getMaximum()));
    }

    public void textChanged() {
        float c = (float) mCMYKSliderC.getValue() / mCMYKSliderC.getMaximum();
        float m = (float) mCMYKSliderM.getValue() / mCMYKSliderM.getMaximum();
        float y = (float) mCMYKSliderY.getValue() / mCMYKSliderY.getMaximum();
        float k = (float) mCMYKSliderB.getValue() / mCMYKSliderB.getMaximum();
        try {
            c = Float.parseFloat(mCMYKTextFieldC.getText().replace(",", "."));
            m = Float.parseFloat(mCMYKTextFieldM.getText().replace(",", "."));
            y = Float.parseFloat(mCMYKTextFieldY.getText().replace(",", "."));
            k = Float.parseFloat(mCMYKTextFieldB.getText().replace(",", "."));
            if ((c >= 0 & c <= 1) && (m >= 0 & m <= 1) && (y >= 0 & y <= 1) && (k >= 0 & k <= 1)) {
                rgb.setR((1 - c) * (1 - k));
                rgb.setG((1 - m) * (1 - k));
                rgb.setB((1 - y) * (1 - k));
                mCMYKSliderB.setValue(Math.round(k * mCMYKSliderB.getMaximum()));
                mCMYKSliderC.setValue(Math.round(c * mCMYKSliderC.getMaximum()));
                mCMYKSliderM.setValue(Math.round(m * mCMYKSliderM.getMaximum()));
                mCMYKSliderY.setValue(Math.round(y * mCMYKSliderY.getMaximum()));
            }
        } catch (Exception e) {
            mCMYKTextFieldC.setText(String.format("%.3f", c));
            mCMYKTextFieldM.setText(String.format("%.3f", m));
            mCMYKTextFieldY.setText(String.format("%.3f", y));
            mCMYKTextFieldB.setText(String.format("%.3f", k));
            System.out.println("incorrect value  CMYK");
        }
    }

}
