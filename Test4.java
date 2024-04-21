import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest ;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/*
			Test Steps:
				1. Goto http://live.techpanda.org/
				2. Click on ‘MOBILE’ menu
				3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
				4. Click on ‘COMPARE’ button.
				5. Verify the pop-up window and check that the products are reflected in it
				 Heading "COMPARE PRODUCTS" with selected products in it
				6. Close the Popup Windows
				*/


@Test
public class Test4 {

    public void Test4() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Go to http://live.techpanda.org/
        String  baseUrl = "http://live.techpanda.org/";
        driver.get(baseUrl);


        //2. Click on ‘MOBILE’ menu
        driver.findElement(By.linkText("MOBILE")).click();
        String mobilepage = driver.getWindowHandle();
        System.out.println(mobilepage);
        String IphoneMobile;
        driver.findElement(By.cssSelector(".products-grid > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)")).click();
        String SonyMobile;
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button")).click();

        String comparepage = driver.getWindowHandle();

       // System.out.println(comparepage);
        Set<String> Allwindows = driver.getWindowHandles();
        //System.out.println(Allwindows);




        // switching to compare page
        for (String comparewindow : Allwindows) {
            if (!comparewindow.equalsIgnoreCase(mobilepage))
                driver.switchTo().window(comparewindow);
            System.out.println(driver.getTitle());
            Thread.sleep(2000);


        }


// 5. Verify the pop-up window and check that the products are reflected in it
        //    Heading "COMPARE PRODUCTS" with selected products in it.
        String mobile1Name = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
        String mobile2Name = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
        String actualPageTiltle = ("COMPARE PRODUCTS");
        String ExcomparePageTitle= driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();
        System.out.println("Compare page title  = "+ExcomparePageTitle);
        String actualMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
        String actualMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
        System.out.println("Mobile1 name  = "+mobile1Name);
        System.out.println("Mobile2 name = "+mobile2Name);
        Thread.sleep(2000);


            try
            {

                assertEquals(mobile1Name, actualMobile1, "IPHONE");
                assertEquals(mobile2Name,actualMobile2,"SONY XPERIA");
                 {
                     System.out.println("compare window contains the correct product which is  "+mobile1Name );
                     System.out.println("compare window contains the correct product which is  "+mobile2Name );
                }

            } catch (Exception e) {
                throw new RuntimeException(e);


            }
            driver.close();

            driver.quit();
        }








    }
