package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Checbox_RadioButton {
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
        driver.findElement(By.xpath("//a[contains(text(),'DropDown Checkbox Radio')]")).click();
        Thread.sleep(1000);
        //clicking on second radio button
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div[2]/label")).click();
        Thread.sleep(1000);

        //check second and third checkboxes

        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/label[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/label[3]")).click();
        Thread.sleep(1000);

        //dropdown menu
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"cars\"]")));
        //select.selectByIndex(1);
        select.selectByValue("mercedes");
        //select.selectByVisibleText("Suzuki");
        Thread.sleep(5000);


        driver.close();

    }
}
