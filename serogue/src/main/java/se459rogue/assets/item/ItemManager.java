package se459rogue.assets.item;

import java.util.List;
import java.util.Random;

import se459rogue.assets.item.armor.Armor;
import se459rogue.assets.item.gold.Gold;
import se459rogue.assets.item.weapon.Weapon;
import se459rogue.assets.level.Level;
import se459rogue.assets.player.Player;
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
            itemCNum = itemType.nextInt(3);
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
                break;
            case 4: 
                break;
            case 5:
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

    public void equipItem(int slot, Player player){
        if(!player.getItems().isEmpty() && player.getItems().get(slot).getType() != null){
            if(player.getItems().get(slot).getType() == ItemType.WEAPON || player.getItems().get(slot).getType() == ItemType.ARMOR){
                
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
                }

                //Code that checks if the user has any other item of these types equiped
                //since you can only have one equiped the current one will be unequiped
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
                }

                //equips theitem
                if(player.getItems().get(slot).getType() == ItemType.WEAPON){
                    Weapon weapon = (Weapon) player.getItems().get(slot);
                    weapon.setEquiped(true);
                    player.setStrength(weapon.getAttack());
                    player.getItems().set(slot, weapon);
                    return;
                }else if(player.getItems().get(slot).getType() == ItemType.ARMOR){
                    Armor armor = (Armor) player.getItems().get(slot);
                    armor.setEquiped(true);
                    player.setArmor(armor.getDefense());
                    player.getItems().set(slot, armor);
                    return;
                }
            }

        }

    }
}
