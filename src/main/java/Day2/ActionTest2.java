package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by xiaqing on 2017/4/25.
 */
public class ActionTest2 {
    WebDriver driver;
    @BeforeMethod
    public void openFF(){
        driver = new FirefoxDriver();
    }
    //@AfterMethod
    //public void closeB() {
     //   driver.quit();
    //}

/*
  打开百度页面
  在百度一下按钮点击右键
 */
    @Test
    public void rightClick(){
        driver.get("https://www.baidu.com/");
        WebElement baiduButton= driver.findElement(By.id("su"));
        //实例化 Actions
        Actions action = new Actions(driver);
        //在百度一下按钮 点击右键
        action.contextClick(baiduButton).perform();
        }


  /*
  打开百度页面
  双击百度一下按钮
  */
    @Test
    public void doubleClick(){
        driver.get("https://www.baidu.com/");
        WebElement baiduButton= driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(baiduButton).perform();
    }

    /**
     *打开测试页面
     *鼠标移动到action按钮
     * 那么显示 hello world
     **/
    @Test
    public void moveTo(){
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath(".//*[@id='action']/input"));
        Actions actions = new Actions(driver);
        //移动鼠标到某个元素
        actions.moveToElement(element).perform();
        String text=driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(text,"Hello World!");
    }

    //拖动元素到坐标（x,y）
    @Test
    public void dragTest(){
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
    }

    //拖动元素到另一个元素上
    @Test
    public void dragToOther(){
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/dragAndDrop.html");
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.xpath("html/body/h1"));
        Actions actions = new Actions(driver);
      //  actions.dragAndDrop(element1,element2).perform();
        actions.clickAndHold(element1)
                .moveToElement(element2)
                .release(element2)
                .perform();
    }

    //下拉框多选
    @Test
    public void moreSelect() throws InterruptedException {
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();


        //为什么结果是选中了第一个和第三个？
    }

    @Test
// Robot类 模拟键盘操作
    public void  robotTest() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }


    @Test
    //上传文件
    public void uploade(){
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("D:\\Auto-tool\\webdriver\\selenium_html\\aa.html");
    }

}