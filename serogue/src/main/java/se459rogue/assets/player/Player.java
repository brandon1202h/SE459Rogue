package se459rogue.assets.player;

import java.util.ArrayList;
import java.util.List;

import se459rogue.assets.hunger.HungerStages;
import se459rogue.assets.item.Item;
import se459rogue.assets.util.Hitbox;

public class Player {
    private int level;
    private int currentHealth;
    private int maxHealth;
    private int strength;
    private int gold;
    private int armor;
    private int experience;
    private int requiredExp;
    private boolean defeated;
    private Hitbox hitbox;
    private List<Item> items;
    private int maxItems;
    private int baseStrength;
    private int baseArmor;
    private HungerStages hungerStage;
    private boolean slowDigestion;

    // Player constructor
    public Player() {
        // Initialize with default values
        this.level = 1;
        this.currentHealth = 100;
        this.maxHealth = 100;
        this.strength = 3;
        this.gold = 0;
        this.armor = 10;
        this.experience = 0;
        this.requiredExp = 2;
        this.defeated = false;
        this.hitbox = new Hitbox(0, 0, 16, 16);
        this.items = new ArrayList<>();
        this.maxItems = 5;
        this.baseStrength = 3;
        this.baseArmor = 10;
        this.hungerStage = HungerStages.STAGE_ZERO;
        this.slowDigestion = false;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    public int getRequiredExp() {
        return requiredExp;
    }

    public void setRequiredExp(int requiredExp) {
        this.requiredExp = requiredExp;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public HungerStages getHungerStage() {
        return hungerStage;
    }

    public void setHungerStage(HungerStages hungerStage) {
        this.hungerStage = hungerStage;
    }

    public boolean isSlowDigestion() {
        return slowDigestion;
    }

    public void setSlowDigestion(boolean slowDigestion) {
        this.slowDigestion = slowDigestion;
    }

}
