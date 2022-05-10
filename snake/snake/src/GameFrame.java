import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(boolean muren, boolean wallMoves, String level, boolean walls){

        this.add(new GamePanel(this, muren, wallMoves, level, walls));
//        this.setLayout(null);
        this.setTitle("snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}