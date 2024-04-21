import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
		Test Steps:
		1. Goto http://live.techpanda.org/
		2. Click on ‘MOBILE’ menu
		3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
		4. Click on Sony Xperia mobile
		5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100).
		*/
@Test (priority = 2)
public class Test2 {

    public void Test() throws InterruptedException {
           WebDriver driver = new FirefoxDriver();
           //Go to http://live.techpanda.org/
           String baseUrl;
           baseUrl = "http://live.techpanda.org/";
           driver.get(baseUrl);
           driver.findElement(By.cssSelector("li.level0:nth-child(1) > a:nth-child(1)")).click();
           Thread.sleep(2000);


           //In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
           String price = driver.findElement(By.cssSelector("li.item:nth-child(1) > div:nth-child(2) > div:nth-child(2)")).getText();
           System.out.println("the cost of Sony Xperia mobile is " + price);


           // Click on Sony Xperia mobile
           driver.findElement(By.xpath("//*[@id=\"product-collection-image-1\"]")).click();


           //Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100).
        String detalisprice = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[3]/div[2]")).getText();
           System.out.println("the cost of Sony Xperia mobile is " + detalisprice);
           if
           (price.equals(detalisprice)) {
               System.out.println("Product value in list and details page is eual to 100 ");
           } else {
               System.out.println("Product value in list and details page is not equal  ");
           }


           // quit window
           driver.quit();


           }



}









