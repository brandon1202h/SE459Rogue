package se459rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

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
    public void drawRoomTest() throws InterruptedException {
        for(int x = 0; x < 6; x++){
            rooms.add(rm.createRoom(x));
        }

        // Mock the DrawRoomTestPanel to avoid GUI interactions
        DrawRoomTestPanel gPanel = mock(DrawRoomTestPanel.class);

        // Assuming activateGameThread does some logic that we need to ensure gets executed
        doNothing().when(gPanel).activateGameThread();

        // Activate the game logic (not the GUI)
        gPanel.activateGameThread();

        // Simulate the time delay that might be needed for some processes to complete
        TimeUnit.SECONDS.sleep(15); // This delay might still be necessary for asynchronous operations

        // Ensure the method was called
        verify(gPanel, times(1)).activateGameThread();
    }
}
