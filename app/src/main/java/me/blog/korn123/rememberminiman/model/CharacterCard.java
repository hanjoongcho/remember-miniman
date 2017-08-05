package me.blog.korn123.rememberminiman.model;

/**
 * Created by CHO HANJOONG on 2017-08-04.
 */

public class CharacterCard {
    int cardResourceId;
    String info;

    public CharacterCard(int cardResourceId, String info) {
        this.cardResourceId = cardResourceId;
        this.info = info;
    }

    public int getCardResourceId() {
        return cardResourceId;
    }

    public void setCardResourceId(int cardResourceId) {
        this.cardResourceId = cardResourceId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}