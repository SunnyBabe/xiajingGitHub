package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/5/29.
 */
public class shixianPO {
    WebDriver driver;
    @BeforeMethod
    public void openB(){
        driver = new FirefoxDriver();
        driver.get("http://mail.163.com/");
    }

    //逻辑层
    public static void  login(WebDriver driver,String email,String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(loginTestpo.eamil).sendKeys(email);
        driver.findElement(loginTestpo.pw).sendKeys(pwd);
        driver.findElement(loginTestpo.loginButton).click();
    }

    //引用逻辑层，实现业务层
    @Test
    public void loginSucess() throws InterruptedException {
        shixianPO.login(driver,"xiajing0105","xj15925835714");
        Thread.sleep(3000);
        String text=driver.findElement(By.xpath(".//*[@id='spnUid']")).getText();
        Assert.assertEquals(text,"xiajing0105@163.com");
    }
}
