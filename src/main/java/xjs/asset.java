package xjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by xiaqing on 2017/8/5.
 */
public class asset {

    public static void zcfb(WebDriver driver, String productName) {
        //产品中心
        poSleep.click(driver,login.cpzx);
        //资产类产品管理
        poSleep.click(driver,login.zclcpgl);
        //资产转让发布
        poSleep.click(driver,login.zczrfb);
        //切换frame
        driver.switchTo().frame("J_mainCon");
        //点击进入下一步
        poSleep.click(driver,login.next);
        //填写产品名称
        poSleep.send(driver,login.cpmc,productName);
        //资产转让方
        poSleep.click(driver,login.zczrf);
        //产品发布人选择、输入查询条件
        poSleep.send(driver,By.xpath("//*[@id=\"hm\"]"),"0731报送2");
        //点击查询
        driver.findElement(By.xpath("//*[text()='查询']")).click();
        //选中一审核人
        poSleep.click(driver,By.xpath("//*[@class=\"datagrid-body\"]/div[1]/table/tbody/tr[1]"));
        //点击确认
        poSleep.click(driver,By.xpath("//*[text()='确认']"));
        //选择是否绿色通道
        Select s1 = new Select(driver.findElement(By.id("JGreenChannel")));
        s1.selectByValue("1");
        //挂牌转让金额
        driver.findElement(login.gpzrje).sendKeys("588");
        //预期年化收益率
        driver.findElement(login.yqnhsyl).sendKeys("12");
        //产品期限
        driver.findElement(login.cpqx).sendKeys("10");
        //挂牌转让期限
        driver.findElement(login.gpggqx).sendKeys("5");
        //点击发布转让
        driver.findElement(login.fbzr).click();
        //发布成功后点击确定按钮
        poSleep.click(driver,By.xpath(".//*[text()='确定']"));
        driver.switchTo().defaultContent();
    }

    public static void shenhe(WebDriver driver,String productname){
        //进入欢迎页
        driver.findElement(By.xpath(".//*[text()='欢迎页']")).click();
        driver.switchTo().frame("J_mainCon");
        //点击更多
        poSleep.click(driver,By.xpath("//*[@id=\"J_more\"]/a"));
        //点击审核链接
        poSleep.click(driver,By.xpath(".//*[contains(text(),'"+productname+"')]"));
        //poSleep.click(driver,By.xpath(".//*[contains(text(),'0805资产4')]"));
        //进入资产审核页面,点击放大镜
        poSleep.click(driver,By.xpath("//*[@id=\"userSelect\"]/span/span/span"));
        //选择审核人
        poSleep.click(driver,By.xpath("//*[@class='datagrid-body-inner']/table/tbody/tr[1]"));
        //确定审核人
        driver.findElement(By.xpath("//*[@id=\"executor\"]/div[2]/a/span/span[1]")).click();
        //提交审核
        poSleep.click(driver,By.xpath("//*[@id=\"ok\"]/span/span[2]"));
        //二次确认
        poSleep.click(driver,By.xpath("/html/body/div[5]/div[2]/div[4]/a/span/span[2]"));
        //审核第二步
        driver.switchTo().defaultContent();
        poSleep.click(driver,By.xpath(".//*[text()='欢迎页']"));
        driver.switchTo().frame("J_mainCon");
        //点击审核链接
        poSleep.click(driver,By.xpath(".//*[contains(text(),'"+productname+"')]"));
        //点击确认
        poSleep.click(driver,By.xpath(".//*[text()='确定']"));
        //二次确认
        poSleep.click(driver,By.xpath("/html/body/div[5]/div[2]/div[4]/a/span/span[2]"));
        driver.switchTo().defaultContent();
    }
}
