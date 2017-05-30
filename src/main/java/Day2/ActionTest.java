package Day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

/**
 * Created by xiaqing on 2017/4/16.
 */
public class ActionTest {
    WebDriver driver;
    @BeforeMethod
    public void openFF(){
        driver = new FirefoxDriver();
    }
    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //点击打开新闻页面
        driver.findElement(By.name("tj_trnews")).click();
        Thread.sleep(3000);
        //获取当前页面url
        String Curr=driver.getCurrentUrl();
        //检验是否进入到新闻页面
        Assert.assertEquals(Curr,"http://news.baidu.com/");
    }
    @Test
    public void sendkeyTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //输入框输入selenium
        driver.findElement(By.id("kw")).sendKeys("selenium");
        //点击搜索
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        //获取当前页面title
        String title=driver.getTitle();
        //检验当前title是否为selenium_百度搜索
        Assert.assertEquals(title,"selenium_百度搜索");
    }
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        //输入框输入selenium
        WebElement element=driver.findElement(By.id("kw"));
        //输入框输入
        element.sendKeys("selenium");
        //输入框清空
        element.clear();
        //校验清空后是否为空
        String test1= element.getText();
        Assert.assertEquals(test1,"");
    }

    @Test
    public void getTagname(){
        driver.get("https://www.baidu.com/");
        //获取标签名
        String tagname=driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagname,"input");
    }

    @Test
    public void  getAttribute(){
        driver.get("https://www.baidu.com/");
        //获取按钮属性value的属性值
        String shu=driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(shu,"百度一下");
    }

    @Test
    public void  isDisplay() {
        driver.get("https://www.baidu.com/");
        //判断元素是否展示
        Boolean b=driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }
    @Test
    public void isSelected(){
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/index.html");
        //判断单选框是否选中
        driver.findElement(By.className("Volvo")).click();
        Boolean b = driver.findElement(By.className("Volvo")).isSelected();
        Assert.assertTrue(b,"校验是否选中");
    }
    @Test
    public void isEnabled(){
        driver.get("file:///D:/Auto-tool/webdriver/selenium_html/index.html");
        Boolean b = driver.findElement(By.name("Submit")).isEnabled();
        Assert.assertTrue(b,"校验元素是否激活");
    }

    @Test
    //页面截图
    public void screenShotFile(){
        driver.get("http://www.baidu.com");
        File a =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(a,new File("F:\\test.png"));
        }catch (IOException e)
        {e.printStackTrace();}
    }

    @AfterMethod
    public void closeB(){
        driver.quit();
    }

}
