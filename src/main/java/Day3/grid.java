import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by x on 2017/4/13.
 */
public class grid {
    @DataProvider(name = "date")
    public Object[][] dateT()
    {
        return new Object[][]{
                {"chrome","http://192.168.6.1:5555/wd/hub"},
                {"firefox","http://192.168.6.1:8888/wd/hub"},
        };
    }

    @Test(dataProvider = "date")
    public  void  testChrome(String broswer,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if(broswer.contentEquals("chrome")) {
            dc=DesiredCapabilities.chrome();
        } else if (broswer.contentEquals("firefox")){
            dc=DesiredCapabilities.firefox();
        }
        WebDriver driver= new RemoteWebDriver(new URL(url),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.close();
    }


}
