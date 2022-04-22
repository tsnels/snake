import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.AlreadyConnectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    GameFrame gameFrame;
    static final int SCREEN_WIDTH = 1200;
    static final int SCREEN_HEIGHT = 700;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static int DELAY = 60;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 8;
    int applesEaten;
    int appleX;
    int appleY;
    int wallX[] = new int[]{UNIT_SIZE * 10, UNIT_SIZE * 11, UNIT_SIZE * 12, UNIT_SIZE * 13, UNIT_SIZE * 14, UNIT_SIZE * 15, UNIT_SIZE * 18, UNIT_SIZE * 19, UNIT_SIZE * 20, UNIT_SIZE * 21, UNIT_SIZE * 22, UNIT_SIZE * 23};
    int wallY[] = new int[] {UNIT_SIZE * 10, UNIT_SIZE * 17};
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;



    GamePanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }



    public void startGame() {
//        newWall();
        DELAY = 60;
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
//                for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
//                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//                    g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//                }
                g.setColor(Color.red);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.white);
            for (var i = 0; i < (wallX.length); i++) {
                for (var ii = 0; ii < (wallY.length); ii++) {
                    g.fillOval(wallX[i], wallY[ii], UNIT_SIZE, UNIT_SIZE);
                }
            }


                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(Color.green);
                        g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        g.setColor(new Color(45, 180, 0));
//                        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            g.setColor(Color.white);
            g.setFont( new Font("ink free", Font.BOLD, 35));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
            } else {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        boolean appleInWall = false;
        do {
            for (var i = 0; i < wallX.length; i++) {
                for (var ii = 0; ii < wallY.length; ii++) {
                    if (appleX == wallX[i] && appleY == wallY[ii]) {
                        appleInWall = true;
                        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
                        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
                    }
                }
        }} while (appleInWall == true);

    }

//    public void newWall() {
//        wallX = new int[]{UNIT_SIZE * 10, UNIT_SIZE * 11, UNIT_SIZE * 12};
//        wallY = new int[]{UNIT_SIZE * 10, UNIT_SIZE * 11, UNIT_SIZE * 12};
//    }


    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }
    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts ++;
            applesEaten ++;
            newApple();
            if (applesEaten == 10) {
                DELAY -= 10;
            }
        }
    }

    public void checkCollisions() {
        // checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i] && y[0] == y[i])) {
                running = false;
            }
        }
        // checks if head touches a white wall.
        for (var i = 0; i < wallX.length; i++) {
            for (var ii = 0; ii < wallY.length; ii++) {
                if (x[0] == wallX[i] && y[0] == wallY[ii]) {
                    running = false;
                }
            }
        }


        // checks if head touches left border.
        if (x[0] < 0) {
            running = false;
        }
        //check if head touches richt border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        // check if head touches top border
        if (y[0] < 0) {
            running = false;
        }
        // check if head touches bottom
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // Game over txt
        g.setColor(Color.red);
        g.setFont( new Font("ink free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT/2);
        // score bij game over text
        g.setColor(Color.red);
        g.setFont( new Font("ink free", Font.BOLD, 40));
        FontMetrics metric2 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        //play again

        new Menu(applesEaten);
        gameFrame.dispose();

//        JFrame f=new JFrame("Button Example");
//        JButton b=new JButton("Click Here");
//        b.setBounds(50,100,95,30);
//        f.add(b);
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }

        }
    }
}
