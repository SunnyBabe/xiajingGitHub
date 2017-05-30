package Day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/5/4.
 */
public class JStest {
    //执行JS脚本
    @Test
    public void exJs(){
        WebDriver driver= new FirefoxDriver();
        driver.get("https://www.baidu.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //设置属性值maxlength为300
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"maxlength\",\"300\")");

    }
}
