package selenium;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Buttons extends LaunchChrome {
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

        //click on Buttons
        driver.findElement(By.xpath("//a[text()='Buttons']")).click();
        Thread.sleep(1000);

        //click on Button One using xpath locator
        WebElement buttonOne = driver.findElement(By.id("btn_one"));
        if(buttonOne.isDisplayed()) {
            buttonOne.click();
        }
        Thread.sleep(1000);
        Alert a1 = driver.switchTo().alert();
        System.out.println(a1.getText());
        a1.accept();
        Thread.sleep(1000);

        //click on Button Two
        //for clicking on two buttons
        //js.executeScript("arguments[0].click(); arguments[1].click();", buttonTwo, buttonThree);
        //or write click code two times in different lines

        WebElement buttonTwo = driver.findElement(By.id("btn_two"));
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].click();", buttonTwo);
        Thread.sleep(1000);
        System.out.println(a1.getText());
        a1.accept();
        Thread.sleep(2000);

        //click on Button Three using Action Move & Click
        WebElement buttonThree = driver.findElement(By.id("btn_three"));
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonThree).perform();
        Thread.sleep(2000);
        actions.click().perform();
        Thread.sleep(1000);
        System.out.println(a1.getText());
        a1.accept();
        Thread.sleep(2000);

        //disabled button
        WebElement buttonFour = driver.findElement(By.id("btn_four"));
        if(buttonFour.isEnabled()) {
            buttonFour.click();
        }
        else {
            driver.close();
        }
        driver.quit();



    }
}
