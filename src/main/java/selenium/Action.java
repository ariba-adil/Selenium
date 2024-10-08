package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
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

        //click on Actions
        driver.findElement(By.xpath("//a[contains(text(),'Actions')]")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        //double click on double click here button
        WebElement doubleClick = driver.findElement(By.id("doubClickStartText"));
        actions.doubleClick(doubleClick);
        Thread.sleep(2000);
        System.out.println(doubleClick.getText());

        //click and hold on click and hold button
        actions.clickAndHold(driver.findElement(By.xpath("//div/p[text()='Click and Hold!']")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div/p[text()='Click and Hold!']")).getText());

        //hold shift and click here
        WebElement holdShiftAndClick = driver.findElement(By.xpath("//div/p[text()='Hold Shift & Click Here']"));
        //keyDown(Keys.SHIFT) - Simulates pressing the Shift key
        actions.keyDown(Keys.SHIFT).click(holdShiftAndClick).perform();
        Thread.sleep(2000);
        //keyUp(Keys.SHIFT) - releases the shift key
        actions.keyUp(Keys.SHIFT);
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);


//        WebElement draggableElement = driver.findElement(By.id("dragtarget"));
//        WebElement droppableElement = driver.findElement(By.id("//*[@id=\"main\"]/div/div[1]/div[1]/div[2]"));
//        actions.dragAndDrop(draggableElement, droppableElement).perform();
//        Thread.sleep(1000);
        driver.close();



    }
}
