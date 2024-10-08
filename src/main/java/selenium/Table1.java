package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Table1 {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://the-internet.herokuapp.com/tables");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
        System.out.println("no of rows = " + rowsCount);
        int colsCount = driver.findElements(By.xpath("//table[@id='table1']//thead//tr//th")).size();
        System.out.println("no of cols = " + colsCount);

        //retrieve all data from table
        for(int r=1; r<=rowsCount; r++) {
            for(int c=1; c<=colsCount; c++) {
                String tableData = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.print(tableData + "   ");
            }
            System.out.println();
        }

        driver.findElement(By.xpath("//table[@id='table1']//thead//th[4]")).click();
        Thread.sleep(2000);
        //retrieving specific data
        System.out.println("retrieving specific data");
        for(int i=1; i<=rowsCount; i++) {
            String due = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td[4]")).getText();
            //System.out.println(due + "  ");
            if(due.equals("$50.00")) {
               for(int j=1; j<=colsCount; j++) {
                   String data = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td[" + j + "]")).getText();
                   System.out.print(data + "   ");
               }
               System.out.println();
            }
        }


        driver.close();


    }
}
