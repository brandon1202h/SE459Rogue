package se459rogue.assets.util;

public class Hitbox {
    private int x,y;
    private float width, height;

    public Hitbox(int x, int y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean intersects(Hitbox other) {
        return x < other.x + other.width &&
               x + width > other.x &&
               y < other.y + other.height &&
               y + height > other.y;
    }

}
