package se459rogue.assets.monster;

import se459rogue.assets.util.Hitbox;
import se459rogue.assets.util.Position;

public class Monster {
    private String symbol;
    private int health;
    private int attack;
    private int defence;
    private int pathfinding;
    private int exp;
    private Position position;
    private boolean defeated;
    private Hitbox hitbox;

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getAttack() {
        return attack;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public int getDefence() {
        return defence;
    }
    
    public void setDefence(int defence) {
        this.defence = defence;
    }
    
    public int getPathfinding() {
        return pathfinding;
    }
    
    public void setPathfinding(int pathfinding) {
        this.pathfinding = pathfinding;
    }
    
    public int getExp() {
        return exp;
    }
    
    public void setExp(int exp) {
        this.exp = exp;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

}
