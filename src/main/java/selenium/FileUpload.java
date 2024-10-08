package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String [] args) throws InterruptedException {

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

        //click on Mouse Movement
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='fileToUpload']")).sendKeys("C:\\Users\\DELL\\Desktop\\Selenium.txt");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Thread.sleep(2000);

        driver.close();
    }
    }
