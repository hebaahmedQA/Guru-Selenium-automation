import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test (priority = 1)
public class Test1 {
    public void TestDay1() {
        //Go to http://live.techpanda.org/
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://live.techpanda.org/";
        driver.get(baseUrl);



        //Step 2. Verify Title of the page
        String actualpagetitle = "Home page";
        String expectedtitle = driver.getTitle();
        if (actualpagetitle.equalsIgnoreCase(expectedtitle)) {
            System.out.println("Title verfication passed");
        } else {
            System.out.println("Title verfication failed");
        }


        
        //Step 3. Click on ‘MOBILE’ menu
        driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a")).click();
        //	Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
        // Step 6. Verify all products are sorted by name
        WebElement sortDropdown = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
        sortDropdown.click();
        Select dropdownSelect = new Select(sortDropdown);
        dropdownSelect.selectByVisibleText("Name");
        driver.quit();


    }
    }

