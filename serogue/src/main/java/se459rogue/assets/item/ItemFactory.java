package se459rogue.assets.item;

import se459rogue.assets.item.armor.Armor;
import se459rogue.assets.item.armor.ArmorType;
import se459rogue.assets.item.weapon.Weapon;
import se459rogue.assets.item.weapon.WeaponType;

public class ItemFactory {
    
    public Weapon createOneHandSword(){
        Weapon swordItem = new Weapon();
        swordItem.setType(ItemType.WEAPON);
        swordItem.setWeaponType(WeaponType.LONGSWORD);
        swordItem.setAttack(7);
        swordItem.setHealth(100);
        swordItem.setName("LS");
        swordItem.setInventoryName("Longsword");
        swordItem.setEquiped(false);
        swordItem.setSb("S");

        return swordItem;
    }

    public Weapon createTwoHandSword(){
        Weapon swordItem = new Weapon();
        swordItem.setType(ItemType.WEAPON);
        swordItem.setWeaponType(WeaponType.TWO_HANDED_SWORD);
        swordItem.setAttack(10);
        swordItem.setHealth(100);
        swordItem.setName("THS");
        swordItem.setInventoryName("Two Handed Sword");
        swordItem.setEquiped(false);
        swordItem.setSb("S");

        return swordItem;
    }

    public Weapon createMace(){
        Weapon maceItem = new Weapon();
        maceItem.setType(ItemType.WEAPON);
        maceItem.setWeaponType(WeaponType.MACE);
        maceItem.setAttack(5);
        maceItem.setHealth(100);
        maceItem.setName("MA");
        maceItem.setInventoryName("Mace");
        maceItem.setEquiped(false);
        maceItem.setSb("S");
        
        return maceItem;
    }

    public Weapon createDagger(){
        Weapon daggerItem = new Weapon();
        daggerItem.setType(ItemType.WEAPON);
        daggerItem.setWeaponType(WeaponType.DAGGER);
        daggerItem.setAttack(4);
        daggerItem.setHealth(100);
        daggerItem.setName("DAG");
        daggerItem.setInventoryName("Dagger");
        daggerItem.setEquiped(false);
        daggerItem.setSb("S");

        return daggerItem;
    }

    public Weapon createSpear(){
        Weapon spearItem = new Weapon();
        spearItem.setType(ItemType.WEAPON);
        spearItem.setWeaponType(WeaponType.SPEAR);
        spearItem.setAttack(5);
        spearItem.setHealth(100);
        spearItem.setName("SPE");
        spearItem.setInventoryName("Spear");
        spearItem.setEquiped(false);
        spearItem.setSb("S");

        return spearItem;
    }

    public Armor createLeatherArmor(){
        Armor leatherArmorType = new Armor();
        leatherArmorType.setType(ItemType.ARMOR);
        leatherArmorType.setArmorType(ArmorType.LEATHER);
        leatherArmorType.setHealth(100);
        leatherArmorType.setName("LA");
        leatherArmorType.setInventoryName("Leather Armor");
        leatherArmorType.setDefense(8);
        leatherArmorType.setEquiped(false);

        return leatherArmorType;
    }

    public Armor createStuddedLeatherArmor(){
        Armor leatherArmorType = new Armor();
        leatherArmorType.setType(ItemType.ARMOR);
        leatherArmorType.setArmorType(ArmorType.STUDDED_LEATHER);
        leatherArmorType.setHealth(100);
        leatherArmorType.setName("SLA");
        leatherArmorType.setInventoryName("Studded Leather Armor");
        leatherArmorType.setDefense(7);
        leatherArmorType.setEquiped(false);

        return leatherArmorType;
    }

    public Armor createRingMailArmor(){
        Armor ringMail = new Armor();
        ringMail.setType(ItemType.ARMOR);
        ringMail.setArmorType(ArmorType.RING_MAIL);
        ringMail.setHealth(100);
        ringMail.setName("RM");
        ringMail.setInventoryName("Ring Mail");
        ringMail.setDefense(7);
        ringMail.setEquiped(false);

        return ringMail;
    }

    public Armor createScaleMailArmor(){
        Armor scaleMail = new Armor();
        scaleMail.setType(ItemType.ARMOR);
        scaleMail.setArmorType(ArmorType.SCALE_MAIL);
        scaleMail.setHealth(100);
        scaleMail.setName("SM");
        scaleMail.setInventoryName("Scale Mail");
        scaleMail.setDefense(6);
        scaleMail.setEquiped(false);

        return scaleMail;
    }

    public Armor createChainMailArmor(){
        Armor chainMail = new Armor();
        chainMail.setType(ItemType.ARMOR);
        chainMail.setArmorType(ArmorType.CHAIN_MAIL);
        chainMail.setHealth(100);
        chainMail.setName("CM");
        chainMail.setInventoryName("Chain Mail");
        chainMail.setDefense(5);
        chainMail.setEquiped(false);

        return chainMail;
    }

    public Armor createBrandedMail(){
        Armor brandedMail = new Armor();
        brandedMail.setType(ItemType.ARMOR);
        brandedMail.setArmorType(ArmorType.BRANDED_MAIL);
        brandedMail.setHealth(100);
        brandedMail.setName("BM");
        brandedMail.setInventoryName("Branded Mail");
        brandedMail.setDefense(4);
        brandedMail.setEquiped(false);

        return brandedMail;
    }

    public Armor createSplintMailArmor(){
        Armor splintMail = new Armor();
        splintMail.setType(ItemType.ARMOR);
        splintMail.setArmorType(ArmorType.SPLINT_MAIL);
        splintMail.setHealth(100);
        splintMail.setName("SPM");
        splintMail.setInventoryName("Splint Mail");
        splintMail.setDefense(4);
        splintMail.setEquiped(false);

        return splintMail;
    }

    public Armor CreatePlateMailArmor(){
        Armor plateMail = new Armor();
        plateMail.setType(ItemType.ARMOR);
        plateMail.setArmorType(ArmorType.PLATE_MAIL);
        plateMail.setHealth(100);
        plateMail.setName("PM");
        plateMail.setInventoryName("Plate Mail");
        plateMail.setDefense(3);
        plateMail.setEquiped(false);

        return plateMail;
    }


}
