package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {
    public static void main(String [] args) throws InterruptedException {

       System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://automationtesting.co.uk/");
       Thread.sleep(1000);
       //driver.navigate().to("https://automationtesting.co.uk/");
       System.out.println(driver.getCurrentUrl());
       Thread.sleep(1000);
       System.out.println(driver.getTitle());
       Thread.sleep(1000);

       driver.findElement(By.xpath("//*[@id=\"sidebar\"]/a")).click();
       Thread.sleep(1000);
       driver.close();
    }


}
