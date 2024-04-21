import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest ;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;





/*  Verify user is able to purchase product using registered email id(USE CHROME BROWSER)
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate
8. Verify Shipping cost generated
9. Select Shipping Cost, Update Total
10. Verify shipping cost is added to total
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button
16. Verify Oder is generated. Note the order number
*/
@Test
public class Test6 {


    public void test6() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();





        String baseUrl = "http://live.techpanda.org/";

        // go to  "http://live.techpanda.org/"
        baseUrl = "http://live.techpanda.org/";
        //Click on account and login
        driver.get(baseUrl);
        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[5]/div/ul/li[6]/a")).click();
        driver.findElement(By.id("email")).sendKeys("hebatest20@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("344827");
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();









        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        // In next page, Click ADD TO CART link
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button/span/span")).click();
        //Enter general shipping country, state/province and zip for the shipping cost estimate and Click Estimate

        new Select(driver.findElement(By.xpath("//*[@id=\"country\"]"))).selectByVisibleText("United States");
        new Select(driver.findElement(By.xpath("//*[@id=\"region_id\"]"))).selectByVisibleText("New York");
        driver.findElement(By.id("postcode")).sendKeys("542896");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form/div/button/span/span")).click();

        //Verify Shipping cost generated

        String flatRate = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dt")).getText();
        String esflatRate  = "Flat Rate";

        if ( esflatRate.equals(flatRate) )
            System.out.println("The Shipping cost generated successfully");
        else
            System.out.println("The Shipping cost did not generated ");

        String Flatrateprice = "Fixed - $5.00";
        String EsFlatrateprice = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dd/ul/li/label")).getText();
        try {
            System.out.println("EsflatRatePrice = "+EsFlatrateprice);
            System.out.println("Flatrateprice = "+Flatrateprice);
            assertEquals(
                    EsFlatrateprice, Flatrateprice);
        } catch (Exception e) {
            e.printStackTrace();

        }

        // Select Shipping Cost, Update Total
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dd/ul/li/label")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/div/button")).click();

        //Verify shipping cost is added to total

        String VeFlatRatePrice = "$5.00";
        String shippingCostAdded = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();

        try {
            System.out.println("vFlatRatePrice = "+VeFlatRatePrice);
            System.out.println("shippingCostIncluded = "+shippingCostAdded);
            assertEquals(VeFlatRatePrice, shippingCostAdded);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 11. Click PROCEED TO CHECKOUT
        driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();


        //Enter Billing Information, and click Continue
        //12b. Enter Shipping Information, and click Continue
      //  13. In Shipping Method, Click Continue
        Thread.sleep(3000);
        driver.findElement(By.id("billing:company")).sendKeys("ABC");
        driver.findElement(By.id("billing:street1")).sendKeys("ABC");
        driver.findElement(By.id("billing:city")).sendKeys("New York");
        driver.findElement(By.id("billing:street2")).sendKeys("YX");
        new Select(driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]"))).selectByVisibleText("New York");
        driver.findElement(By.id("billing:telephone")).sendKeys("13456789");
        driver.findElement(By.id("billing:fax")).sendKeys("0000000");
        driver.findElement(By.id("billing:postcode")).sendKeys("1233");
        // check radio button to "Ship to different address"
        driver.findElement(By.id("billing:use_for_shipping_no")).click();

        // click the CONTINUE button
        // after the click above, it is still on same web page: live.guru99.com/index.php/checkout/onepage/

        driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("shipping:firstname")).sendKeys("Heba");
        driver.findElement(By.id("shipping:middlename")).sendKeys("Ahmed");
        driver.findElement(By.id("shipping:lastname")).sendKeys("Gad");
        driver.findElement(By.id("shipping:street1")).sendKeys("new york ST");

        // shipping country must be selected first from dropdown
        new Select(driver.findElement(By.xpath("//select[@id='shipping:country_id']"))).selectByIndex(14);
        // once Australia is selected, then the region and city becomes simply a text input, instead of dropdown

        driver.findElement(By.id("shipping:region")).sendKeys("london");
        driver.findElement(By.id("shipping:city")).clear();
        driver.findElement(By.id("shipping:city")).sendKeys("liverpool");
        driver.findElement(By.id("shipping:postcode")).sendKeys("2000");
        driver.findElement(By.id("shipping:telephone")).sendKeys("8034 1234");
        driver.findElement(By.id("shipping:company")).sendKeys("jjjj");
        driver.findElement(By.id("shipping:street2")).sendKeys("wwwww");
        driver.findElement(By.id("shipping:fax")).sendKeys("14552554");

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[2]/div[2]/form/div/button")).click();

        Thread.sleep(3000);


        // 13. In Shipping Method, Click Continue
        driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click();

        Thread.sleep(3000);

        //14. In Payment Information select 'Check/Money Order' radio button. Click Continue
        driver.findElement(By.xpath("//*[@id=\"p_method_checkmo\"]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")).click();
        Thread.sleep(3000);
        //15. Click 'PLACE ORDER' button
        driver.findElement(By.cssSelector(".btn-checkout")).click();
        //16. Verify Oder is generated. Note the order number

        String OrdeRecievedSt = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/h1")).getText();
        String OrderRecievedMg = "Your order has been received" ;

        if (!OrdeRecievedSt.equals(OrderRecievedMg)) {
            System.out.println(OrderRecievedMg ) ;
        } else {
            System.out.println("Order is not generated");
        }

        Thread.sleep(3000);

        String OrderNum = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/p[1]/a")).getText();
        System.out.println(" Your order number for your record = " + OrderNum);

        driver.quit();
    }


}



































