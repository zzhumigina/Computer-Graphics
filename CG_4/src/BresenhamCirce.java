
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class BresenhamCirce implements Figure{
    int x, y, r;
    Color col;
    public BresenhamCirce(int x, int y, int r, Color col){
        this.x = x;
        this.y = y;
        this.r = r;
        this.col = col;
    }
    
    public void paint(Graphics g){
        int sx=0;
        int sy=r;
        int d=3-2*r;
        g.setColor(col);
        while(sx<=sy) {
            g.drawLine(x+sx, y-sy, x+sx, y-sy);
            g.drawLine(x+sx, y+sy, x+sx, y+sy);
            g.drawLine(x-sx, y-sy, x-sx, y-sy);
            g.drawLine(x-sx, y+sy, x-sx, y+sy);
            g.drawLine(x+sy, y+sx, x+sy, y+sx);
            g.drawLine(x-sy, y+sx, x-sy, y+sx);
            g.drawLine(x+sy, y-sx, x+sy, y-sx);
            g.drawLine(x-sy, y-sx, x-sy, y-sx);
            if (d<0) {
                d = d + 4 * sx + 6;
            } else {
                d = d + 4 * (sx - sy) + 10;
                sy = sy - 1;
            }
            sx += 1;
        }
    }    
}
