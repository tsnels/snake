import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Menu extends JFrame implements ActionListener {

    private JFrame menuFrame;
    JButton play;
    JButton play2;

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
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
    }

    public void setButton(){
        play = new JButton();
        play.setText("level 1");
        play.setBounds(120,50,100,50);
//        play.setFont(new Font("ink free", Font.BOLD, 30));
//        play.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play.setBackground(Color.ORANGE);
        play.setFocusable(false);
        play.addActionListener(this);
        menuFrame.add(play);

        play2 = new JButton();
        play2.setText("level 2");
        play2.setFocusable(false);
        play2.setBounds(120,150,100,50);
//        play.setFont(new Font("ink free", Font.BOLD, 30));
//        play2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play2.setBackground(Color.ORANGE);
        play2.addActionListener(this);
        menuFrame.add(play2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play) {
            new GameFrame(true);
            menuFrame.dispose();
        }
        if(e.getSource() == play2) {
            new GameFrame(false);
            menuFrame.dispose();
        }
    }
}