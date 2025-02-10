package se459rogue.assets.level;

import java.util.List;

import se459rogue.assets.room.Room;

public class Level {
    private int level;
    private int numberOfRooms;
    private int tiles;
    private List<Room> rooms;

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getTiles() {
        return this.tiles;
    }

    public void setTiles(int tiles) {
        this.tiles = tiles;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


}
