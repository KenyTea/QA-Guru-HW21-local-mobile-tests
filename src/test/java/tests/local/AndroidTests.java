package tests.local;
;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    void searchWikipediaTest() {
        back();
        $(MobileBy.AccessibilityId("Поиск по Википедии")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Алматы");
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Test
    void wikipediaSettingsTest() {
        step("Click Skip", () ->
                back()
        );
        step("Open wikipedia menu", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/nav_more_container")).click()
        );

        step("Click to Settings", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"))
                        .shouldBe(visible).click()
        );

        step("Fix some settings", () -> {
                    step("Checking the login to the settings page", () ->
                            $(MobileBy.xpath(("//*[@text='Русский']"))).shouldBe(visible)
                    );
                    step("Turn off the setting Show images", () ->
                            $(MobileBy.className("android.widget.Switch")).click()
                    );
                    // OFF
                    step("Check changes in Show images", () ->
                            $(MobileBy.className("android.widget.Switch")).shouldHave(text("ВЫКЛ."))
                    );
                }
        );
    }
}