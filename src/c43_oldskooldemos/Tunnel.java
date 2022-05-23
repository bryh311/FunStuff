package c43_oldskooldemos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

public class Tunnel extends JPanel implements ActionListener {
    final int FPS = 60;
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    int frameNum = 0;
    int time;
    int[][] textureRGB;
    int[][] angleTable = new int[2 * PANEL_HEIGHT][2 * PANEL_WIDTH];
    int[][] distanceTable = new int[2 * PANEL_HEIGHT][2 * PANEL_WIDTH];

    BufferedImage texture;
    ImageObserver textureObserver;


    Timer timer;

    public Tunnel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        timer = new Timer(1000/FPS, this);
        timer.start();
        try {
            File file = new File("src/c43_oldskooldemos/textures/marble-texture.jpg");
            texture = ImageIO.read(file);

        }
        catch(Exception e) {
            System.out.println("File does not exist or is not an image!");
        }
        textureRGB = new int[texture.getWidth()][texture.getHeight()];
        for(int y = 0; y < texture.getHeight(); y++)
            for(int x = 0; x < texture.getWidth(); x++) {
                textureRGB[y][x] = texture.getRGB(x,y);
            }
        for(int y = 0; y < 2 * PANEL_HEIGHT; y++)
            for(int x = 0; x < 2 * PANEL_WIDTH; x++) {
                int angle;
                int distance;
                float ratio = 32.0f;
                distance = (int) (ratio * texture.getHeight() / Math.sqrt((x - PANEL_WIDTH / 2.0) *
                        (x - PANEL_WIDTH / 2.0) + (y - PANEL_HEIGHT / 2.0) * (y - PANEL_HEIGHT / 2.0))) % texture.getHeight();
                angle = Math.abs((int)(0.5 * texture.getWidth() * Math.atan2(y - PANEL_HEIGHT / 2.0, x - PANEL_WIDTH / 2.0) / 3.1416));
                distanceTable[y][x] = distance;
                angleTable[y][x] = angle;
            }
    }

    public void paint(Graphics g) {
        int shiftX = (int) (texture.getWidth() * 1.0 * frameNum/100);
        int shiftY = (int) (texture.getHeight() * 0.25 * frameNum/100);

        int shiftLookX = (int) ((PANEL_WIDTH / 2) + (PANEL_WIDTH / 2 * Math.sin(frameNum / 16.0))) % PANEL_WIDTH;
        //System.out.print(shiftLookX);
        int shiftLookY = (int) ((PANEL_HEIGHT / 2) + (PANEL_HEIGHT / 2 * Math.sin((frameNum / 16.0) * 2.0))) % PANEL_HEIGHT;
        //System.out.println(shiftX);

        for(int y = 0; y < PANEL_HEIGHT; y++)
            for(int x = 0; x < PANEL_WIDTH; x++) {
                int color = textureRGB[Math.abs((distanceTable[(y + shiftLookY)][(x + shiftLookX)] + shiftX) % textureRGB.length)][Math.abs((angleTable[(y + shiftLookY)][(x + shiftLookX)] + shiftY) % textureRGB[0].length)];
                //int color = textureRGB[y % 256][x % 256];
                //System.out.println(color);
                g.setColor(new Color(color));
                g.drawRect(x,y,0,0);
            }
        //g.drawImage(texture, 0,0, textureObserver);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        frameNum++;
        time = frameNum * 60;
        repaint();
    }
}
