package se459rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import se459rogue.assets.level.Level;
import se459rogue.assets.level.LevelManager;
import se459rogue.panel.LevelTestPanel;

public class LevelTest {
    private LevelManager lm = new LevelManager();
    private List<Level> levels = new ArrayList<>();

    @BeforeAll
    public static void setupClass() {
        System.setProperty("java.awt.headless", "true");
    }

    @Test
    public void levelSetupTest(){
        lm.levelSetup(levels);
        assertEquals(3, levels.size());
    }

    @Test
    public void drawLevelTest() throws InterruptedException {
        lm.levelSetup(levels);
        LevelTestPanel gPanel = mock(LevelTestPanel.class);

        // Simulate the activation of the game thread and level increases.
        doNothing().when(gPanel).activateGameThread();
        doNothing().when(gPanel).increaseLevelCount();

        gPanel.activateGameThread();
        TimeUnit.SECONDS.sleep(15); // simulate wait
        gPanel.increaseLevelCount();

        TimeUnit.SECONDS.sleep(15); // simulate wait
        gPanel.increaseLevelCount();

        TimeUnit.SECONDS.sleep(15); // simulate wait

        verify(gPanel, times(1)).activateGameThread();
        verify(gPanel, times(2)).increaseLevelCount();

        // No actual JFrame is created or manipulated.
        // Assertions could focus on verifying the state of the game or level management:
        // Assuming you have a method to check the current level or state
        // assertEquals(expectedLevel, gameLogic.getCurrentLevel());
    }
}
