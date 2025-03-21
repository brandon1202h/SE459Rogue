package se459rogue.assets.item;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import se459rogue.assets.hunger.HungerStages;
import se459rogue.assets.item.armor.Armor;
import se459rogue.assets.item.food.Food;
import se459rogue.assets.item.gold.Gold;
import se459rogue.assets.item.potion.Potion;
import se459rogue.assets.item.potion.PotionType;
import se459rogue.assets.item.ring.Ring;
import se459rogue.assets.item.ring.RingType;
import se459rogue.assets.item.scroll.Scroll;
import se459rogue.assets.item.scroll.ScrollType;
import se459rogue.assets.item.weapon.Weapon;
import se459rogue.assets.level.Level;
import se459rogue.assets.player.Player;
import se459rogue.assets.player.PlayerManager;
import se459rogue.assets.room.Room;
import se459rogue.assets.util.Hitbox;
import se459rogue.assets.util.Position;

public class ItemManager {
    private ItemFactory itemFactory = new ItemFactory();
    
    public void addItem(List<Room> rooms){
        for(int x = 0; x < rooms.size(); x++){
             Random itemChance = new Random();
            
             if(itemChance.nextInt() % 2 == 0){
                rooms.get(x).setItem(itemCreation(rooms.get(x)));
            }
        }
    }

    public void addGold(List<Room> rooms){
        for(int x = 0; x < rooms.size(); x++){
            Random goldChance = new Random();
            
            if(goldChance.nextInt() % 2 == 0){
                rooms.get(x).setGold(goldCreation(rooms.get(x)));
            }
        }
    }

    public void addFood(List<Room> rooms){
        for(int x = 0; x < rooms.size(); x++){
            Random foodChance = new Random();
            
            if(foodChance.nextInt() % 2 == 0){
                rooms.get(x).setFood(foodCreation(rooms.get(x)));
            }
        }
    }

    private Item itemCreation(Room room){
        Random itemType = new Random();
        int itemCNum = 0;
        Item item = new Item();
        //case statement to add item
        //there are six cases that need to be implemented
        //those are for weapon, stick, potion, scroll, ring, and armor
        //for now we are only implementing the weapon and armor case
        //later we can add the other cases and we will change the next int boundary to 7
        
        do{
            itemCNum = itemType.nextInt(6);
        }while(itemCNum == 0);

        switch (itemCNum) {
            case 1:
                Random weaponType = new Random();
                    switch (weaponType.nextInt(5)) {
                        case 0:
                            item = itemFactory.createOneHandSword();
                            break;
                        case 1:
                            item = itemFactory.createTwoHandSword();
                            break;
                        case 2: 
                            item = itemFactory.createMace();
                            break;
                        case 3:
                            item = itemFactory.createDagger();
                            break;
                        case 4:
                            item = itemFactory.createSpear();
                            break;
                        default:
                            break;
                    }
                break;
            case 2:
                    Random armorType = new Random();
                    switch (armorType.nextInt(8)) {
                        case 0:
                            item = itemFactory.createLeatherArmor();
                            break;
                        case 1:
                            item = itemFactory.createStuddedLeatherArmor();
                            break;
                        case 2: 
                            item = itemFactory.createRingMailArmor();
                            break;
                        case 3:
                            item = itemFactory.createScaleMailArmor();
                            break;
                        case 4:
                            item = itemFactory.createChainMailArmor();
                            break;
                        case 5:
                            item = itemFactory.createBrandedMail();
                            break;
                        case 6:
                            itemFactory.createSplintMailArmor();
                            break;
                        case 7:
                            itemFactory.CreatePlateMailArmor();
                            break;
                        default:
                            break;
                    }
                break;
            case 3:
                    item = itemFactory.createRing();
                break;
            case 4: 
                    item = itemFactory.createPotion();
                break;
            case 5:
                    item = itemFactory.createScroll();
                break;
            case 6:
                break;
            default:
                break;
        }
        setItemStartingPostion(item, room);
        
        return item;
    }

    private Gold goldCreation(Room room){
        Random goldAmmount = new Random();
        Gold gold = new Gold();
        gold.setAmmount(goldAmmount.nextInt(100));
        setGoldStartingPostion(gold, room);
        return gold;
    }

