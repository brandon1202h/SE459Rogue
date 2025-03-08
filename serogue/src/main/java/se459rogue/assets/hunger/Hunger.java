package se459rogue.assets.hunger;

import javax.swing.JOptionPane;

import se459rogue.assets.player.PlayerManager;

public class Hunger {
    
    public void hungerStageCheck(PlayerManager playerManager){
        if(playerManager.getPlayerSteps() == 300){
            playerManager.getPlayer().setHungerStage(HungerStages.STAGE_ONE);
            JOptionPane.showMessageDialog(null,"You are starting to get hungry.");
        }else if(playerManager.getPlayerSteps() == 450){
            playerManager.getPlayer().setHungerStage(HungerStages.STAGE_TWO);
            JOptionPane.showMessageDialog(null,"You are starting to feel weak.");
        }else if(playerManager.getPlayerSteps() == 500){
            playerManager.getPlayer().setHungerStage(HungerStages.STAGE_THREE);
            JOptionPane.showMessageDialog(null,"You feel very weak. You faint from the lack of food");
        }else if(playerManager.getPlayerSteps() == 600){
            playerManager.getPlayer().setHungerStage(HungerStages.STAGE_FOUR);
            playerManager.getPlayer().setDefeated(true);
            playerManager.getPlayer().setCurrentHealth(0);
            JOptionPane.showMessageDialog(null,"You died from the lack of food");
        }

    }
}
