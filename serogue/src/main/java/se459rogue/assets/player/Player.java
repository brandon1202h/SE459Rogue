package se459rogue.assets.player;

public class Player {
    private int level;
    private int currentHealth;
    private int maxHealth;
    private int strength;
    private int gold;
    private int armor;
    private int experience;

    // Player constructor
    public Player() {
        // Initialize with default values
        this.level = 1;
        this.currentHealth = 100;
        this.maxHealth = 100;
        this.strength = 3;
        this.gold = 0;
        this.armor = 0;
        this.experience = 0;
    }

    // Methods to get player stats as strings

    // Method to obtain the player's level as a string
    public String getLevelString() {
        return String.valueOf(level);
    }

    // Method to obtain the player's health as a string
    public String getHealthString() {
        return currentHealth + "(" + maxHealth + ")";
    }

    // Method to obtain the player's level and experience as a string
    public String getExperienceString() {
        return level + "/" + experience;
    }

    // Method to obtain the player's strength as a string
    public String getStrengthString() {
        return String.valueOf(strength);
    }

    // Method to obtain the player's gold as a string
    public String getGoldString() {
        return String.valueOf(gold);
    }

    // Method to obtain the player's armor as a string
    public String getArmorString() {
        return String.valueOf(armor);
    }

    // Additional methods to modify the player stats, to be implemented in future sprints.
}
