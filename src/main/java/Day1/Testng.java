package Day1;

import org.testng.annotations.*;

/**
 * Created by xiaqing on 2017/4/16.
 */
public class Testng {
/* 执行顺序
    这是@BeforeSuite注解
    这是@BeforeTest注解
    这是@BeforeClass注解
    */

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是@BeforeClass注解");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("这是@BeforeSuite注解");
    }



    //运行这个类之前运行，只运行一次
    @BeforeTest
    public void testBefo(){
        System.out.println("这是@BeforeTest注解");
    }
    //每个test前都运行一次，多个test多次
    @BeforeMethod
    public void testMetod(){
        System.out.println("这是@BeforeMethod注解");
    }

    @Test
    public void testCase1(){
        System.out.println("这是@test注解,case1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是@test注解，case2");
    }
    //每个test后都运行一次，多个test多次
    @AfterMethod
    public void aftetMethod(){
        System.out.println("这是@AfterMethod注解");
    }
    //在类的最后运行一次
    @AfterTest
    public void aftetTset(){
        System.out.println("这是@AfterTest注解");
    }

}
