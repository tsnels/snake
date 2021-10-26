import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Menu extends JFrame implements ActionListener {

    private JFrame menuFrame;

    public Menu(int aantalAppels){
        this();
    }

    public Menu() {
        initialize();
        setButton();
    }

    public void initialize(){
        this.menuFrame = new JFrame();
        this.setBackground(Color.BLACK);
        menuFrame.setTitle("Menu");
        menuFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        menuFrame.setSize(1000, 1000);
        menuFrame.setVisible(true);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
    }

    public void setButton(){
        JButton play = new JButton("Play");
        play.setBounds(120,50,100,50);
        play.setFont(new Font("ink free", Font.BOLD, 30));
        play.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        play.setBackground(Color.ORANGE);
        play.addActionListener(this);
        menuFrame.add(play);

//        JButton play2 = new JButton("Play (no walls)");
//        play2.setBounds(300,50,200,50);
//        play.setFont(new Font("ink free", Font.BOLD, 30));
//        play.setBorder(BorderFactory.createLineBorder(Color.black, 3));
//        play.setBackground(Color.ORANGE);
//        play.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GameFrame();
        menuFrame.dispose();
    }

}