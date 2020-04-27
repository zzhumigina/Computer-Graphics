
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class LineStep implements Figure{
    int x1, x2, y1, y2;
    Color col;
    public LineStep(int x1, int y1, int x2, int y2, Color col){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.col = col;
    }
    
    public void paint(Graphics g){


        float k = -(y1 - y2)/(x2 - x1);
        float b = -(x1 * y2 - x2 * y1)/(x2 - x1);
        int L = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));

        g.setColor(col);

        if (x1 > x2){
            x1 = x2;
        }

        float x = x1;
        for (int i = 0; i < L; i++){
            x += (float)Math.abs(x2 - x1) / L;
            int _x = Math.round(x);
            int _y = Math.round(k * x + b);
            g.drawLine(_x, _y, _x, _y);
        }
    }    
}
