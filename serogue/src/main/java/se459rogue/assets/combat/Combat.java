package se459rogue.assets.combat;

import java.util.Random;

import se459rogue.assets.item.Item;
import se459rogue.assets.item.ItemType;
import se459rogue.assets.item.armor.Armor;
import se459rogue.assets.item.weapon.Weapon;
import se459rogue.assets.monster.Monster;
import se459rogue.assets.player.PlayerManager;

public class Combat {
    
    public void startCombat(PlayerManager pm, Monster monster, int order){
        if(pm.getPlayer().getHitbox().intersects(monster.getHitbox())){
            if(order == 1){
                monster.setHealth(monster.getHealth() - pm.getPlayer().getStrength());
                weaponBreakage(pm);
                if(monster.getHealth() > 0){
                    pm.getPlayer().setCurrentHealth(pm.getPlayer().getCurrentHealth() - monster.getAttack());
                    armorBreakage(pm);
                }else{
                   monster.setDefeated(true);
                   pm.getPlayer().setExperience(pm.getPlayer().getExperience() + monster.getExp());
                   playerLevelUp(pm);
                }
            }else{
                pm.getPlayer().setCurrentHealth(pm.getPlayer().getCurrentHealth() - monster.getAttack());
                armorBreakage(pm);
                if(pm.getPlayer().getCurrentHealth() > 0){
                    monster.setHealth(monster.getHealth() - pm.getPlayer().getStrength());
                    weaponBreakage(pm);
                }else{
                    pm.getPlayer().setDefeated(true);
                }
            }
        }
    }

    private void playerLevelUp(PlayerManager pm){
        if(pm.getPlayer().getExperience() >= pm.getPlayer().getRequiredExp()){
            pm.getPlayer().setLevel(pm.getPlayer().getLevel() + 1);
            pm.getPlayer().setExperience(0);
            pm.getPlayer().setMaxHealth(pm.getPlayer().getMaxHealth() + 5);
            pm.getPlayer().setCurrentHealth(pm.getPlayer().getMaxHealth());
            pm.getPlayer().setRequiredExp(pm.getPlayer().getRequiredExp() * 2);
        }
    }

    private void weaponBreakage(PlayerManager pm){
        Weapon equipedWeapon = new Weapon();
        boolean equipedWeaponFound = false;
        int weaponIndex = 0;

        if(pm.getPlayer().getItems().size() == 0){
            return;
        }
                
        for (Item item : pm.getPlayer().getItems()) {
            if(item.getType() == ItemType.WEAPON){
                equipedWeapon  = (Weapon) item;
                if(equipedWeapon.isEquiped()){
                    weaponIndex = pm.getPlayer().getItems().indexOf(item);
                    equipedWeaponFound = true;
                    break;
                }else{
                    equipedWeapon = null;
                }
            }
        }

        Random weaponBreak = new Random();
        if(equipedWeapon != null && equipedWeaponFound){
            equipedWeapon.setHealth(equipedWeapon.getHealth() - weaponBreak.nextInt(101));
            if(equipedWeapon.getHealth() <=0){
                pm.getPlayer().getItems().remove(weaponIndex);
                pm.getPlayer().setStrength(pm.getPlayer().getBaseStrength());
                pm.setWeaponBreakMessage(true);
            }else{
                Item updatedItem = equipedWeapon;
                pm.getPlayer().getItems().set(weaponIndex, updatedItem);
            }
        }
    }

    private void armorBreakage(PlayerManager pm){
        Armor equipedArmor = new Armor();
        boolean equipedArmorFound = false;
        int armorIndex = 0;

        if(pm.getPlayer().getItems().size() == 0){
            return;
        }
        
        for (Item item : pm.getPlayer().getItems()) {
            if(item.getType() == ItemType.ARMOR){
                equipedArmor = (Armor) item;
                if(equipedArmor.isEquiped()){
                    armorIndex =  pm.getPlayer().getItems().indexOf(item);
                    equipedArmorFound = true;
                    break;
                }else{
                    equipedArmor = null;
                }
            }
        }

        Random armorBreak = new Random();
        if(equipedArmor != null && equipedArmorFound){
            equipedArmor.setHealth(equipedArmor.getHealth() - armorBreak.nextInt(101));
            if(equipedArmor.getHealth() <= 0){
                pm.getPlayer().getItems().remove(armorIndex);
                pm.getPlayer().setArmor(pm.getPlayer().getBaseArmor());
                pm.setArmorBreakMessage(true);
            }else{
                Item updatedItem = equipedArmor;
                pm.getPlayer().getItems().set(armorIndex, updatedItem);
            }
        }
    }
}
