import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



/*Test Steps:
        1. Go to http://live.techpanda.org/
        2. Click on My Account link
        3. Login in application using previously created credential
        4. Click on 'My Orders'
        5. Click on 'View Order'
        6. *** note: After steps 4 and 5, step 6 "RECENT ORDERS" was not displayed
        Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
        7. Click on 'Print Order' link
        8. *** note: the link was not found.
        Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
        9. *** unable to execute this step, due to issue with step 8 issue
        Click on 'Save' button and save the file in some location.
        10. *** unable to execute this step, due to steps 8 and 9 issues.
        Verify Order is saved as PDF

        */





@Test
public class Test7 {



    public void test7() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://live.techpanda.org/";
        // go to  "http://live.techpanda.org/"

        driver.get(baseUrl);


        //Click on my account and login
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
        driver.findElement(By.id("email")).sendKeys("hebatest10@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("344827");
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

        // 4. Click on 'My Orders'
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")).click();

        //  Click on 'View Order'
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/span/a[1]")).click();
        //Click on 'Print Order' link

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]")).click();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);

        }
        driver.quit();

    }


    }