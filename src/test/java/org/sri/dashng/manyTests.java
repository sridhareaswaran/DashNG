package org.sri.dashng;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by sridhar.easwaran on 2/6/2017.
 */
public class manyTests {

    @Test(testName = "name is bond",description = "do i need one?",groups = {"g"})
    public void testMethod1() throws InterruptedException {
        Thread.sleep(10000);
        int x = 3;
        Assert.assertEquals(x,2);
    }

    @Test(groups = "g1",dataProvider = "getData")
    public void setData(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
    }

    @Test(groups = "g1")
    public void testMethod2() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test(enabled = false)
    public void testMethod3() {}

    @Test(groups = "g1")
    public void testMethod4() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test(groups = "g1")
    public void testMethod5() {}

    @Test(groups = "g1")
    public void testMethod6() throws InterruptedException {
        Thread.sleep(6000);
    }

    @Test
    public void testMethod7() {}

    @Test
    public void testMethod8() {}

    @Test(groups = "g1")
    public void testMethod9() {}

    @Test(groups = "g1")
    public void testMethod10() {}

    @Test
    public void testMethod11() throws InterruptedException {
        Thread.sleep(1500);
    }

    @Test(groups = "g1")
    public void testMethod12() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test(groups = "g")
    public void testMethod13() throws InterruptedException {

        Thread.sleep(9000);
        throw new SkipException("message");
    }

    @Test
    public void testMethod14() {}

    @Test
    public void testMethod15() {}

    @Test
    public void testMethod16() {}

    @Test
    public void testMethod17() {}

    @Test
    public void testMethod18() {}

    @Test
    public void testMethod19() {}

    @Test
    public void testMethod20() {}

    @Test
    public void testMethod21() {}

    @Test
    public void testMethod22() {}

    @Test
    public void testMethod23() {}

    @Test
    public void testMethod24() {}

    @Test
    public void testMethod25() {}

    @Test
    public void testMethod26() {}

    @Test
    public void testMethod27() {}

    @Test
    public void testMethod28() {}

    @Test
    public void testMethod29() {}

    @Test
    public void testMethod30() {}

    @Test
    public void testMethod31() {}

    @Test
    public void testMethod32() {}

    @Test
    public void testMethod33() {}

    @Test
    public void testMethod34() {}

    @Test
    public void testMethod35() {}

    @Test
    public void testMethod36() {}

    @Test
    public void testMethod37() {}

    @Test
    public void testMethod38() {}

    @Test
    public void testMethod39() {}

    @Test
    public void testMethod40() {}

    @Test
    public void testMethod41() {}

    @Test
    public void testMethod42() {}

    @Test
    public void testMethod43() {}

    @Test
    public void testMethod44() {}

    @Test
    public void testMethod45() {}

    @Test
    public void testMethod46() {}

    @Test
    public void testMethod47() {}

    @Test
    public void testMethod48() {}

    @Test
    public void testMethod49() {}

    @Test
    public void testMethod50() {}

    @Test
    public void testMethod51() {}

    @Test
    public void testMethod52() {}

    @Test
    public void testMethod53() {}

    @Test
    public void testMethod54() {}

    @Test
    public void testMethod55() {}

    @Test
    public void testMethod56() {}

    @Test
    public void testMethod57() {}

    @Test
    public void testMethod58() {}

    @Test
    public void testMethod59() {}

    @Test
    public void testMethod60() {}

    @Test
    public void testMethod61() {}

    @Test
    public void testMethod62() {}

    @Test
    public void testMethod63() {}

    @Test
    public void testMethod64() {}

    @Test
    public void testMethod65() {}

    @Test
    public void testMethod66() {}

    @Test
    public void testMethod67() {}

    @Test
    public void testMethod68() {}

    @Test
    public void testMethod69() {}

    @Test
    public void testMethod70() {}

    @DataProvider
    public Object[][] getData() {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[3][2];

        // 1st row
        data[0][0] = "sample user1";
        data[0][1] = "abcdef";

        // 2nd row
        data[1][0] = "test user2";
        data[1][1] = "zxcvb";

        // 3rd row
        data[2][0] = "guest user3";
        data[2][1] = "pass123";

        Object[][] data1 = {
                {"s", "s"},
                {"d", "d"},
                {"f", "f"},
                {"x", "x"}
        };

        return data1;
    }

}
