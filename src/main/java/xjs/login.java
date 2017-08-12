package xjs;

import org.openqa.selenium.By;

/**
 * Created by xiaqing on 2017/8/5.
 */
public class login {
    //用户名
    public static By user = By.id("custid");
    //密码
    public static By pw = By.xpath("//*[@id=\"login-form\"]/table/tbody/tr[2]/td[2]/span/div/input");
    //验证码
    public static By code = By.id("validatecode");
    //登录按钮
    public static By loginButton = By.xpath("//*[@id=\"btnlogin\"]");
    //产品中心
    public static By cpzx = By.xpath(".//*[text()='产品中心']");
    //资产类产品管理
    public static By zclcpgl = By.xpath(".//*[text()='资产类产品管理']");
    //资产转让发布
    public static By zczrfb = By.xpath(".//*[text()='资产转让发布']");
    //资产转让发布下一步
    public static By next = By.xpath("//*[@id=\"auctionAddForm\"]/dl/dd[3]/button");
    //资产发布产品名称
    public static By cpmc = By.name("title");
    //资产转让方
    public static By zczrf =By.id("custid");
    //挂牌转让金额
    public static By gpzrje =By.name("unitpirce");
    //预期年化收益率
    public static By yqnhsyl =By.id("asset_annual");
    //产品期限
    public static By cpqx =By.id("asset_deadline");
    //挂牌公告期限
    public static By gpggqx =By.id("transfer_deadline");
    //发布转让按钮
    public static By fbzr =By.xpath(".//*[text()='发布转让']");
//-----理财产品




}
