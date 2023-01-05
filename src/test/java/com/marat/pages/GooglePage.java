package com.marat.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.marat.pages.component.MenuItemLeftComponent;
import com.marat.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePage extends TestBase {

    private final String URL = "https://translate.google.com/";
    private final SelenideElement
            formTitle = $("#sdgBod");

    public GooglePage openPage() {
        Selenide.open(URL);
        formTitle.shouldHave(text("Переводчик"));
        return this;
    }

    public String getURL() {
        return URL;
    }

    public SelenideElement getFormTitle() {
        return formTitle;
    }

    public GooglePage switchToMenuItemLeft(MenuItemLeftComponent menuItemLeftComponent) {
        if (menuItemLeftComponent == MenuItemLeftComponent.ENGLISH) {
            $$("[role = 'tab']").findBy(text(menuItemLeftComponent.getDesc())).click();
        } else if (menuItemLeftComponent == MenuItemLeftComponent.RUSSIAN) {
            $$("[role = 'tab']").findBy(text(menuItemLeftComponent.getDesc())).click();
        } else throw new IllegalArgumentException("Enum " + menuItemLeftComponent + "is not exist");
        return this;
    }
}
