package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accordion {
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

        //click on accordion
        driver.findElement(By.xpath("//a[contains(text(),'Accordion')]")).click();
        Thread.sleep(1000);

        //click on Platform Portability
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[1]")).click();
        Thread.sleep(1000);

        //click on Selenium Grid
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[5]")).click();
        Thread.sleep(1000);

        //click on Language Support
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[3]")).click();
        Thread.sleep(1000);

        for(int i=0;  i<=10; i++) {
            //click on Platform Portability
            driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[1]")).click();
            Thread.sleep(1000);
            //click on Language Support
            driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[3]")).click();
            Thread.sleep(1000);
            //click on Selenium Grid
            driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[5]")).click();
            Thread.sleep(1000);
        }

        driver.close();
    }
}
