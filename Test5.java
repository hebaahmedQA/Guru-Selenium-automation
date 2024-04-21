import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class Test5 {


     /*     Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully.
      */




    public void test() {

        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://live.techpanda.org/";


        //Go to http://live.techpanda.org/

        driver.get(baseUrl);
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/a/span/span")).click();
        driver.findElement(By.id("firstname")).sendKeys("Heba");
        driver.findElement(By.id("middlename")).sendKeys("Ahmed");
        driver.findElement(By.id("lastname")).sendKeys("Gad");
        driver.findElement(By.id("email_address")).sendKeys("hebatest22@gmail.com");
        driver.findElement(By.id("password")).sendKeys("344827");
        driver.findElement(By.id("confirmation")).sendKeys("344827");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[2]/button")).click();
        ////////////////////////////////////////////////////////////

        String registermessage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")).getText();
        String successregist = "Thank you for registering with Main Website Store.";
       /* if (registermessage.equalsIgnoreCase(successregist))
            System.out.println("registration done.");
        else {
            System.out.println("registration failed.");
        }*/
        Assert.assertEquals(registermessage,successregist,"the user successfully register ");
        driver.quit();
    }




}



