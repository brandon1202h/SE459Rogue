package se459rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import se459rogue.assets.room.Room;
import se459rogue.assets.room.RoomManager;
import se459rogue.panel.DrawRoomTestPanel;

public class RoomTest {
    private RoomManager rm = new RoomManager();
    private List<Room> rooms = new ArrayList<>();

    @Test
    public void createRoomTest(){
        for(int x = 0; x < 6; x++){
            rooms.add(rm.createRoom(x));
        }
        assertEquals(6, rooms.size());
    }

    @Test
    public void drawRoomTest(){
        for(int x = 0; x < 6; x++){
            rooms.add(rm.createRoom(x));
        }

        DrawRoomTestPanel gPanel = new DrawRoomTestPanel(rooms);
        
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
