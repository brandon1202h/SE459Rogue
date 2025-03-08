package se459rogue.panel;

import se459rogue.assets.player.PlayerManager;
import se459rogue.assets.util.Position;
import se459rogue.assets.item.Item;
import se459rogue.assets.item.ItemManager;
import se459rogue.assets.level.Level;
import se459rogue.assets.level.LevelManager;
import se459rogue.assets.monster.MonsterManager;
import se459rogue.assets.room.RoomManager;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    // Initialize PlayerManager to handle movement
    private PlayerManager playerManager;
    private MonsterManager monsterManager;
    private ItemManager itemManager;

    // Screen Settings
    final int originalTitleSize = 16; // 16 X 16 tile
    final int scale = 3;
    final int tileSize = originalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    
    private LevelManager lm = new LevelManager();
    private RoomManager rm = new RoomManager();
    private List<Level> levels = new ArrayList<>();
    private int levelCount = 0;
    Graphics2D graphics2d;
    boolean printInventory = false;

    // Start thread to start the game time
    Thread gameThread;

    // Game panel constructor that sets the settings for the screen
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void activateGameThread() {
        Random random = new Random();
        gameThread = new Thread(this);
        lm.levelSetup(levels);
        int xStart = (random.nextInt(levels.get(levelCount).getRooms().get(0).getWidth()) % levels.get(levelCount).getRooms().get(0).getWidth() - 2) + levels.get(levelCount).getRooms().get(0).getPosition().getX() + 1 ;
        int yStart = (random.nextInt(levels.get(levelCount).getRooms().get(0).getHeight()) % levels.get(levelCount).getRooms().get(0).getHeight() - 2) + levels.get(levelCount).getRooms().get(0).getPosition().getY() + 1 ;
        playerManager = new PlayerManager(xStart, yStart, tileSize);
        monsterManager = new MonsterManager();
        itemManager = new ItemManager();
        gameThread.start();
    }

    @Override
    public void run() {
        // Game loop
        while (gameThread != null) {
            update();
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // Future logic (collision detection, interactions, etc.)
        if(playerManager.getPlayer().isDefeated()){

        }
    }

    @Override
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        graphics2d = (Graphics2D) graphic;

        if(this.playerManager.getPlayer().getCurrentHealth() <= 0){
            drawGameOverScreen(graphics2d);
        }else{
            
            if(playerManager.isArmorBreakMessage()){
                playerManager.setArmorBreakMessage(false);
                JOptionPane.showMessageDialog(null, "Your Armor has been broken!");
            }

            if(playerManager.isWeaponBreakMessage()){
                playerManager.setWeaponBreakMessage(false);
                JOptionPane.showMessageDialog(null, "Your Weapon has been broken!");
            }
        
            // Draw rooms
            for (int i = 0; i < levels.get(levelCount).getNumberOfRooms(); i++) {
                rm.drawRoom(levels.get(levelCount).getRooms().get(i), graphics2d);
            }
    
            // Draw Player
            Position playerPos = playerManager.getPosition();
            graphics2d.setColor(Color.YELLOW);
            graphics2d.setFont(new Font("TimesRoman", Font.PLAIN, 16));
            graphics2d.drawString("@",playerPos.getX(), playerPos.getY());
    
            // Draw player stats
            drawPlayerStats(graphics2d);

            if(printInventory){
                printInventory();
            }
        

        }
    }

    public void drawPlayerStats(Graphics2D g2) {
        g2.setColor(Color.YELLOW);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 14));
        int y = screenHeight - 10; // Prevent clipping at the bottom

        // Calculate spacing based on screen width and number of stats
        int space = screenWidth / 6;
        g2.drawString("Level: " + playerManager.getLevelString(), 10, y);
        g2.drawString("Hits: " + playerManager.getHealthString(), space, y);
        g2.drawString("Str: " + playerManager.getStrengthString(), space * 2, y);
        g2.drawString("Gold: " + playerManager.getGoldString(), space * 3, y);
        g2.drawString("Armor: " + playerManager.getArmorString(), space * 4, y);
        g2.drawString("Exp: " + playerManager.getExperienceString(), space * 5, y);
    }

    private void printInventory(){
        int y = screenHeight - 550;
        int space = screenWidth / 6;
        int spacing = 20;
        graphics2d.setColor(Color.YELLOW);
        graphics2d.setFont(new Font("TimesRoman", Font.BOLD, 14));
        graphics2d.drawString("Inventory: ", 5, y);
        FontMetrics metrics = graphics2d.getFontMetrics();
        for (Item item : playerManager.getPlayer().getItems()) {
            graphics2d.drawString(item.getInventoryName(), space,  y);
            space += metrics.stringWidth(item.getInventoryName()) + spacing;
        }
        repaint();
    }


    // KeyListener Methods for Movement
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W: case KeyEvent.VK_UP:
                playerManager.movePlayer(0, -1);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
                playerManager.movePlayer(0, 1);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
                playerManager.movePlayer(-1, 0);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
                playerManager.movePlayer(1, 0);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_Y: // Diagonal Up-Left
                playerManager.movePlayer(-1, -1);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_U: // Diagonal Up-Right
                playerManager.movePlayer(1, -1);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_B: // Diagonal Down-Left
                playerManager.movePlayer(-1, 1);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_N: // Diagonal Down-Right
                playerManager.movePlayer(1, 1);
                monsterManager.moveMonster(levels.get(levelCount), playerManager);
                itemManager.collectItem(levels.get(levelCount), playerManager.getPlayer());
                itemManager.collectGold(levels.get(levelCount), playerManager.getPlayer());
                break;
            case KeyEvent.VK_I:
                if(printInventory){
                    printInventory = false;
                }else{
                    printInventory = true;
                }
                break;
            case KeyEvent.VK_1:
                itemManager.equipItem(0, playerManager.getPlayer());
                break;
            case KeyEvent.VK_2:
                itemManager.equipItem(1, playerManager.getPlayer());
                break;
            case KeyEvent.VK_3:
                itemManager.equipItem(2, playerManager.getPlayer());
                break;
            case KeyEvent.VK_4:
                itemManager.equipItem(3, playerManager.getPlayer());
                break;
            case KeyEvent.VK_5:
                itemManager.equipItem(4, playerManager.getPlayer());
                break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}


    public void drawGameOverScreen(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        String gameOverText = "Game Over!";
        
        FontMetrics fm = g.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(gameOverText)) / 2;
        int textY = getHeight() / 2 - fm.getHeight();
        g.drawString(gameOverText, textX, textY);


        /*Add back in once the restart and exit function is added */

        // g.setFont(new Font("Arial", Font.PLAIN, 20));
        // String restartText = "Press R to Restart";
        // String exitText = "Press E to Exit";
        // int restartTextX = (getWidth() - fm.stringWidth(restartText)) / 2;
        // int restartTextY = getHeight() / 2 + 3 * fm.getHeight();
        //  int exitTextX = (getWidth() - fm.stringWidth(exitText)) / 2;
        // int exitTextY = getHeight() / 2 + 5 * fm.getHeight();
        // g.drawString(restartText, restartTextX, restartTextY);
        // g.drawString(exitText, exitTextX, exitTextY);
    }


}
