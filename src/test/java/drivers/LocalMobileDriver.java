package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.App;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.FileUtils.getAbsolutePath;

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            //return new URL("http://127.0.0.1:4723/wd/hub");
            return new URL(App.config.localUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "android");
        //desiredCapabilities.setCapability("deviceName", "8aeb35ff");
        desiredCapabilities.setCapability("deviceName", App.config.mobileName());
        desiredCapabilities.setCapability("version", "10.0");
        //desiredCapabilities.setCapability("locale", "en");
        //desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath("src/test/resources/apk/app-alpha-universal-release.apk"));

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }



}
