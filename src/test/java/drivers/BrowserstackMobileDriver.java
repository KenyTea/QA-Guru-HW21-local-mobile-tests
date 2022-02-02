package drivers;

import browserstack.App;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            //return new URL("http://hub.browserstack.com/wd/hub");
            return new URL(App.config.webUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        //desiredCapabilities.setCapability("browserstack.user", "alex_qOEZV9");
        desiredCapabilities.setCapability("browserstack.user", App.config.userLogin());
        //desiredCapabilities.setCapability("browserstack.key", "CNqNAsq7sNz8EZT1Zxde");
        desiredCapabilities.setCapability("browserstack.key", App.config.userKey());

        // Set URL of the application under test
        //desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        desiredCapabilities.setCapability("app", App.config.userApp());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

}