    private Food foodCreation(Room room){
        Food food = new Food();
        Position foodPostion = new Position();
        Random random = new Random();
        foodPostion.setX( (random.nextInt(room.getWidth()) % room.getWidth() - 2) + room.getPosition().getX() + 1);
        foodPostion.setY((random.nextInt(room.getHeight()) % room.getHeight() - 2) + room.getPosition().getY() + 1);
        Hitbox foodHitbox = new Hitbox(foodPostion.getX(), foodPostion.getY(), 16, 16);
        food.setPosition(foodPostion);
        food.setHitbox(foodHitbox);

        return food;
    }


    private void setItemStartingPostion(Item item, Room room){
        Position itemPostion = new Position();
        Random random = new Random();
        itemPostion.setX( (random.nextInt(room.getWidth()) % room.getWidth() - 2) + room.getPosition().getX() + 1);
        itemPostion.setY((random.nextInt(room.getHeight()) % room.getHeight() - 2) + room.getPosition().getY() + 1);
        Hitbox itemHitbox = new Hitbox(itemPostion.getX(), itemPostion.getY(), 16, 16);
        item.setPosition(itemPostion);
        item.setHitbox(itemHitbox);
    }

    private void setGoldStartingPostion(Gold gold, Room room){
        Position goldPostion = new Position();
        Random random = new Random();
        goldPostion.setX( (random.nextInt(room.getWidth()) % room.getWidth() - 2) + room.getPosition().getX() + 1);
        goldPostion.setY((random.nextInt(room.getHeight()) % room.getHeight() - 2) + room.getPosition().getY() + 1);
        Hitbox goldHitbox = new Hitbox(goldPostion.getX(), goldPostion.getY(), 16, 16);
        gold.setPosition(goldPostion);
        gold.setHitbox(goldHitbox);
    }

    public void collectItem(Level level, Player player){
        for(int x = 0; x < level.getNumberOfRooms(); x++){
            if(level.getRooms().get(x).getItem() != null){
                if(!level.getRooms().get(x).getItem().isCollected()){
                    if(player.getHitbox().intersects(level.getRooms().get(x).getItem().getHitbox()) && player.getItems().size() < player.getMaxItems()){
                        level.getRooms().get(x).getItem().setCollected(true);
                        player.getItems().add( level.getRooms().get(x).getItem());
                    }
                }
            }
        }
    }

    public void collectGold(Level level, Player player){
        for(int x = 0; x < level.getNumberOfRooms(); x++){
            if(level.getRooms().get(x).getGold() != null){
                if(!level.getRooms().get(x).getGold().isCollected()){
                    if(player.getHitbox().intersects(level.getRooms().get(x).getGold().getHitbox())){
                        level.getRooms().get(x).getGold().setCollected(true);
                        player.setGold(player.getGold() + level.getRooms().get(x).getGold().getAmmount());
                    }
                }
            }
        }
    }

    public void collectFood(Level level, PlayerManager playerManager){
        for(int x = 0; x < level.getNumberOfRooms(); x++){
            if(level.getRooms().get(x).getFood() != null){
                if(!level.getRooms().get(x).getFood().isCollected()){
                    if(playerManager.getPlayer().getHitbox().intersects(level.getRooms().get(x).getFood().getHitbox())){
                        level.getRooms().get(x).getFood().setCollected(true);
                        playerManager.getPlayer().setHungerStage(HungerStages.STAGE_ZERO);
                        //steps is how we track the hunger stages
                        //when the player eats we one to reset the hunger stage to zero
                        //and set the steps back to zero resetting the hunger counter
                        //steps are treated as turns.
                        playerManager.setPlayerSteps(0);
                    }
                }
            }
        }
    }

