package xjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by xiaqing on 2017/8/5.
 */
public class poSleep {
    public static void click(WebDriver driver , By by){
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).click();
    }
    public static void send(WebDriver driver , By by,String key){
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(key);
    }
}
