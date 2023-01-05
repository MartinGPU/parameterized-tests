package com.marat.pages.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TranslateWindowComponent {

    private final SelenideElement
            transWindowLeft = $("[aria-label = 'Исходный текст']"),
            transWindowRightTranslated = $(".ryNqvb"),
            russian = $("#i8"),
            langSelect = $(".VfPpkd-YVzG2b");

    public TranslateWindowComponent changeItem() {
        langSelect.click();
        russian.click();
        return this;
    }

    public TranslateWindowComponent setValue(String value) {
        transWindowLeft.setValue(value);
        return this;
    }

    public TranslateWindowComponent checkValue() {
        transWindowRightTranslated.shouldBe(Condition.visible);
        return this;
    }

    public TranslateWindowComponent deleteValue() {
        transWindowLeft.clear();
        return this;
    }
}
