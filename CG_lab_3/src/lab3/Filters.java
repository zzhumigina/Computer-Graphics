/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Filters {

    public static Cluster[] clusters;

    public static Cluster[] createClusters(BufferedImage image, int k) {
        // Here the clusters are taken with specific steps,
        // so the result looks always same with same image.
        // You can randomize the cluster centers, if you like.
        Cluster[] result = new Cluster[k];
        int x = 0; int y = 0;
        int dx = image.getWidth()/k;
        int dy = image.getHeight()/k;
        for (int i=0;i<k;i++) {
            result[i] = new Cluster(i,image.getRGB(x, y));
            x+=dx; y+=dy;
        }
        return result;
    }

    public static Cluster findMinimalCluster(int rgb) {
        Cluster cluster = null;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<clusters.length;i++) {
            int distance = clusters[i].distance(rgb);
            if (distance<min) {
                min = distance;
                cluster = clusters[i];
            }
        }
        return cluster;
    }

    public static BufferedImage segmentation(BufferedImage image, int k) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage newImage = new BufferedImage(w,
                h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(image, 0, 0, null);

        clusters = createClusters(image, k);

        int[] lut = new int[w * h];
        Arrays.fill(lut, -1);

        // at first loop all pixels will move their clusters
        boolean pixelChangedCluster = true;
        // loop until all clusters are stable!
        int loops = 0;
        while (pixelChangedCluster) {
            pixelChangedCluster = false;
            loops++;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    int pixel = image.getRGB(x, y);
                    Cluster cluster = findMinimalCluster(pixel);
                    if (lut[w * y + x] != cluster.getId()) {
                        // cluster changed
                        if (lut[w * y + x] != -1) {
                            // remove from possible previous
                            // cluster
                            clusters[lut[w * y + x]].removePixel(
                                    pixel);
                        }
                        // add pixel to cluster
                        cluster.addPixel(pixel);

                        // continue looping
                        pixelChangedCluster = true;

                        // update lut
                        lut[w * y + x] = cluster.getId();
                    }
                }
            }

        }
        for( int y = 0;
        y<h ;
        y++){
            for (int x = 0; x < w; x++) {
                int clusterId = lut[w * y + x];
                newImage.setRGB(x, y, clusters[clusterId].getRGB());
            }
        }

        return newImage;
    }


    public static BufferedImage EqualizationFilterRGB(BufferedImage source) {
        BufferedImage newImage = new BufferedImage(source.getWidth(),
                source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(source, 0, 0, null);
        float[][] histogram = makeHistogramRGB(source);
        float HR = 0, HG = 0, HB = 0;
        for (int i = 0; i < 256; ++i) {
            HR += histogram[0][i];
            HG += histogram[1][i];
            HB += histogram[2][i];
        }
        for (int i = 0; i < 256; ++i) {
            histogram[0][i] /= HR;
            histogram[1][i] /= HG;
            histogram[2][i] /= HB;
        }
        float[][] Shistogram = new float[3][256];
        Shistogram[0][0] = histogram[0][0];
        Shistogram[1][0] = histogram[1][0];
        Shistogram[2][0] = histogram[2][0];
        for (int i = 1; i < 256; ++i) {
            Shistogram[0][i] = Shistogram[0][i - 1] + histogram[0][i];
            Shistogram[1][i] = Shistogram[1][i - 1] + histogram[1][i];
            Shistogram[2][i] = Shistogram[2][i - 1] + histogram[2][i];
        }
        int value, newValue, R, G, B, newR, newG, newB;
        for (int x = 0; x < source.getWidth(); ++x) {
            for (int y = 0; y < source.getHeight(); ++y) {
                value = source.getRGB(x, y);
                R = (value & 0x00FF0000) >> 16;
                G = (value & 0x0000FF00) >> 8;
                B = value & 0x000000FF;
                newR = Math.round(255 * Shistogram[0][R]);
                newG = Math.round(255 * Shistogram[1][G]);
                newB = Math.round(255 * Shistogram[2][B]);
                newValue = 0xFF000000 | (newR << 16) | (newG << 8) | newB;
                newImage.setRGB(x, y, newValue);
            }
        }
        return newImage;
    }

    public static BufferedImage EqualizationFilterHSV(BufferedImage source) {
        BufferedImage newImage = new BufferedImage(source.getWidth(),
                source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(source, 0, 0, null);
        float[][] histogram = makeHistogramHSV(source);
        float[] histogramV = histogram[2];
        float HV = 0;
        for (int i = 0; i < 101; ++i) {
            HV += histogramV[i];
        }
        for (int i = 0; i < 101; ++i) {
            histogramV[i] /= HV;
        }
        float[] Shistogram = new float[101];
        Shistogram[0] = histogramV[0];
        for (int i = 1; i < 101; ++i) {
            Shistogram[i] = Shistogram[i - 1] + histogramV[i];

        }
        int value, newValue, R, G, B, newR, newG, newB;
        float H, S, V;
        float[] hsv;
        float[] rgb;
        for (int x = 0; x < source.getWidth(); ++x) {
            for (int y = 0; y < source.getHeight(); ++y) {
                value = source.getRGB(x, y);
                R = (value & 0x00FF0000) >> 16;
                G = (value & 0x0000FF00) >> 8;
                B = value & 0x000000FF;

                hsv = RGBtoHSV(R, G, B);
                
                H = hsv[0];
                S = hsv[1];
                V = 100 * Shistogram[Math.round(hsv[2])];

                rgb = HSVtoRGB(H, S, V);

                newR = Math.round(rgb[0]);
                newG = Math.round(rgb[1]);
                newB = Math.round(rgb[2]);
                
                newValue = 0xFF000000 | (newR << 16) | (newG << 8) | newB;
                newImage.setRGB(x, y, newValue);
            }
        }
        return newImage;
    }

    public static BufferedImage LinearContrastFilter(BufferedImage source) {
        BufferedImage newImage = new BufferedImage(source.getWidth(),
                source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(source, 0, 0, null);
        int value, newValue, R, G, B, newR, newG, newB;
        int maxR = 0, maxG = 0, maxB = 0;
        int minR = 255, minG = 255, minB = 255;
        for (int x = 0; x < source.getWidth(); ++x) {
            for (int y = 0; y < source.getHeight(); ++y) {
                value = source.getRGB(x, y);
                R = (value & 0x00FF0000) >> 16;
                G = (value & 0x0000FF00) >> 8;
                B = value & 0x000000FF;
                minR = Math.min(R, minR);
                maxR = Math.max(R, maxR);
                minG = Math.min(G, minG);
                maxG = Math.max(G, maxG);
                minB = Math.min(B, minB);
                maxB = Math.max(B, maxB);
            }
        }
        for (int x = 0; x < source.getWidth(); ++x) {
            for (int y = 0; y < source.getHeight(); ++y) {
                value = source.getRGB(x, y);
                R = (value & 0x00FF0000) >> 16;
                G = (value & 0x0000FF00) >> 8;
                B = value & 0x000000FF;
                newR = Math.round(255f / (maxR - minR) * (R - minR));
                newG = Math.round(255f / (maxG - minG) * (G - minG));
                newB = Math.round(255f / (maxB - minB) * (B - minB));
                newValue = 0xFF000000 | (newR << 16) | (newG << 8) | newB;
                newImage.setRGB(x, y, newValue);
            }
        }
        return newImage;
    }

    public static float[][] makeHistogramRGB(BufferedImage source) {
        float[][] histogram = new float[3][256];
        int R, G, B, value;
        for (int x = 0; x < source.getWidth(); ++x) {
            for (int y = 0; y < source.getHeight(); ++y) {
                value = source.getRGB(x, y);
                R = (value & 0x00FF0000) >> 16;
                G = (value & 0x0000FF00) >> 8;
                B = value & 0x000000FF;
                histogram[0][R]++;
                histogram[1][G]++;
                histogram[2][B]++;
            }
        }
        return histogram;
    }

    public static float[][] makeHistogramHSV(BufferedImage source) {
        float[][] histogram = new float[3][];
        histogram[0] = new float[361];
        histogram[1] = new float[101];
        histogram[2] = new float[101];
        int R, G, B, H, S, V, value;
        float[] hsv = new float[3];
        for (int x = 0; x < source.getWidth(); ++x) {
            for (int y = 0; y < source.getHeight(); ++y) {
                value = source.getRGB(x, y);
                R = (value & 0x00FF0000) >> 16;
                G = (value & 0x0000FF00) >> 8;
                B = value & 0x000000FF;

                hsv = RGBtoHSV(R, G, B);

                H = Math.round(hsv[0]);
                S = Math.round(hsv[1]);
                V = Math.round(hsv[2]);

                histogram[0][H]++;
                histogram[1][S]++;
                histogram[2][V]++;
            }
        }
        return histogram;
    }

    public static float[] RGBtoHSV(float R, float G, float B) {

        float r = R / 255;
        float g = G / 255;
        float b = B / 255;

        float min, max, delta;

        min = Math.min(Math.min(r, g), b);
        max = Math.max(Math.max(r, g), b);

        float h = 0, s, v = max;

        delta = max - min;

        if (delta != 0) {
            if (max == r) {
                h = 60 * (((g - b) / delta) % 6);
            } else if (max == g) {
                h = 60 * (((b - r) / delta) + 2);
            } else if (max == b) {
                h = 60 * (((r - g) / delta) + 4);
            }
            if (h < 0){
                h += 360;
            }
        }

        if (max == 0){
            s = 0;
        }
        else{
            s = delta / max;
        }
        
        return new float[]{h, s * 100, v * 100};
    }

    public static float[] HSVtoRGB(float H, float S, float V) {

        float R, G, B;

        H /= 360f;
        S /= 100f;
        V /= 100f;

        if (S == 0) {
            R = V * 255;
            G = V * 255;
            B = V * 255;
        } else {
            float var_h = H * 6;
            if (var_h == 6) {
                var_h = 0;
            }
            int var_i = (int) Math.floor((double) var_h);
            float var_1 = V * (1 - S);
            float var_2 = V * (1 - S * (var_h - var_i));
            float var_3 = V * (1 - S * (1 - (var_h - var_i)));

            float var_r;
            float var_g;
            float var_b;
            if (var_i == 0) {
                var_r = V;
                var_g = var_3;
                var_b = var_1;
            } else if (var_i == 1) {
                var_r = var_2;
                var_g = V;
                var_b = var_1;
            } else if (var_i == 2) {
                var_r = var_1;
                var_g = V;
                var_b = var_3;
            } else if (var_i == 3) {
                var_r = var_1;
                var_g = var_2;
                var_b = V;
            } else if (var_i == 4) {
                var_r = var_3;
                var_g = var_1;
                var_b = V;
            } else {
                var_r = V;
                var_g = var_1;
                var_b = var_2;
            }

            R = var_r * 255;
            G = var_g * 255;
            B = var_b * 255;
        }

        
        return new float[] {R, G, B};
    }

}
