package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class PopupAndAlerts {
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

        //click on Popups and alerts
        driver.findElement(By.xpath("//a[text()='Pop Ups & Alerts']")).click();
        Thread.sleep(1000);

//        //click on Trigger popup button
        driver.findElement(By.xpath("//button[text()='Trigger Pop-up']")).click();
        Thread.sleep(1000);
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        Thread.sleep(1000);
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        driver.switchTo().window(childWindow);
        //Thread.sleep(1000);
//        driver.manage().window().maximize();
//
//        String childWindowTitle = driver.getTitle();
//        System.out.println(childWindowTitle);
//        if(childWindowTitle.equals("Pop Ups")) {
//            driver.close();
//        }
        driver.close();

        //click on Trigger Alert button
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Trigger Alert']")).click();
        Thread.sleep(1000);
        Alert triggerAlert = driver.switchTo().alert();
        Thread.sleep(1000);
        String triggerAlertText = triggerAlert.getText();
        System.out.println(triggerAlertText);
        if(triggerAlertText.equals("You have triggered the alert!")) {
            triggerAlert.accept();
        }
        Thread.sleep(1000);



        driver.quit();
    }
    }
