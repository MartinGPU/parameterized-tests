package com.marat.pages.component;

import com.codeborne.selenide.SelenideElement;

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
