package org.example;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.testng.Assert.assertNotEquals;

public class StepImplementation extends BaseModel {
    public static WebElement hamburgerMenu;

    @Step("Hamburger Menuye Tıkla")
    public void IsHamburgerMenuExist() {
        try {
            if (driver.findElementByAccessibilityId("NavigationIcon").isDisplayed()) {
                hamburgerMenu = driver.findElementByAccessibilityId("NavigationIcon");
                hamburgerMenu.click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Step("Piyasalara Tıkla")
    public void clickToMarkets() {
        WebElement element = driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Piyasalar\"])[1]");
        if (element.isDisplayed()) {
            element.click();
        }
    }

    @Step("Piyasa Listelerini Kontrol Et")
    public void getMarketList() {
        WebElement element = driver.findElementByXPath("(//android.widget.RelativeLayout[@content-desc=\"0\"])[1]/android.widget.LinearLayout");
        if (element.isDisplayed()) {
            element.click();
            String find = "CBOE EDGX Payları";
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + find + "\").instance(0))");
            List<MobileElement> listOfMarketList = (List<MobileElement>) driver.findElementsByClassName("android.widget.RelativeLayout");
            System.out.println(listOfMarketList);

        }
    }

    @Step("Bist 100'e Giriş Yap")
    public void EntryToBist100() {
        String find = "BIST 100";
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + find + "\").instance(0))").click();
    }

    @Step("<kelimesi> ile arama gerçekleştir")
    public void findStock(String findWord) {
        driver.findElementByAccessibilityId("Sembol Ara").click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys(findWord);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc, '" + findWord.toUpperCase() + "')]")).click();
    }

    @Step("Haberler'e Giriş Yap")
    public void EntryToNews() {
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"HABERLER\"]")).click();
    }

    @Step("İlk Habere Giriş Yap")
    public void EnrtyToFirstNews() {
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc=\"0\"]\n")).click();
    }

    @Step("Başlıgı Kontrol Et")
    public void checkNewsTitle() {
        String newsTitleAssert = "ANALİZ-Piyasalarda Gelişmeler/Beklentiler(ÜNLÜ & Co / DAHA)";
        assertNotEquals(driver.findElementByAccessibilityId("ANALİZ-Piyasalarda Gelişmeler/Beklentiler(ÜNLÜ & Co / DAHA)").getText(), null);
    }

}
