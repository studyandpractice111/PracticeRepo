package com.practice.repo;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CucumberHooks extends SpringTestConfiguration {

    //TODO - More configuration required

    @Before
    public void prepareSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @After
    public void closeDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            closeWebDriver();
        }
    }
}