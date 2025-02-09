package se459rogue.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import se459rogue.assets.room.Room;
import se459rogue.assets.room.RoomManager;

public class DrawRoomTestPanel extends JPanel implements Runnable {
    //Screen Settings
    final int orginalTitleSize = 16; //16 X 16 tile
    final int scale = 3;
    final int tileSize = orginalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    
    private RoomManager rm = new RoomManager();
    private List<Room> rooms = new ArrayList<>();

    //Start thread to start the game time
    Thread gameThread;

    public DrawRoomTestPanel(List<Room> rms){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.rooms = rms;
    }

    public void activateGameThread(){
         //passes the Panel class to the thread constructor
         gameThread = new Thread(this);
         gameThread.start();
    }

    @Override
    public void run() {
        //game loop
        while (gameThread != null) {
            repaint();
        }
    }

    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        Graphics2D graphics2d = (Graphics2D) graphic;
        graphics2d.setColor(Color.WHITE);
        graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        for (Room room : rooms) {
            rm.drawRoom(room, graphics2d);
        }
    }
}
