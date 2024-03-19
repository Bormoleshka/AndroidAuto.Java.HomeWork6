import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;

public class DriverFactory {
    AndroidDriver<?> driver;
    public AndroidDriver<?> setUpDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android" );
        desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
        desiredCapabilities.setCapability(APP_PACKAGE, "ru.filit.mvideo.b2c");
        desiredCapabilities.setCapability(APP_ACTIVITY, "ui.splash.view.SplashScreen");
        desiredCapabilities.setCapability(NO_SIGN, true);

        URL remouteUrl = new URL("http://localhost:4723");


        driver = new AndroidDriver<>(remouteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;
    }

    public io.appium.java_client.android.AndroidDriver<?> setUp() {
        return null;
    }

    private class AndroidDriver<T> {
        public AndroidDriver(T remouteUrl, T desiredCapabilities) {
        }

        public WebDriver.Options manage() {
            return null;
        }
    }
}
