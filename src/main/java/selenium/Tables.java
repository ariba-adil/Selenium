package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tables {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationtesting.co.uk/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //driver.navigate().to("https://automationtesting.co.uk/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/a")).click();
        Thread.sleep(1000);

        //click on Tables
        driver.findElement(By.xpath("//a[contains(text(),'Tables')]")).click();
        Thread.sleep(2000);

        //1. get rows count
        int rowsCount = driver.findElements(By.xpath("//table[@class='sortable']//tbody//tr")).size();
        System.out.println("rows count = " + rowsCount);

        //2. get columns count
        int colsCount = driver.findElements(By.xpath("//table[@class='sortable']//thead//th")).size();
        System.out.println("columns count = " + colsCount);

        //3. retrieve specific row column data - print residency Italy - hard coded
        System.out.println();
        System.out.println("retrieve specific row column data - hard coded");
        String residenceItaly = driver.findElement(By.xpath("//table[@class='sortable']//tr[2]//td[5]")).getText();
        System.out.println(residenceItaly);
        driver.findElement(By.xpath("//table[@class='sortable']//tr[2]//td[5]")).click();
        Thread.sleep(2000);
        System.out.println();


        //4. retrieve all data from table
        System.out.println("retrieve entire table");
        for(int i=1; i<=rowsCount;i++) {
            for(int j=1; j<=colsCount;j++) {
                String data = driver.findElement(By.xpath("//table[@class='sortable']//tbody//tr[" + i + "]//td[" + j + "]")).getText();
                    System.out.print(data + "     ");
            }
            System.out.println();
        }
        System.out.println();

        //5. sorting the table headers
        driver.findElement(By.xpath("//table[@class='sortable']//thead//th[3]")).click();
        Thread.sleep(2000);

        //6. print a specific row data - rows containing UK
        System.out.print("print a specific row data - rows containing UK");
        System.out.println();
        for(int a=1; a<=rowsCount; a++) {
            String residency = driver.findElement(By.xpath("//table[@class='sortable']//tbody//tr[" + a + "]//td[5]")).getText();
            //System.out.print(residency + " ");

            if(residency.equals("United Kingdom")) {
                for(int b=1; b<=colsCount; b++) {
                   String colsWithUK = driver.findElement(By.xpath("//table[@class='sortable']//tbody//tr[" + a + "]//td[" + b + "]")).getText();
                   System.out.print(colsWithUK + "   ");
                }
                System.out.println();
            }
        }


            driver.close();
        }
    }



