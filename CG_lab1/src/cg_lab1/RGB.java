/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cg_lab1;

import java.awt.Color;

public class RGB {

    private javax.swing.JSlider mRGBSliderB;
    private javax.swing.JSlider mRGBSliderG;
    private javax.swing.JSlider mRGBSliderR;
    private javax.swing.JTextField mRGBTextFieldB;
    private javax.swing.JTextField mRGBTextFieldG;
    private javax.swing.JTextField mRGBTextFieldR;

    float r = 0;
    float g = 0;
    float b = 0;

    public float getR() {
        return r;
    }

    public void setR(float r) {
        if (r < 0) {
            this.r = 0;
        } else if (r > 1) {
            this.r = 1;
        } else {
            this.r = r;
        }
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        if (g < 0) {
            this.g = 0;
        } else if (g > 1) {
            this.g = 1;
        } else {
            this.g = g;
        }
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        if (b < 0) {
            this.b = 0;
        } else if (b > 1) {
            this.b = 1;
        } else {
            this.b = b;
        }
    }

    public Color getColor() {
        return new Color(Math.round(r * 255),
                Math.round(g * 255),
                Math.round(b * 255));
    }

    public RGB(javax.swing.JSlider mRGBSliderB,
            javax.swing.JSlider mRGBSliderG,
            javax.swing.JSlider mRGBSliderR,
            javax.swing.JTextField mRGBTextFieldB,
            javax.swing.JTextField mRGBTextFieldG,
            javax.swing.JTextField mRGBTextFieldR) {
        this.mRGBSliderR = mRGBSliderR;
        this.mRGBSliderG = mRGBSliderG;
        this.mRGBSliderB = mRGBSliderB;
        this.mRGBTextFieldR = mRGBTextFieldR;
        this.mRGBTextFieldG = mRGBTextFieldG;
        this.mRGBTextFieldB = mRGBTextFieldB;
    }

}
