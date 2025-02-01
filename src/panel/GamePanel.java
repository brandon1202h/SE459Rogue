package panel;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int orginalTitleSize = 16; //16 X 16 tile
    final int scale = 3;
    final int tileSize = orginalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //Start thread to start the game time
    //
    Thread gameThread;


    //Game panel constructor that sets the settings for the screen
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }


    public void activateGameThread(){
        //passes the GamePanel class to the thread constructor
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //game loop
        while (gameThread != null) {
            System.out.println("The game loop is running");
        }
    }
}
