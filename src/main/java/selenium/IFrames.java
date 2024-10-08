package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IFrames {
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

        //click on IFrames
        driver.findElement(By.xpath("//a[contains(text(),'iFrames')]")).click();
        Thread.sleep(2000);

        //switching to second frame - youtube
        driver.switchTo().frame(1);
        Thread.sleep(1000);
        //click on play
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        Thread.sleep(3000);
        //click on pause
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        Thread.sleep(2000);

        //switching to frame 1
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='toggle']")).click();
        Thread.sleep(2000);
        //click on button
        List<WebElement> elements = driver.findElements(By.xpath("//a[text()='Buttons']"));
        elements.get(0).click();
        //WebElement elementTwo = elements.get(1);
//        elementTwo.click();
        Thread.sleep(2000);
        //click on button one
        driver.findElement(By.id("btn_one")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals("You clicked the first button!",alert.getText());
        Assert.assertEquals("You clicked the first button!",alert.getText(), "title not matches");
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(2000);
        driver.close();

    }
}
