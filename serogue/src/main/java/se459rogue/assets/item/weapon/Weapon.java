package se459rogue.assets.item.weapon;

import se459rogue.assets.item.Item;

public class Weapon extends Item {
    String sb;
    int attack;
    int health;
    WeaponType weaponType;
    boolean equiped;
    
    public String getSb() {
        return sb;
    }
    public void setSb(String sb) {
        this.sb = sb;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public WeaponType getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
    public boolean isEquiped() {
        return equiped;
    }
    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
    
}
