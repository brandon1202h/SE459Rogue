package se459rogue.assets.item.food;

import se459rogue.assets.util.Hitbox;
import se459rogue.assets.util.Position;

public class Food {
    Hitbox hitbox;
    boolean collected = false;
    Position position;
    
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
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
