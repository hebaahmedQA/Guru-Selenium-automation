
import dev.failsafe.function.CheckedRunnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
/* Test Case requirements/descriptions:
 *    Export all Orders in csv file and display these information in console and
 *    you are able to send this file to another email id as attachment
 * Note: Access to backend of the site. UserId "user01" and pw "user001"
 *
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Select 'CSV' in Export To dropdown and click Export button.


Expected results:
1) Console displays all order information
2) Email is sent successfully
*/
@Test (priority = 10)
public class Test10 {


    public void testCase10 () throws InterruptedException {
        //1. Go to http://live.techpanda.org/index.php/backendlogin
        //2. Login the credentials provided
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://live.techpanda.org/index.php/backendlogin";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("user01");
        driver.findElement(By.xpath("//input[@id = 'login']")).sendKeys("guru99com");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        Thread.sleep(3000);
        //Close the info popup window
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/a")).click();

        //3. Go to Sales-> Orders menu

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a/span")).click();
        Thread.sleep(3000);

        // 4. Select 'CSV' in Export To dropdown and click Export button.
        driver.findElement(By.xpath("//button[@title = 'Export']")).click();
        if (driver.findElement (By.xpath("/html/body/div/div/div[2]/div/div/div/h1")).isDisplayed());
        {
            System.out.println("CSV file is not uploded , message 'error There has been an error processing your request' is  displaying ");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e2) {

            e2.printStackTrace();
        }
        driver.quit();


    }

}
