
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test (priority = 9)
public class Test9 {
    public void Test9() {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = ("http://live.techpanda.org/");
        driver.get(baseUrl);
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
        driver.findElement(By.id("coupon_code")).sendKeys("GURU50");


        driver.findElement(By.xpath("//button[@title='Apply']")).click();

        //  3: Verify the discount generated
        String AmountAfterDiscount = driver.findElement(By.cssSelector("#shopping-cart-totals-table > tfoot:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > strong:nth-child(1) > span:nth-child(1)")).getText();
        System.out.println(AmountAfterDiscount);

        // Compare the actual discount with the expected discount

        double expectedDiscountedAmount = 500.00 * (1 - (25 / 100.0));
        System.out.println("$" + expectedDiscountedAmount);

        if (AmountAfterDiscount.equals("$" + expectedDiscountedAmount)) {
            System.out.println("Discount coupon works correctly. Price is discounted by 25%.");
        } else {
            System.out.println("Discount coupon verification failed. Price is not correctly discounted.");
            driver.quit();


        }


    }
}




























