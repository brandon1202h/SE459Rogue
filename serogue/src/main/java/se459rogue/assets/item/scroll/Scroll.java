package se459rogue.assets.item.scroll;

import se459rogue.assets.item.Item;

public class Scroll extends Item{
    ScrollType scrollType;

    public ScrollType getScrollType() {
        return scrollType;
    }

    public void setScrollType(ScrollType scrollType) {
        this.scrollType = scrollType;
    }

}
