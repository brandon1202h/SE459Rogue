package se459rogue.assets.item;

import se459rogue.assets.util.Hitbox;
import se459rogue.assets.util.Position;

public class Item {
    ItemType type;
    Position position;
    Hitbox hitbox;
    boolean collected = false;
    String name;
    String inventoryName;

    public ItemType getType() {
        return type;
    }
    public void setType(ItemType type) {
        this.type = type;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Hitbox getHitbox() {
        return hitbox;
    }
    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public boolean isCollected() {
        return collected;
    }
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getInventoryName() {
        return inventoryName;
    }
    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }
    
}
