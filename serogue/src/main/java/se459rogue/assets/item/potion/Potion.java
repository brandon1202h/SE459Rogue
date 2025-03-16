package se459rogue.assets.item.potion;

import se459rogue.assets.item.Item;

public class Potion extends Item {
    PotionType potionType;

    public PotionType getPotionType() {
        return potionType;
    }

    public void setPotionType(PotionType potionType) {
        this.potionType = potionType;
    }

}
