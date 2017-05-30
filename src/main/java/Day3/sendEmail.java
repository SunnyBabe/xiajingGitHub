package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/5/6.
 */
public class sendEmail {
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
    public void send() throws InterruptedException {
        //登录
        loginTest.login(driver, "xiajing0105", "xj15925835714");
        Thread.sleep(3000);
        //点击写信
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //输入收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("xiajing0105@163.com");
        //输入邮件主题
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("写信");
        //上传附件
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input"))
                .sendKeys("C:\\Users\\xiaqing\\Pictures\\Saved Pictures\\1.jpg");

        //控制权还可以通过定位元素转交
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("html/body")).sendKeys("这是正文");
        //控制权转交回来
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

        Boolean text=driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(text);



    }

}
