package c107_snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {
    private final int FPS = 60;
    private final int SIZE = 40;
    private final int GRIDHW = 10;


    Timer timer;
    int xVel = 1;
    int yVel = 0;
    int frameNum = 0;
    int appleX;
    int appleY;
    boolean gameOver = false;
    boolean win = false;
    LinkedList<Snake> snakeList = new LinkedList<>();

    public SnakePanel() {
        this.setSize(new Dimension(SIZE*GRIDHW,SIZE*GRIDHW));
        this.setPreferredSize(new Dimension(SIZE*GRIDHW,SIZE*GRIDHW));
        this.setBackground(Color.BLACK);
        Random rY = new Random();
        Random rX = new Random();
        timer = new Timer(1000/FPS, this);
        timer.start();
        appleY = rY.nextInt(GRIDHW);
        appleX = rX.nextInt(GRIDHW);
        snakeList.add(new Snake(2,1));
        snakeList.add(new Snake(1,1));
        snakeList.add(new Snake(0,1));
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,SIZE*GRIDHW,SIZE*GRIDHW);
        if(!gameOver && !win) {
            g2d.setColor(Color.RED);
            g2d.fillRect(SIZE * appleX, SIZE * appleY, SIZE, SIZE);


            g.setColor(Color.BLUE);
            for (Snake s : snakeList) {
                g2d.fillRect(s.getX() * SIZE, s.getY() * SIZE, SIZE, SIZE);
            }
            g2d.setColor(Color.BLACK);
            //draw grid
            for (int row = 0; row < GRIDHW; row++)
                g2d.drawLine(row * SIZE, 0, row * SIZE, GRIDHW * SIZE);
            for (int col = 0; col < GRIDHW; col++)
                g2d.drawLine(0, col * SIZE, GRIDHW * SIZE, col * SIZE);
            g2d.setColor(Color.WHITE);
            g2d.drawString(("SCORE: " + (snakeList.size() - 3)), 10, 10);
        }
        else if(gameOver){
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g2d.drawString("GAME OVER", (this.getWidth()/2-150), this.getHeight()/2);
            g2d.drawString("Score: " + (snakeList.size()-3), this.getWidth()/2-150, this.getHeight()/2+100);
        }
        else {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g2d.drawString("YOU WIN", (this.getWidth()/2-150), this.getHeight()/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rX = new Random();
        Random rY = new Random();




        if(frameNum % 5 == 0) {
            Snake head = snakeList.getFirst();
            Snake tail = snakeList.getLast();


            for(int i = snakeList.size()-1; i > 0; i--) {
                snakeList.set(i, snakeList.get(i - 1));
            }
            snakeList.set(0, new Snake(head.getX()+xVel, head.getY()+yVel));

            if(head.getY() == appleY && head.getX() == appleX) {
                snakeList.addLast(new Snake(tail.getX(), tail.getY()));
                appleX = rX.nextInt(GRIDHW);
                appleY = rY.nextInt(GRIDHW);

            }
            head = snakeList.getFirst();
            LinkedList<Snake> body = new LinkedList<>(snakeList.subList(1, snakeList.size()));
            body.forEach(snake -> {
                if(snake.getY() == appleY && snake.getX() == appleX) {
                    appleX = rX.nextInt(GRIDHW);
                    appleY = rY.nextInt(GRIDHW);
                }
            });

            for(Snake s: body) {
                if(s.getY() == head.getY() && s.getX() == head.getX()) {
                    gameOver = true;
                }
            }
            if(head.getX() < 0 || head.getY() < 0 || head.getX() > GRIDHW || head.getY() > GRIDHW)
                gameOver = true;
            if(snakeList.size() == GRIDHW*GRIDHW)
                win = true;
        }
        this.repaint();
        frameNum++;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyChar();
        switch(key) {
            case 'w':
            case 'W':
                if(yVel == 0) {
                    yVel = -1;
                    xVel = 0;
                }
                break;
            case 's':
            case 'S':
                if(yVel == 0) {
                    yVel = 1;
                    xVel = 0;
                }
                break;
            case 'a':
            case 'A':
                if(xVel == 0) {
                    xVel = -1;
                    yVel = 0;
                }
                break;
            case 'd':
            case 'D':
                if(xVel == 0) {
                    xVel = 1;
                    yVel = 0;
                }
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
