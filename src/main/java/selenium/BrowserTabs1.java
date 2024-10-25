package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserTabs1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationtesting.co.uk/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //driver.navigate().to("https://automationtesting.co.uk/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/a")).click();
        Thread.sleep(1000);

        //click on browser tabs
        driver.findElement(By.xpath("//a[contains(text(),'Browser Tabs')]")).click();
        Thread.sleep(1000);

        //click on open tab button link
        driver.findElement(By.xpath("//input[@value=\"Open Tab\"]")).click();
        Thread.sleep(2000);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);


        driver.quit();

    }
    }
