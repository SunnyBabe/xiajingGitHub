package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by xiaqing on 2017/5/1.
 */
public class Downloade {
    @Test
    public void download() throws InterruptedException, AWTException {
        WebDriver driver = new FirefoxDriver();
        //进入baidu
        driver.get("https://www.baidu.com/");
        //输入下载qq音乐
        driver.findElement(By.id("kw")).sendKeys("下载qq音乐");
        //点击百度按钮
        driver.findElement(By.id("su")).click();
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath(".//*[@id='1']/div[2]/div/div[1]/div[2]/p[6]/a")));
        //点击立即下载
        driver.findElement(By.xpath(".//*[@id='1']/div[2]/div/div[1]/div[2]/p[6]/a")).click();
        Thread.sleep(Long.parseLong("5"));

        //模拟键盘操作点击保存
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @Test
    public void  download2() throws InterruptedException, AWTException {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        //设置火狐的默认下载文件夹：0表示桌面   1表示我的下载  2表示自定义文件夹
        firefoxProfile.setPreference("browser.download.floderList",2);
        //设置自定义文件夹位置
        firefoxProfile.setPreference("browser.download.dir","F:\\");
        //打开一个预先配置的火狐
        WebDriver driver = new FirefoxDriver(firefoxProfile);
        //进入baidu
        driver.get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=%E4%B8%8B%E8%BD%BDqq%E9%9F%B3%E4%B9%90&rsv_pq=c756fcc400021b40&rsv_t=2ca5jR7MUGFR5cQqiAZE9dXWtrDd0B%2Fd9bHAIGNUtuv2u6SxAdAK8miuRNQ&rqlang=cn&rsv_enter=1&rsv_sug3=5");

        //点击立即下载
        driver.findElement(By.xpath(".//*[@id='1']/div[2]/div/div[1]/div[2]/p[6]/a")).click();
        Thread.sleep(Long.parseLong("5"));

        //模拟键盘操作点击保存
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
