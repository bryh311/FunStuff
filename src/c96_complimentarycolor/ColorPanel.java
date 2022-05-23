package c96_complimentarycolor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends JPanel implements ActionListener {
    JButton button;
    JLabel label1;
    JLabel label2;
    public ColorPanel() {
        this.setLayout(null);
        button  = new JButton("Pick a color");
        button.setSize(150,50);
        button.setLocation(325,50);
        label1 = new JLabel("Original Color", SwingConstants.CENTER);
        label1.setSize(400,100);
        label1.setVerticalTextPosition(3);
        label1.setLocation(0,150);
        label2 = new JLabel("Complementary Color", SwingConstants.CENTER);
        label2.setLocation(400,150);
        label2.setSize(400,100);
        button.addActionListener(this);
        add(button);
        add(label1);
        add(label2);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
            Color color2;
            color2 = new Color(255-color.getRed(), 255-color.getGreen(),255-color.getBlue());
            label1.setBackground(color);
            label1.setForeground(color2);
            label1.setOpaque(true);
            label2.setBackground(color2);
            label2.setForeground(color);
            label2.setOpaque(true);
            label1.setToolTipText("RGB: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue());
            label2.setToolTipText("RGB: " + color2.getRed() + ", " + color2.getGreen() + ", " + color2.getBlue());
        }
    }

}
