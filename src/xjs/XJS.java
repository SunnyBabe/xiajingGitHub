import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**
 * Created by xiaqing on 2017/4/10.
 */
public class XJS {
    WebDriver driver;

    @BeforeClass
    public void openB(){
        driver = new ChromeDriver();
        driver.get("http://10.201.62.63:8068/kstp");
    }
    @BeforeMethod
    public void login(){

    }
    @Test
    public void zcfb() throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a)"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
        WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[1]/a"));
        actions.moveToElement(ele2).perform();
        //进入资产发布页面
        driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[1]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        //点击进入下一步
        driver.findElement(By.xpath("//*[@id=\"auctionAddForm\"]/dl/dd[3]/button")).click();
        Thread.sleep(3000);
        //填写信息
        driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("测试0411");

    }
}
