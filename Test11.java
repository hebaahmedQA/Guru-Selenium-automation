
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement ;

import java.util.List;

/*"1.Go to http://live.techpanda.org/index.php/backendlogin
        2.Login the credentials provided
        3.Go to Sales-> Orders menu
        4.In the status field select ""Canceled"". Click Search
        5.Select the checkbox next to first order
        6.In Actions, select ""Print Invoices"". Click Submit
        7.Verify the error message
        */
@Test (priority = 11)
public class Test11 {

    WebDriver driver = new FirefoxDriver();
    public void Test11()throws InterruptedException{

        //1. Go to http://live.techpanda.org/index.php/backendlogin
        //2. Login the credentials provided

        String baseUrl = "http://live.techpanda.org/index.php/backendlogin";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("user01");
        driver.findElement(By.xpath("//input[@id = 'login']")).sendKeys("guru99com");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        Thread.sleep(4000);
        //Close the info popup window
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/a")).click();

        //3. Go to Sales-> Orders menu

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a/span")).click();
        Thread.sleep(7000);

        //4. In the status field select ""Canceled"". Click Search
        WebElement dropDown = driver.findElement(By.id("sales_order_grid_filter_status"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Canceled");
        // Click Search
        Thread.sleep(4000);

        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/table/tbody/tr/td[3]/button[2]/span/span/span")).click();
        //5.Select the checkbox next to first order
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[1]/td[1]/input")).click();
        //6.In Actions, select ""Print Invoices"". Click Submit
        Thread.sleep(6000);
        WebElement actionsDropdown = driver.findElement(By.xpath("//*[@id=\"sales_order_grid_massaction-select\"]"));
        Select selectAction = new Select(actionsDropdown);
        selectAction.selectByVisibleText("Print Invoices");
        //click submit
        Thread.sleep(6000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[1]/table/tbody/tr/td[2]/div/div[1]/form/fieldset/span[4]/button/span/span/span")).click();

        //7.Verify the error message
        String actualErrorMg =  driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/ul/li")).getText();
        String expextedErrorMg = "There are no printable documents related to selected orders.";
        if (expextedErrorMg.equals(actualErrorMg)){

            System.out.println("The error verification passed successfully");
        }
        else {
            System.out.println("The error verification failed");

        }
        driver.quit();








    }

}

