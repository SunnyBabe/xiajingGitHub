package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/5/6.
 */
public class registerText {
    WebDriver driver;
    @BeforeMethod
    public void openB(){
        driver = new FirefoxDriver();
        driver.get("http://mail.163.com/");
    }
    @AfterMethod
    public void closeB() {
      driver.quit();
    }

    @Test
    public void register() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.id("changepage")).click();
        Thread.sleep(Long.parseLong("3"));
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles())
        {
            if(handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }

        String time = String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("nameIpt")).sendKeys("email"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("xj14323432");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("xj14323432");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("1234");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("2431");
        driver.findElement(By.id("mainRegA")).click();
       // Thread.sleep(3000);
        //显式等待
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainAcode']/span")));


        String error=driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(error,"  手机验证码不正确，请重新填写");
    }
}
