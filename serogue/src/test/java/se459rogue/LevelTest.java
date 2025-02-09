package se459rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import se459rogue.assets.level.Level;
import se459rogue.assets.level.LevelManager;
import se459rogue.panel.LevelTestPanel;

public class LevelTest {
    private LevelManager lm = new LevelManager();
     private List<Level> levels = new ArrayList<>();
    
    @Test
    public void levelSetupTest(){
        lm.levelSetup(levels);
        //currently should be three but should be updated later
        //when we add the actual amount of levels to the game
        assertEquals(3, levels.size());
    }

    @Test
    public void drawLevelTest(){
        lm.levelSetup(levels);
        LevelTestPanel gPanel = new LevelTestPanel(levels);

        //window settings
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Rogue");
        window.add(gPanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gPanel.activateGameThread();

        //Lines 48-68 will need to be rewrite to make it more dynamic later down the line based on the size of how many levels we generate

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        gPanel.increaseLevelCount();

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gPanel.increaseLevelCount();

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        window.setVisible(false);
        window.dispose();

        assertEquals(false, window.isActive());
    }
}
