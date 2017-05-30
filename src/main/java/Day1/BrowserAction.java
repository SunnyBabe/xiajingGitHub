package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/4/16.
 */
public class BrowserAction {
    @Test
    public void  login() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
//      通过链接文本定位
        driver.findElement(By.linkText("新闻")).click();
//      后退
        driver.navigate().back();
//      前进
        driver.navigate().forward();
//      设置窗体大小
        Dimension dimension =new Dimension(300,300);
        driver.manage().window().setSize(dimension);
//      最大化
        driver.manage().window().maximize();
        driver.navigate().back();
        Thread.sleep(3000);
//      Xpath定位,点击登录进入登录页面
        driver.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
        Thread.sleep(3000);
        /**
         * 登录页面输入手机号、密码、验证码，提交,登录失败
         */
//      id属性定位
        driver.findElement(By.id("TANGRAM__PSP_8__userName")).sendKeys("13692206135");
//      CSS路径定位
        driver.findElement(By.cssSelector("#TANGRAM__PSP_8__password")).sendKeys("123123");
        driver.findElement(By.cssSelector("#TANGRAM__PSP_8__verifyCode")).sendKeys("1234");
        Thread.sleep(1000);
        driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();
        /**
         * 点击QQ图标进入第三方登录页面
         * 先把控制权交给第二个窗体
         * 再切换到frame框架
         * 点击qq快捷登录图标登录成功
         */
//      通过classname 定位
        driver.findElement(By.className("phoenix-btn-item")).click();
        Thread.sleep(5000);
//
        String Curr= driver.getWindowHandle();
        for (String  handles:driver.getWindowHandles())
        {
            if (handles.equals(Curr))
                continue;
            driver.switchTo().window(handles);
        }
        driver.switchTo().frame("ptlogin_iframe");
        driver.findElement(By.xpath("//*[@id='img_out_541061987']")).click();
        Thread.sleep(10000);
        driver.quit();

    }

}
