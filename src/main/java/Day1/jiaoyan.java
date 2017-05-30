package Day1;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xiaqing on 2017/4/16.
 */
public class jiaoyan {
    @Test
    public void assertEquals(){
        String a="abc" ;
        String b="abc";
        Assert.assertEquals(a,b,"a不等于b");
    }
    @Test
    public void assertNotEqual() {
        String a = "abc";
        String b = "bvc";
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assertNull(){
        String a=null;
        Assert.assertNull(a);
    }
    @Test
    public void assertNotNull(){
        String a="abc";
        Assert.assertNotNull(a);
    }
    @Test
    public void testFalse(){
        Boolean b=false;
        Assert.assertFalse(b);
    }
}
