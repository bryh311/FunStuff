package c134_ulamspiral;

import javax.swing.*;
import java.awt.*;

public class SpiralPanel extends JPanel {
    int[] primes;


    SpiralPanel(int length) {
        this.setPreferredSize(new Dimension(500,500));
        primes = new Spiral(length).getPrimeList();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        int dx = 0;
        int dy = -1;
        int i = 0;
        int x = 0;
        int y = 0;
        boolean sneed = false;
        while(true) {
            if (primes[i] != 0) {
                g.drawLine(x + 250, y + 250, x + 250, y + 250);
                //g.drawRect(x+250,y+250,3,3);
            }
            i++;
            if( (x == y) || ((x < 0) && (x == -y)) || ((x > 0) && (x == 1-y))){
                int t = dx;
                dx = -dy;
                dy = t;
            }


            //System.out.println(x + " " + y);
            x += dx;
            y += dy;
            if (i == primes.length - 1)
                break;

        }

    }

}
