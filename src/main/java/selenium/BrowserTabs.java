package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserTabs {
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


       //get window handles
        Set <String> handler = driver.getWindowHandles();
        System.out.println(handler);
        Iterator <String> it = handler.iterator();

        String parentWindowID = it.next();
        System.out.println("Parent window id is : " + parentWindowID);

        String childWindowID = it.next();
        System.out.println("Child window id is : " + childWindowID);

        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.switchTo().window(parentWindowID);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.switchTo().window(childWindowID);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);

        driver.switchTo().window(parentWindowID);
        System.out.println(driver.getTitle());
        driver.close();


////        // Get the main window handle
//        String mainWindowHandle = driver.getWindowHandle();
//
//        // Perform operations in the main window
//        // ...
//
//        // Switch to a new window or popup (assuming one is opened)
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(mainWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//                // Perform operations in the new window
//                // ...
//                // Close the new window
//                driver.close();
//                break;
//            }
//
//        }
//
//        // Switch back to the main window
//        driver.switchTo().window(mainWindowHandle);
//
//        // Continue operations in the main window
//        // ..
//
//        driver.close();
    }
}
