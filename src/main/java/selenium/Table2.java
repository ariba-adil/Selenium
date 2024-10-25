package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Table2 {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println(linkList.size());
        for(int i=0; i<linkList.size(); i++) {
            String linkText = linkList.get(i).getText();
            if(linkList.get(i).getText().contains("Sortable Data Tables")) {
                linkList.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);

        int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("row count " + rowCount);
        int colCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
        System.out.println("col count " + colCount);

        for(int r =1; r<=rowCount; r++) {
            for(int c=1; c<=colCount; c++) {
                String tableData = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + r + "]/td[" + c + "]")).getText();
                System.out.print(tableData + "  ");
            }
            System.out.println();
        }

        for(int i=1; i<=rowCount; i++) {
            String due = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();
            if(due.equals("$50.00")) {
                for( int j=1; j<=colCount; j++) {
                    String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                    System.out.print(data + "  ");
                }
                System.out.println();
            }
        }




        driver.quit();
    }
    }
