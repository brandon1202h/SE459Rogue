package se459rogue.assets.player;

import se459rogue.assets.util.Position;

public class PlayerManager {
    private Player player;
    private Position position;
    private int tileSize;
    private int playerSteps;

    // Constructor
    public PlayerManager(int startX, int startY, int tileSize) {
        this.player = new Player();
        this.position = new Position();
        this.position.setX(startX);
        this.position.setY(startY);
        this.tileSize = tileSize;
        this.player.getHitbox().setPosition(startX, startY);
    }

    // Get Player Position
    public Position getPosition() {
        return position;
    }

    // Move Player
    public void movePlayer(int dx, int dy) {
        int newX = position.getX() + (dx * tileSize / 3);
        int newY = position.getY() + (dy * tileSize / 3);
        this.player.getHitbox().setPosition(newX, newY);

        // TODO: Add collision detection logic here
        position.setX(newX);
        position.setY(newY);

        playerSteps++;
    }

    public Player getPlayer() {
        return player;
    }

    // Player Stats Getters
    public String getLevelString() {
        return player.getLevelString();
    }

    public String getHealthString() {
        return player.getHealthString();
    }

    public String getStrengthString() {
        return player.getStrengthString();
    }

    public String getGoldString() {
        return player.getGoldString();
    }

    public String getArmorString() {
        return player.getArmorString();
    }

    public String getExperienceString() {
        return player.getExperienceString();
    }

    public int getPlayerSteps() {
        return playerSteps;
    }

    public void setPlayerSteps(int playerSteps) {
        this.playerSteps = playerSteps;
    }
    
}
