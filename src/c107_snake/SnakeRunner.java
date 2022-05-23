package c107_snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Queue;

public class SnakeRunner extends JFrame implements KeyListener{
    SnakePanel snake = new SnakePanel();

    public static void main(String[] args) {
        SnakeRunner s = new SnakeRunner();
        s.setVisible(true);
    }

    public SnakeRunner() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Snake");
        this.setSize(snake.getWidth()+17,snake.getHeight()+40);
        this.add(snake);
        this.addKeyListener(this);
        this.pack();
        this.setResizable(false);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        snake.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        snake.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        snake.keyReleased(e);
    }
}
