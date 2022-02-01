package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    void searchTest() {
        step("Open wikipedia", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click()
        );
        step("Enter text BrowserStack", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack")
        );

        step("Check if the text is found", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0))
        );

    }

    @Test
    void wikipediaSettingsTest() {
        step("Open wikipedia menu", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click()
        );

        step("Click to Settings", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings"))
                        .shouldBe(visible).click()
        );

        step("Fix some settings", () -> {
                    step("Checking the login to the settings page", () ->
                            $(MobileBy.xpath(("//*[@text='English']"))).shouldBe(visible)
                    );
                    step("Turn off the setting Show images", () ->
                            $(MobileBy.className("android.widget.Switch")).click()
                    );
                    // OFF
                    step("Check changes in Show images", () ->
                            $(MobileBy.className("android.widget.Switch")).shouldHave(text("OFF"))
                    );
                }
        );
    }
}