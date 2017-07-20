package org.sri.dashng;

import org.testng.annotations.*;

/**
 * Created by sridhar.easwaran on 12/20/2016.
 */
public class DataProviderExample {

    @Test(dataProvider = "getData")
    public void setData(String username, String password) {
        System.out.println("you have provided username as: " + username);
        System.out.println("you have provided password as: " + password);
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[3][2];

        // 1st row
        data[0][0] = "user1";
        data[0][1] = "pwd123";

        // 2nd row
        data[1][0] = "user2";
        data[1][1] = "pwd456";

        // 3rd row
        data[2][0] = "user3";
        data[2][1] = "pwd789";

        Object[][] data1 =
                {
                    {"s", "s"},
                    {"d", "d"},
                    {"f", "f"},
                    {"x", "x"}
                };

        return data1;
    }
}
