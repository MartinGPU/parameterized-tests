package com.marat.tests;

import com.marat.pages.GooglePage;
import com.marat.pages.component.MenuItemLeftComponent;
import com.marat.pages.component.TranslateWindowComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.sleep;

public class TranslateTests {

    GooglePage googlePage = new GooglePage();
    TranslateWindowComponent translateWindowComponent = new TranslateWindowComponent();

    @DisplayName("ValueSourceTest")
    @ValueSource(strings = {"Политик", "Президент", "Доктор"})
    @ParameterizedTest
    public void checkPage(String name) {
        googlePage.openPage();
        translateWindowComponent.changeItem().setValue(name);
        sleep(3000);
        translateWindowComponent.checkValue().deleteValue();
    }

    @DisplayName("CsvSourceTest")
    @CsvSource(value = {"Казнить нельзя, помиловать"})
    @ParameterizedTest
    public void checkPage(String name1, String name2) {
        googlePage.openPage();
        translateWindowComponent.changeItem().setValue(name1 + ", " + name2);
        sleep(3000);
        translateWindowComponent.checkValue().deleteValue();
        sleep(3000);
    }

//    @DisplayName("EnumSourceTest")
//    @EnumSource(MenuItemLeftComponent.class)
//    @ParameterizedTest
//    public void checkPage(MenuItemLeftComponent menuItemLeftComponent) {
//        googlePage.openPage().switchToMenuItemLeft(menuItemLeftComponent);
//        translateWindowComponent.setValue("123");
//        sleep(3000);
//        translateWindowComponent.checkValue().deleteValue();
//        sleep(3000);
//    }
//
//    @DisplayName("MethodSourceTest")
//    @MethodSource
//    @ParameterizedTest
//    public static void checkPage2() {
//    }
}
