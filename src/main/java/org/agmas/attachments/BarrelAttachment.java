package org.agmas.attachments;


public enum BarrelAttachment {
    NONE(1f),
    SUPPRESSOR(1f),
    EXTENDED_BARREL(1.5f),
    FLASH_HIDER(0.55f),
    COMPENSATOR(1.1f);

    public final float uncertaintyMultiplier;
    BarrelAttachment(float uncertaintyMultiplier) {
        this.uncertaintyMultiplier = uncertaintyMultiplier;
    }
}
