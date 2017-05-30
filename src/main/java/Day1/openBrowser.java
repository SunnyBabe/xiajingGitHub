package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/4/16.
 */
public class openBrowser {
    //默认安装
    @Test
    public void openFF(){
        WebDriver driver = new FirefoxDriver();
    }

    //不是默认安装，需指定安装位置
    @Test
    public void  openFF2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
    }

    //打开谷歌浏览器
    @Test
    public void  openG(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\xiaqing\\AppData\\Local\\Programs\\Python\\Python36\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.close();
    }

    @Test
    //启动edge浏览器,关闭当前窗口
    public void  openEdge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","F:\\MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.baidu.com/");
        driver.close();
    }

    @Test
    //启动IE浏览器，关闭浏览器
    public void openIE(){
        System.setProperty("webdriver.ie.driver","F:\\driver驱动\\IEDriverServer.exe");
        WebDriver driver =new InternetExplorerDriver();
        driver.quit();
    }
}

