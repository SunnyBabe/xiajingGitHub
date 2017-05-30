package Day2;

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
 * Created by xiaqing on 2017/4/23.
 */
@SuppressWarnings("ALL")
public class windowTest {
    WebDriver driver;
    @BeforeMethod
    public void openFF(){
        driver = new FirefoxDriver();
        //全局等待
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void windowSelect() throws InterruptedException {
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/demo1.html");
        driver.findElement(By.linkText("Open new window")).click();
        //获取当前窗口句柄
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles())
        {
            if(handles.equals(handle))
                continue;
            //控制权转交给新窗口
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.className("新闻")).click();
        //控制权转交给原窗口
        driver.switchTo().window(handle);
        driver.findElement(By.className("Volvo")).click();
    }


    /*
    如何将控制权转交给第三个窗口
     */
    @Test
    public void threeWindow() throws InterruptedException {
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/demo1.html");
        driver.findElement(By.linkText("Open new window")).click();
        //获取第一个窗口句柄
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles())
        {
            if(handles.equals(handle))
                continue;
            //控制权转交给第二个窗口
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.linkText("京公网安备11000002000001号")).click();
        //获取第二个窗口句柄
        String handle2=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles())
        {
            if(handles.equals(handle))
                continue;
            else if(handles.equals(handle2))
                continue;
            else
            //控制权转交给第三个窗口
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.linkText("公共查询")).click();
        Thread.sleep(3000);
    }

    @Test
    public void waitTest() throws InterruptedException {
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/index.html");
        driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
        //显式等待
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@id='display']/div")));
        String w = driver.findElement(By.xpath(".//*[@id='display']/div")).getText();
        Assert.assertEquals(w,"wait for display");

    }

    @AfterMethod
    public void closeB(){
        driver.quit();
    }
}
