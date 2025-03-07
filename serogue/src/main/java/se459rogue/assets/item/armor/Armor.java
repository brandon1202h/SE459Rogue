package se459rogue.assets.item.armor;

import se459rogue.assets.item.Item;

public class Armor extends Item{
    int health;
    int defense;
    ArmorType armorType;
    boolean equiped;

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public ArmorType getArmorType() {
        return armorType;
    }
    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
    public boolean isEquiped() {
        return equiped;
    }
    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
    
}
