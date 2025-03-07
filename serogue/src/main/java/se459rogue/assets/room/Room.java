package se459rogue.assets.room;

import java.util.List;

import se459rogue.assets.item.Item;
import se459rogue.assets.item.gold.Gold;
import se459rogue.assets.monster.Monster;
import se459rogue.assets.util.Position;

public class Room {
    Position position;
    private int height;
    private int width;
    private List<Position> doors;
    private Monster monster;
    private Item item;
    private Gold gold;

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

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }
}
