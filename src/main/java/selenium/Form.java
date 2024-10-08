package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form {
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

        //click on 'contact us form test'
        driver.findElement(By.xpath("//a[text()='Contact Us Form Test']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("first_name")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("first_name")).sendKeys("Tom");
        Thread.sleep(1000);
        driver.findElement(By.name("last_name")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("last_name")).sendKeys("T");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("tom123@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("message")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("message")).sendKeys("abc");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.close();




    }
}