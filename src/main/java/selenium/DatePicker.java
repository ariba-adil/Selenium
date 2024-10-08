package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DatePicker {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationtesting.co.uk/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.navigate().to("https://automationtesting.co.uk/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/a")).click();
        Thread.sleep(1000);

        //click on Date Picker
        driver.findElement(By.xpath("//a[contains(text(),'Date Picker')]")).click();
        Thread.sleep(2000);

        //click on basic date time
        driver.findElement(By.xpath("//input[@id='basicDate']")).click();
        Thread.sleep(2000);

        WebElement arrowUp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/span[1]"));
        WebElement arrowDown = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/span[2]"));
        WebElement previousBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[1]"));
        WebElement nextBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/span[2]"));

        String monthYear = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div")).getText();
        //String year = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/input")).getText();

        while(!(monthYear.equals("December 2025"))) {
            nextBtn.click();
            Thread.sleep(1000);
            monthYear = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div")).getText();

        }


        //click on 30
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/span[35]")).click();
        Thread.sleep(2000);


        driver.close();


    }
}
