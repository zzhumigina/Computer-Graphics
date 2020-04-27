
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Bresenham implements Figure{
    int x1, x2, y1, y2;

    Color col;
    public Bresenham(int x1, int y1, int x2, int y2, Color col){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.col = col;
    }
    
    public void paint(Graphics g){
        int x = x1;
        int y = y1;
        int dx = Math.abs(x2-x1), dy = Math.abs(y2-y1);
        int sx = Integer.compare(x2 - x1, 0);
        int sy = Integer.compare(y2 - y1, 0);
        int tx, ty;
        g.setColor(col);
        if (dx>=dy) {
            tx = sx;
            ty = 0;
        } else {
            int z=dx;
            dx=dy;
            dy=z;
            tx=0; ty=sy;
        }

        int scount = 2*dy;
        int count = scount-dx;
        int dcount = count-dx;
        for(;;) {
            dx-=1;
            if (dx<-1)
                break;
            g.drawLine(x, y, x, y);
            if (count>=0) {
                x+=sx;
                y+=sy;
                count += dcount;
            } else {
                x+=tx;
                y+=ty;
                count += scount;
            }
        }
    }    
}
