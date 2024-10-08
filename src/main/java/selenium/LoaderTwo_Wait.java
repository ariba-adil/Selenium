package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoaderTwo_Wait {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationtesting.co.uk/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //driver.navigate().to("https://automationtesting.co.uk/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/a")).click();
        Thread.sleep(2000);

        //click on LoaderTwo
        driver.findElement(By.xpath("//a[text()='Loader Two']")).click();
        Thread.sleep(2000);

       //click on click me button
        //WebDriverWait wait = new WebDriverWait();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='This is a new paragraph that appears after 8 seconds.']")));
        String text = driver.findElement(By.xpath("//*[text()='This is a new paragraph that appears after 8 seconds.']")).getText();
        if(text.equals("This is a new paragraph that appears after 8 seconds.")) {
            System.out.println(text);
        }
        driver.close();

    }
}
