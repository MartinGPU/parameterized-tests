package com.marat.pages.component;

public enum MenuItemLeftComponent {
    ENGLISH("английский"),
    RUSSIAN("русский");

    public final String desc;

    MenuItemLeftComponent(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
