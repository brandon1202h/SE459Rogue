package se459rogue.assets.combat;

import se459rogue.assets.monster.Monster;
import se459rogue.assets.player.PlayerManager;

public class Combat {
    
    public void startCombat(PlayerManager pm, Monster monster, int order){
        if(pm.getPlayer().getHitbox().intersects(monster.getHitbox())){
            if(order == 1){
                monster.setHealth(monster.getHealth() - pm.getPlayer().getStrength());
                if(monster.getHealth() > 0){
                    pm.getPlayer().setCurrentHealth(pm.getPlayer().getCurrentHealth() - monster.getAttack());
                }else{
                   monster.setDefeated(true);
                   pm.getPlayer().setExperience(pm.getPlayer().getExperience() + monster.getExp());
                   playerLevelUp(pm);
                }
            }else{
                pm.getPlayer().setCurrentHealth(pm.getPlayer().getCurrentHealth() - monster.getAttack());
                if(pm.getPlayer().getCurrentHealth() > 0){
                    monster.setHealth(monster.getHealth() - pm.getPlayer().getStrength());
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
}
