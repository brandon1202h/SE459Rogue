package se459rogue.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import se459rogue.assets.player.Player;

public class PlayerInfoTestPanel extends JPanel implements Runnable{
    //Screen Settings
    final int orginalTitleSize = 16; //16 X 16 tile
    final int scale = 3;
    final int tileSize = orginalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    private Player player = new Player();

    Thread gameThread;

    public PlayerInfoTestPanel(Player player){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.player = player;
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
        drawPlayerStats(graphics2d);
    }

    public void drawPlayerStats(Graphics2D g2) {
        g2.setColor(Color.YELLOW);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 14));
        int y = screenHeight - 10; // Prevent clipping at the bottom

        // Calculate spacing based on screen width and number of stats
        int space = screenWidth / 6;
        g2.drawString("Level: " + player.getLevelString(), 10, y);
        g2.drawString("Hits: " + player.getHealthString(), space, y);
        g2.drawString("Str: " + player.getStrengthString(), space * 2, y);
        g2.drawString("Gold: " + player.getGoldString(), space * 3, y);
        g2.drawString("Armor: " + player.getArmorString(), space * 4, y);
        g2.drawString("Exp: " + player.getExperienceString(), space * 5, y);
    }


}
