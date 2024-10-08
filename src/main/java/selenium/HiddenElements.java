package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HiddenElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationtesting.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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

        //click on Hidden Elements
        driver.findElement(By.xpath("//a[text()='Hidden Elements']")).click();
        Thread.sleep(2000);

        //click on toggle button
        driver.findElement(By.xpath("//button[text()='Toggle']")).click();
        Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//div[@id='myDIV']")).getText();
        if(text.equals("You have displayed the hidden text!")) {
            System.out.println(text);
        }


        driver.close();

    }
}
