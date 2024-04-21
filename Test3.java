import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest ;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
		Test Steps:
		1. Goto http://live.techpanda.org/
		2. Click on ‘MOBILE’ menu
		3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
		4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed
		   "The requested quantity for "Sony Xperia" is not available.
		5. Verify the error message
		6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
		7. Verify cart is empty
		*/
@Test (priority = 3)
public class Test3 {
    public void Test3 (){
        //1. Goto http://live.techpanda.org/
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://live.techpanda.org/";
        driver.get(baseUrl);


        //Click on ‘MOBILE’ menu
        driver.findElement(By.linkText("MOBILE")).click();
        //In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")).click();

        // Change ‘QTY’ value to 1000 and click ‘UPDATE’ button
        //	Expected that an error is displayed "The requested quantity for "Sony Xperia" is not available.

        driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
        driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button")).click();
        //Verify the error message
        String actualerror = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[2]/p")).getText();

        String expectederror;
        expectederror = "* The maximum quantity allowed for purchase is 500.";
        if
        (actualerror.equals(expectederror)) {
            System.out.println("Error message verfication passed");
        } else {
            System.out.println("Error message verfication failed");
        }


        //Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tfoot/tr/td/button[2]/span/span")).click();
        String actualemptymg = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/h1")).getText();
        String expectedemptymg = "SHOPPING CART IS EMPTY";
        if
        (expectedemptymg.equals(actualemptymg)) {
            System.out.println("Cart empty Error message verfication passed");
        } else {
            System.out.println("Cart empty Error message verfication failed");
        }
        driver.quit();




    }
























}
