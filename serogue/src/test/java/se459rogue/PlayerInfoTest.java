package se459rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import se459rogue.assets.player.Player;
import se459rogue.panel.PlayerInfoTestPanel;

public class PlayerInfoTest {
    private Player player = new Player();

    @Test
    public void playerInforDisplayTest(){
        PlayerInfoTestPanel gPanel = new PlayerInfoTestPanel(player);

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
