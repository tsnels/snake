import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Menu extends JFrame implements ActionListener {

    private JFrame menuFrame;
    JButton play;
    JButton play1;
    JButton play2;
    JButton play3;


//    public Menu(int aantalAppels){
//        this();
//    }

    public Menu() {
        initialize();
        setButton();
    }

    public void initialize(){
        this.menuFrame = new JFrame();
//        this.setBackground(Color.BLACK);
        menuFrame.setTitle("SNAKE");
        menuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        menuFrame.setSize(1200, 700);
        menuFrame.toFront();
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
    }

    public void setButton(){
        play = new JButton();
        play.setText("level 0");
        play.setSize(new Dimension(100,50));
        play.setLocation(120, 50);
//        play.setFont(new Font("ink free", Font.BOLD, 30));
        play.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play.setBackground(Color.BLACK);
        play.setFocusable(false);
        play.addActionListener(this);
        menuFrame.add(play);

        play1 = new JButton();
        play1.setText("level 1");
        play1.setSize(new Dimension(100,50));
        play1.setLocation(120, 150);
//        play.setFont(new Font("ink free", Font.BOLD, 30));
        play1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play1.setBackground(Color.green);
        play1.setFocusable(false);
        play1.addActionListener(this);
        menuFrame.add(play1);

        play2 = new JButton();
        play2.setText("level 2");
        play2.setFocusable(false);
        play2.setSize(new Dimension(100,50));
        play2.setLocation(120, 250);
        play2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play2.setBackground(Color.ORANGE);
        play2.addActionListener(this);
        menuFrame.add(play2);

        play3 = new JButton();
        play3.setText("level 3");
        play3.setFocusable(false);
        play3.setSize(new Dimension(100,50));
        play3.setLocation(120, 350);
        play3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play3.setBackground(Color.RED);
        play3.addActionListener(this);
        menuFrame.add(play3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play) {
            new GameFrame(false, false, "level0", false);
            menuFrame.dispose();
        }

        if(e.getSource() == play1) {
            new GameFrame(true, false, "level1", false);
            menuFrame.dispose();
        }

        if(e.getSource() == play2) {
            new GameFrame(true, true, "level1", false);
            menuFrame.dispose();
        }
        if(e.getSource() == play3) {
            new GameFrame(true, false, "level2", true);
            menuFrame.dispose();
        }
    }
}