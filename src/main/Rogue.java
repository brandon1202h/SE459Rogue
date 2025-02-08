package main;
import javax.swing.JFrame;

import panel.GamePanel;

public class Rogue {
    public static void main(String[] args) throws Exception {
        GamePanel gPanel = new GamePanel();
        
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
        
    }
}
