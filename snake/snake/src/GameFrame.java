import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(){

        this.add(new GamePanel());
        this.setTitle("snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        this.add(getButton());
    }

//    public JButton getButton(){
//        JButton b=new JButton("Speel opnieuw");
//        b.setBounds(50,100,95,30);
//        return b;
//    }
}

