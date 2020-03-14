/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg_lab1;


public class HSV {

    private javax.swing.JSlider mHSVSliderH;
    private javax.swing.JSlider mHSVSliderS;
    private javax.swing.JSlider mHSVSliderV;
    private javax.swing.JTextField mHSVTextFieldH;
    private javax.swing.JTextField mHSVTextFieldS;
    private javax.swing.JTextField mHSVTextFieldV;
    private RGB rgb;

    public HSV(javax.swing.JSlider mHSVSliderH,
            javax.swing.JSlider mHSVSliderS,
            javax.swing.JSlider mHSVSliderV,
            javax.swing.JTextField mHSVTextFieldH,
            javax.swing.JTextField mHSVTextFieldS,
            javax.swing.JTextField mHSVTextFieldV,
            RGB rgb) {
        this.mHSVSliderH = mHSVSliderH;
        this.mHSVSliderS = mHSVSliderS;
        this.mHSVSliderV = mHSVSliderV;
        this.mHSVTextFieldH = mHSVTextFieldH;
        this.mHSVTextFieldS = mHSVTextFieldS;
        this.mHSVTextFieldV = mHSVTextFieldV;
        this.rgb = rgb;
    }

    public void updateAll() {
        float r = rgb.getR();
        float g = rgb.getG();
        float b = rgb.getB();

        float cmax = Math.max(b, Math.max(r, g));
        float cmin = Math.min(Math.min(r, g), b);
        float delta = cmax - cmin;

        float h = 60;
        if (delta == 0) {
            h *= 0;
        } else if (cmax == r) {
            h *= (((g - b) / delta % 6));
        } else if (cmax == g) {
            h *= ((b - r) / delta) + 2;
        } else if (cmax == b) {
            h *= ((r - g) / delta) + 4;
        }
        if (h < 0) {
            h += 360;
        }

        float s = 0;
        if (cmax > 1e-3) {
            s = delta / cmax;
        }
        mHSVSliderH.setValue(Math.round(h * mHSVSliderH.getMaximum() / 360));
        mHSVSliderS.setValue(Math.round(s * mHSVSliderS.getMaximum()));
        mHSVSliderV.setValue(Math.round(cmax * mHSVSliderV.getMaximum()));
        mHSVTextFieldH.setText(String.format("%.0f", h));
        mHSVTextFieldS.setText(String.format("%.0f", s * 100));
        mHSVTextFieldV.setText(String.format("%.0f", cmax * 100));
    }

    public void textChanged() {
        float h = Float.parseFloat(mHSVTextFieldH.getText().replace(",", "."));
        float s = Float.parseFloat(mHSVTextFieldS.getText().replace(",", "."));
        float v = Float.parseFloat(mHSVTextFieldV.getText().replace(",", "."));
        try {
            h = Float.parseFloat(mHSVTextFieldH.getText().replace(",", "."));
            s = Float.parseFloat(mHSVTextFieldS.getText().replace(",", "."));
            v = Float.parseFloat(mHSVTextFieldV.getText().replace(",", "."));
            if (v >= 0 && v <= 100 && h >= 0 && h <= 360 && s >= 0 && s <= 100) {
                toRGB(h, s, v);
                mHSVSliderH.setValue(Math.round(h * mHSVSliderH.getMaximum() / 360));
                mHSVSliderS.setValue(Math.round(s / 100 * mHSVSliderS.getMaximum()));
                mHSVSliderV.setValue(Math.round(v / 100 * mHSVSliderV.getMaximum()));
            }
        } catch (Exception e) {
            mHSVTextFieldH.setText(String.format("%.0f", h));
            mHSVTextFieldS.setText(String.format("%.0f", s));
            mHSVTextFieldV.setText(String.format("%.0f", v));
        }
    }

    public void sliderChanged() {
        float h = (float)mHSVSliderH.getValue() / mHSVSliderH.getMaximum() * 360;
        float s = (float)mHSVSliderS.getValue() / mHSVSliderS.getMaximum() * 100;
        float v = (float)mHSVSliderV.getValue() / mHSVSliderV.getMaximum() * 100;
        toRGB(h, s, v);
        mHSVTextFieldH.setText(String.format("%.0f", h));
        mHSVTextFieldS.setText(String.format("%.0f", s));
        mHSVTextFieldV.setText(String.format("%.0f", v));
    }

    private void toRGB(float h, float s, float v) {
        float c = v / 100 * s / 100;
        float x = c * (1 - Math.abs(((h / 60) % 2) - 1));
        float m = v / 100  - c;
        if (h < 60) {
            rgb.setR(c + m);
            rgb.setG(x + m);
            rgb.setB(0 + m);
            return;
        } else if (h < 120) {
            rgb.setR(x + m);
            rgb.setG(c + m);
            rgb.setB(0 + m);
            return;
        } else if (h < 180) {
            rgb.setR(0 + m);
            rgb.setG(c + m);
            rgb.setB(x + m);
            return;
        } else if (h < 240) {
            rgb.setR(0 + m);
            rgb.setG(x + m);
            rgb.setB(c + m);
            return;
        } else if (h < 300) {
            rgb.setR(x + m);
            rgb.setG(0 + m);
            rgb.setB(c + m);
            return;
        } else {
            rgb.setR(c + m);
            rgb.setG(0 + m);
            rgb.setB(x + m);
            return;
        }
    }
}
