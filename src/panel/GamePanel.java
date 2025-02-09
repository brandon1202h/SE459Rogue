package panel;

import javax.swing.JPanel;

import assets.level.Level;
import assets.level.LevelManager;
import assets.room.RoomManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int orginalTitleSize = 16; //16 X 16 tile
    final int scale = 3;
    final int tileSize = orginalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    
    private LevelManager lm = new LevelManager();
    private RoomManager rm = new RoomManager();
    private List<Level> levels = new ArrayList<>();
    private int levelCount = 0;

    //Start thread to start the game time
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
        lm.levelSetup(levels);
        gameThread.start();
    }

    @Override
    public void run() {
        //game loop
        while (gameThread != null) {
            update();
            repaint();
        }
    }

    public void update(){

    }

    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        Graphics2D graphics2d = (Graphics2D) graphic;
        graphics2d.setColor(Color.WHITE);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        for(int i = 0; i < levels.get(levelCount).getNumberOfRooms(); i++){
            rm.drawRoom(levels.get(levelCount).getRooms().get(i), graphics2d);
        }
    }
   
}
