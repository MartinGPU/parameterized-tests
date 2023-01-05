package com.marat.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1366x768";
    }
}
