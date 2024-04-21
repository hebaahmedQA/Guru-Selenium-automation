import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*  Verify you are able to change or reorder previously added product
 *  Test Data = QTY = 10
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Login in application using previously created credential
4. Click on 'REORDER' link , change QTY & click Update
5. Verify Grand Total is changed
6. Complete Billing & Shipping Information
7. Verify order is generated and note the order number

Expected outcomes:
1) Grand Total is Changed
2) Order number is generated
*/

@Test
public class Test8 {





    public void Test8() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://live.techpanda.org/";


        driver.get(baseUrl);
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.id("email")).sendKeys("hebatest13@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("344827");
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();


        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[3]/table/tbody/tr/td[6]/span/a[2]")).click();

        driver.findElement(By.xpath("//input[@title='Qty']")).clear();


        driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("10");

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button")).click();
        // Verify Grand Total is changed
        String ExectedPrice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
        System.out.println(ExectedPrice);
        String ActualPrice = ("$1,050.00");

        if (ActualPrice.equals(ExectedPrice)) {
            System.out.println("Grand Total is changed");
        } else {
            {
                System.out.println("Grand Total is not changed");

            }
        }
        //Complete Billing & Shipping Information
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_yes\"]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"p_method_checkmo\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")).click();

        //15. Click 'PLACE ORDER' button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button")).click();

        //16. Verify Oder is generated. Note the order number

        Thread.sleep(3000);

        String OrderNum = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/p[1]/a")).getText();
        System.out.println(" Your order number for your record = " + OrderNum);

        driver.quit();

    }

















        }































