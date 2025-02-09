package se459rogue.assets.room;

import java.util.List;

import se459rogue.assets.util.Position;

public class Room {
    Position position;
    private int height;
    private int width;
    private List<Position> doors;

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<Position> getDoors() {
        return this.doors;
    }

    public void setDoors(List<Position> doors) {
        this.doors = doors;
    }


}
