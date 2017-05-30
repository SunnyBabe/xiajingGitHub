package Day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/5/29.
 */
public class datadriver {
   @DataProvider(name = "logindata")
    public Object[][] data(){
       return new Object[][]{
               {"user1","pwd1"}, {"user2","pwd2"}
       };
    }

    @Test(dataProvider = "logindata")
   public void test(String user,String pwd)
    {
        System.out.println("user:"+user);
        System.out.println("pwd:"+pwd);
    }

}