    public void equipItem(int slot, Player player){
        if(!player.getItems().isEmpty() && player.getItems().get(slot).getType() != null){
            if(player.getItems().get(slot).getType() == ItemType.WEAPON || player.getItems().get(slot).getType() == ItemType.ARMOR || player.getItems().get(slot).getType() == ItemType.RING){
                
                //Code that checks if the user is selecting the same item
                //and if it is equiped then unequip it and break out of the code
                if(player.getItems().get(slot).getType() == ItemType.WEAPON){
                    Weapon weapon = (Weapon) player.getItems().get(slot);
                    if(weapon.isEquiped()){
                        weapon.setEquiped(false);
                        player.setStrength(player.getBaseStrength());
                        player.getItems().set(slot, weapon);
                        return;
                    }
                }else if(player.getItems().get(slot).getType() == ItemType.ARMOR){
                    Armor armor = (Armor) player.getItems().get(slot);
                    if(armor.isEquiped()){
                        armor.setEquiped(false);
                        player.setArmor(player.getBaseArmor());
                        player.getItems().set(slot, armor);
                        return;
                    }
                }else if(player.getItems().get(slot).getType() == ItemType.RING){
                    Ring ring = (Ring) player.getItems().get(slot);
                    if(ring.isEquiped()){
                        ring.setEquiped(false);
                        if(ring.getRingType() == RingType.SLOW_DIGESTION){
                            player.setSlowDigestion(false);
                        }
                        player.getItems().set(slot, ring);
                        return;
                    }
                }

                //Code that checks if the user has any other item of these types equiped
                //since you can only have one equiped, the current one will be unequiped
                if(player.getItems().get(slot).getType() == ItemType.WEAPON){
                    for (Item item : player.getItems()) {
                        if(item.getType() == ItemType.WEAPON){
                            Weapon weapon = (Weapon) item;
                            if(weapon.isEquiped()){
                                 weapon.setEquiped(false);
                                 player.setStrength(player.getBaseStrength());
                                 item = weapon;
                                 break;
                            }
                        }

                    }
                }else if(player.getItems().get(slot).getType() == ItemType.ARMOR){
                    for (Item item : player.getItems()) {
                        if(item.getType() == ItemType.ARMOR){
                            Armor armor = (Armor) item;
                            if(armor.isEquiped()){
                                armor.setEquiped(false);
                                player.setArmor(player.getBaseArmor());
                                item = armor;
                                break;
                            }
                        }
                    }
                }else if(player.getItems().get(slot).getType() == ItemType.RING){
                    for (Item item : player.getItems()) {
                        if(item.getType() == ItemType.RING){
                            Ring ring = (Ring) item;
                            if(ring.isEquiped()){
                                if(ring.getRingType() == RingType.SLOW_DIGESTION){
                                    player.setSlowDigestion(false);
                                }
                                ring.setEquiped(false);
                                item = ring;
                                break;
                            }
                        }
                    }
                }

                //equips the item
                if(player.getItems().get(slot).getType() == ItemType.WEAPON){
                    Weapon weapon = (Weapon) player.getItems().get(slot);
                    weapon.setEquiped(true);
                    player.setStrength(weapon.getAttack());
                    player.getItems().set(slot, weapon);
                }else if(player.getItems().get(slot).getType() == ItemType.ARMOR){
                    Armor armor = (Armor) player.getItems().get(slot);
                    armor.setEquiped(true);
                    player.setArmor(armor.getDefense());
                    player.getItems().set(slot, armor);
                }else if(player.getItems().get(slot).getType() == ItemType.RING){
                    Ring ring = (Ring) player.getItems().get(slot);
                    ring.setEquiped(true);
                    if(ring.getRingType() == RingType.SLOW_DIGESTION){
                        player.setSlowDigestion(true);
                    }
                    player.getItems().set(slot, ring);
                }
            }else{
                if(player.getItems().get(slot).getType() == ItemType.POTION){
                    Potion potion = (Potion) player.getItems().get(slot);
                    if(potion.getPotionType() == PotionType.RAISE_LEVEL){
                        player.setLevel(player.getLevel() + 1);
                        player.setExperience(0);
                        player.setMaxHealth(player.getMaxHealth() + 5);
                        player.setCurrentHealth(player.getMaxHealth());
                        player.setRequiredExp(player.getRequiredExp() * 2);
                    }
                    player.getItems().remove(slot);
                    JOptionPane.showMessageDialog(null,"You suddenly feel much more skilful."); 
                }else if(player.getItems().get(slot).getType() == ItemType.SCROLL){
                    Scroll scroll = (Scroll) player.getItems().get(slot);
                    if(scroll.getScrollType() == ScrollType.ENCHANT_ARMOR){
                        int armorIndex = 0;
                        for (Item item : player.getItems()) {
                            if(item.getType() == ItemType.ARMOR){
                                Armor armor = (Armor) item;
                                if(armor.isEquiped()){
                                    armorIndex = player.getItems().indexOf(item);
                                    armor.setDefense(armor.getDefense() - 1);
                                    item = armor;
                                    player.setArmor(armor.getDefense());
                                    break;
                                }
                            }
                        }
                        if(armorIndex == 0){
                            JOptionPane.showMessageDialog(null,"You must equip an armor to use this scroll.");
                        }else{
                           player.getItems().remove(slot);
                           JOptionPane.showMessageDialog(null,"Your armor glows faintly for a moment."); 
                        }
                    }
                }
            }

        }

    }
}
