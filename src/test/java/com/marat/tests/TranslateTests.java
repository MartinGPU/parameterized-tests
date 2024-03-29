package com.marat.tests;

import com.marat.pages.GooglePage;
import com.marat.pages.components.MenuItemLeftComponent;
import com.marat.pages.components.TranslateWindowComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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
    @CsvSource({"Дима, 33", "Вася, 22"})
    @ParameterizedTest
    public void checkPage(String name1, int age) {
        googlePage.openPage();
        translateWindowComponent.changeItem().setValue2(name1 + ": Возраст " + age);
        sleep(3000);
        translateWindowComponent.checkValue().deleteValue();
        sleep(3000);
    }

    @DisplayName("EnumSourceTest")
    @EnumSource(MenuItemLeftComponent.class)
    @ParameterizedTest
    public void checkPage(MenuItemLeftComponent menuItemLeftComponent) {
        googlePage.openPage().switchToMenuItemLeft(menuItemLeftComponent);
        translateWindowComponent.setValue("123");
        sleep(3000);
        translateWindowComponent.checkValue().deleteValue();
        sleep(3000);
    }

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("Молоко", "Кефир", 300),
                Arguments.of("Автомобиль", "Двигатель", 400),
                Arguments.of("Лыжи", "Сноуборд", 500)
        );
    }

    @DisplayName("MethodSourceTest")
    @MethodSource
    @ParameterizedTest
    void methodSource(String str1, String str2, int i) {
        googlePage.openPage();
        translateWindowComponent.changeItem();
        translateWindowComponent.setValue3(str1, str2, i);
        sleep(3000);
        translateWindowComponent.checkValue().deleteValue();
    }
}
