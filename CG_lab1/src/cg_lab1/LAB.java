/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg_lab1;


public class LAB {

    private javax.swing.JSlider mLABSliderA;
    private javax.swing.JSlider mLABSliderB;
    private javax.swing.JTextField mLUVTextFieldL;
    private javax.swing.JTextField mLUVTextFieldA;
    private javax.swing.JTextField mLUVTextFieldB;
    private javax.swing.JSlider mLUVSliderL;
    private RGB rgb;

    public LAB(javax.swing.JSlider mLABSliderA,
               javax.swing.JSlider mLABSliderB,
               javax.swing.JTextField mLUVTextFieldL,
               javax.swing.JTextField mLUVTextFieldA,
               javax.swing.JTextField mLUVTextFieldB,
               javax.swing.JSlider mLUVSliderL,
               RGB rgb) {
        this.mLUVSliderL = mLUVSliderL;
        this.mLABSliderA = mLABSliderA;
        this.mLABSliderB = mLABSliderB;
        this.mLUVTextFieldL = mLUVTextFieldL;
        this.mLUVTextFieldA = mLUVTextFieldA;
        this.mLUVTextFieldB = mLUVTextFieldB;
        this.rgb = rgb;
    }

    private static double[][] mToXYZ = {
        {0.412453, 0.357580, 0.180423},
        {0.212671, 0.715160, 0.072169},
        {0.019334, 0.119193, 0.950227
        }};

    private static double[][] mFromXYZ = {
        {3.2406, -1.5372, -0.4986},
        {-0.9689, 1.8758, 0.0415},
        {0.0557, -0.2040, 1.0570}};

    private double funcRGBtoXYZ(double x) {
        if (x > 0.04045) {
            return Math.pow((x + 0.055) / 1.055, 2.4);
        }
        return x / 12.92;

    }

    private double funcXYZtoRGB(double x) {
        if (x > 0.0031308) {
            return 1.055 * Math.pow(x, 1d / 2.4) - 0.055;
        }
        return x * 12.92;
    }

    private double funcXYZtoLAB(double x) {
        if (x > 0.008856) {
            return Math.pow(x, 1d / 3);
        }
        return 7.7787 * x + 16d / 116;

    }

    private double funcLABtoXYZ(double x) {
        if (x > 0.008856) {//??
            return Math.pow(x, 3);
        }
        return (x - 16d / 116) / 7.7787;
    }

    private static double[] dot(double[][] matrix, double[] vector) {
        double[] ret = new double[3];
        for (int i = 0; i < 3; ++i) {
            ret[i] = 0;
            for (int j = 0; j < 3; ++j) {
                ret[i] += matrix[i][j] * vector[j];
            }
        }
        return ret;
    }

    private static double[] whitePoint = {95.047, 100, 108.883};

    private double[] toLAB() {
        double[] lab = new double[3];

        double[] rgbn = new double[3];
        rgbn[0] = funcRGBtoXYZ(rgb.getR()) * 100;
        rgbn[1] = funcRGBtoXYZ(rgb.getG()) * 100;
        rgbn[2] = funcRGBtoXYZ(rgb.getB()) * 100;
        double[] xyz = dot(mToXYZ, rgbn);
        //System.out.println("to X = " + xyz[0] + ", Y = " + xyz[1] + ", Z = " + xyz[2]);
        if (rgbn[0] == 0 && rgbn[1] == 0 && rgbn[2] == 0) {
            return lab;
        }


        lab[0] = 116d * funcXYZtoLAB(xyz[1] / whitePoint[1]) - 16;
        lab[1] = 500 * (funcXYZtoLAB(xyz[0]/whitePoint[0]) - funcXYZtoLAB(xyz[1]/whitePoint[1]));
        lab[2] = 200 * (funcXYZtoLAB(xyz[1]/whitePoint[1]) - funcXYZtoLAB(xyz[2]/whitePoint[2]));

        return lab;
    }

    private void toRGB(double l, double a, double b) {


        double[] xyz = new double[3];

        xyz[1] = funcLABtoXYZ((l+16)/116)*whitePoint[0];
        xyz[0] = funcLABtoXYZ(a/500 + (l+16)/116)*whitePoint[1];
        xyz[2] = funcLABtoXYZ((l+16)/116 - b/200)* whitePoint[2];

        for (int i = 0; i < 3; ++i) {
            xyz[i] /= 100;
        }
        //System.out.println("from X = " + xyz[0] + ", Y = " + xyz[1] + ", Z = " + xyz[2]);

        double[] rgbn = dot(mFromXYZ, xyz);
        rgb.setR((float) funcXYZtoRGB(rgbn[0]));
        rgb.setG((float) funcXYZtoRGB(rgbn[1]));
        rgb.setB((float) funcXYZtoRGB(rgbn[2]));
    }

    public void updateAll() {
        double[] lab = toLAB();
        mLUVTextFieldL.setText(String.format("%.0f", lab[0]));
        mLUVTextFieldA.setText(String.format("%.0f", lab[1]));
        mLUVTextFieldB.setText(String.format("%.0f", lab[2]));
        mLUVSliderL.setValue((int) Math.round(lab[0]));
        mLABSliderA.setValue((int) Math.round(lab[1]));
        mLABSliderB.setValue((int) Math.round(lab[2]));
    }

    public void textChanged() {
        double l = (double) mLUVSliderL.getValue();
        double a = (double) mLABSliderA.getValue();
        double b = (double) mLABSliderB.getValue();
        try {
            l = Double.parseDouble(mLUVTextFieldL.getText());
            a = Double.parseDouble(mLUVTextFieldA.getText());
            b = Double.parseDouble(mLUVTextFieldB.getText());
            if (l >= mLUVSliderL.getMinimum() && l <= mLUVSliderL.getMaximum()
                    && a >= mLABSliderA.getMinimum() && a <= mLABSliderA.getMaximum()
                    && b >= mLABSliderB.getMinimum() && b <= mLABSliderB.getMaximum()) {
                toRGB(l, a, b);
                mLUVSliderL.setValue((int) Math.round(l));
                mLABSliderA.setValue((int) Math.round(a));
                mLABSliderB.setValue((int) Math.round(b));
            }
        } catch (Exception e) {
            e.printStackTrace();
            mLUVTextFieldL.setText(String.format("%.0f", l));
            mLUVTextFieldA.setText(String.format("%.0f", a));
            mLUVTextFieldB.setText(String.format("%.0f", b));
        }

    }

    public void sliderChanged() {
        double l = (double) mLUVSliderL.getValue();
        double a = (double) mLABSliderA.getValue();
        double b = (double) mLABSliderB.getValue();
        toRGB(l, a, b);
        mLUVTextFieldL.setText(String.format("%.0f", l));
        mLUVTextFieldA.setText(String.format("%.0f", a));
        mLUVTextFieldB.setText(String.format("%.0f", b));
    }
}
