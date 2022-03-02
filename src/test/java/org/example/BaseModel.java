package org.example;

import com.thoughtworks.gauge.AfterScenario;

import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Appium BaseModel üzerinde Cihaz Tanımlamaları Yapılmıştır İmplatasyonu tamamında driver nesnesi  üzerinden
 * işlemler bağlamıştır
 * */
public class BaseModel {
    public static AndroidDriver driver;
    @BeforeScenario
    public void setUp() throws MalformedURLException
    {
        URL appiumServerURL = null;
        appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/cem.acar/Desktop/forekstestLast.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "R58R506VVVH");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,false);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50000);
        driver = new AndroidDriver(appiumServerURL,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterScenario
    public void tearDown() throws Exception
    {
        driver.quit();
    }

}
