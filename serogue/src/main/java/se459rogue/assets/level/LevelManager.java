package se459rogue.assets.level;

import java.util.ArrayList;
import java.util.List;

import se459rogue.assets.item.ItemManager;
import se459rogue.assets.monster.MonsterManager;
import se459rogue.assets.room.Room;
import se459rogue.assets.room.RoomManager;

public class LevelManager {
    private RoomManager rm = new RoomManager();
    private MonsterManager mm = new MonsterManager();
    private ItemManager im = new ItemManager();
    
    /**
     *  A method that is used to create a new level and its corisponding rooms
     * @param level
     * @return Level
     */
    public Level createLevel(int level){
        Level newLevel = new Level();
        newLevel.setLevel(level);
        //will be changed to be random
        newLevel.setNumberOfRooms(6);
        List<Room> rooms = new ArrayList<>();
        for(int x = 0; x < 6; x++){
            rooms.add(rm.createRoom(x));
        }
        //add monster to the rooms
        mm.addMonster(level, rooms);
        //add item to the rooms
        im.addItem(rooms);
        //add gold to the rooms
        im.addGold(rooms);
        //add food to the rooms
        im.addFood(rooms);

        newLevel.setRooms(rooms);

        return newLevel;
    }

    /**
     * A method that is called that sets and stores all levels that are created for the game.
     * 
     * @param levelHolder
     */
    public void levelSetup(List<Level>levelHolder){
        levelHolder.add(createLevel(0));
        levelHolder.add(createLevel(1));
        levelHolder.add(createLevel(2));
    }
}
