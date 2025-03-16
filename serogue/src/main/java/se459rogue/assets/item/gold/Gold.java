package se459rogue.assets.item.gold;

import se459rogue.assets.util.Hitbox;
import se459rogue.assets.util.Position;

public class Gold {
    int ammount;
    Hitbox hitbox;
    boolean collected = false;
    Position position;
    
    public int getAmmount() {
        return ammount;
    }
    public void setAmmount(int ammount) {
        this.ammount = ammount;
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
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    
}
