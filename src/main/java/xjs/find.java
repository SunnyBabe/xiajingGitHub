package xjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by xiaqing on 2017/8/5.
 */
public class find{

    public static WebElement findEl(By by){
        WebDriver driver = null;
        try {
            new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e){
            System.out.println("元素："+ by +"加载超时！");
            e.printStackTrace();
        }
        return driver.findElement(by);
    }

}
