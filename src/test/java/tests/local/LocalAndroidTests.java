package tests.local;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("local_android")
public class LocalAndroidTests extends TestBase {

    //gradle clean test -Dtag=local_android

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


    @Test
    void CheckWikipediaPagesTest() {
        step("Click Skip", () ->
                back()
        );
        step("Check pages", () -> {
                    step("Search page check", () -> {
                        $(MobileBy.AccessibilityId("Найти")).click();
                        $(MobileBy.id("org.wikipedia.alpha:id/history_title"))
                                .shouldBe(text("История"));
                        System.out.println("Search page checked");
                    });
                    step("Saved page check", () -> {
                        $(MobileBy.AccessibilityId("Сохранено")).click();
                        $(MobileBy.id("org.wikipedia.alpha:id/messageTitleView"))
                                .shouldBe(text("Синхронизировать список для чтения"));
                        System.out.println("Saved page checked");
                    });
                    step("Editing page check", () -> {
                                $(MobileBy.AccessibilityId("Правки")).click();
                                $(MobileBy.id("org.wikipedia.alpha:id/messageTitleView"))
                                        .shouldBe(text("Знаете ли вы," +
                                                " что каждый может редактировать Википедию?"));
                                System.out.println("Editing page checked");
                            }
                    );
                }
        );

    }
}