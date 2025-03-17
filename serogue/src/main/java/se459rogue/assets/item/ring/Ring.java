package se459rogue.assets.item.ring;

import se459rogue.assets.item.Item;

public class Ring extends Item{
    RingType ringType;
    boolean equiped;
    public RingType getRingType() {
        return ringType;
    }
    public void setRingType(RingType ringType) {
        this.ringType = ringType;
    }
    public boolean isEquiped() {
        return equiped;
    }
    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
    
}
