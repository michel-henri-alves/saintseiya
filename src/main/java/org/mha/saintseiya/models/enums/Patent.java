package org.mha.saintseiya.models.enums;

import lombok.Getter;

public enum Patent{
    GOLD("Gold"), 
    SILVER("Silver"), 
    BRONZE("Bronze"), 
    DIVINE("Divine"), 
    IRON("IRON"), 
    SONOTA("Sonota"),
    GENERAL_MARINA("General Marina"),
    JUDGE("Judge"),
    CELESTIAL_STAR("Celestial Star"),
    TERRESTRIAL_STAR("Terrestrial Star"),
    GOD_WARRIOR("God Warrior");

    @Getter
    private String description;

    Patent(String description){
        this.description = description;
    }
}