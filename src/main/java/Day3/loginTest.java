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
public class loginTest {
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
    public void loginSucess() throws InterruptedException {
//        driver.switchTo().frame("x-URS-iframe");
//        driver.findElement(By.name("email")).sendKeys("xiajing0105");
//        driver.findElement(By.name("password")).sendKeys("xj15925835714");
//        driver.findElement(By.id("dologin")).click();
        loginTest.login(driver,"xiajing0105","xj15925835714");
        Thread.sleep(3000);
        String text=driver.findElement(By.xpath(".//*[@id='spnUid']")).getText();
        Assert.assertEquals(text,"xiajing0105@163.com");
    }

    @Test
    public void loginFail(){
//        driver.switchTo().frame("x-URS-iframe");
//        driver.findElement(By.name("email")).sendKeys("xiajing0105");
//        driver.findElement(By.name("password")).sendKeys("xj159258357141");
//        driver.findElement(By.id("dologin")).click();
        loginTest.login(driver,"xiajing0105","xj159258357141");
        //显式等待
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("ferrorhead")));

        String error  = driver.findElement(By.className("ferrorhead")).getText();
        Assert.assertEquals(error,"帐号或密码错误");
    }

//封装
    public static void  login(WebDriver driver,String email,String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
}
