package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Practice {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Windows.html");
        //driver.navigate().to("https://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println(linkList.size());
        for(int i=0; i<linkList.size(); i++) {
            String linkText = linkList.get(i).getText();
            System.out.println(linkText);

            if(linkText.contains("click")){
                linkList.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it  = windowHandles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());

        driver.switchTo().window(childWindow);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);



        driver.quit();
    }
}
