package Week4Day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	private static final String FileUtils = null;
	private static final String By = null;
	private static final String OutputType = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		//search as Iphone 13 pro
		WebElement findElement = driver.findElement(By.id("twotabsearchtextbox"));
		findElement.sendKeys("Iphone 13 pro ",Keys.ENTER);
		//Get the price of first product
		WebElement price = driver.findElement(By.className("a-price-whole"));
        System.out.println("Price of the first product:"+ price.getText());
        //Print the number of customer ratings for the first displayed product
        WebElement noofcusRating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text'][1]"));
        System.out.println("The number of customer ratings:" + noofcusRating.getText());
        // Click the first text link of the first image
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
        //window Handling
        Set<String> windowHandles = driver.getWindowHandles();
        //covert set to list
        List<String> NextWindow=new ArrayList<String>(windowHandles);
        driver.switchTo().window(NextWindow.get(1));
              Thread.sleep(3000);
        //click 'Add to Cart' button
        driver.findElement(By.id("nav-cart")).click();
        //Take a screen shot of the product displayed
        File source=driver.getScreenshotAs(OutputType.FILE);
        File destination=new File("./snapshot/amazon.jpg");
        FileUtils.copyFile(source, destination);
        //Get the cart subtotal and verify if it is correct
        WebElement noofproduct = driver.findElement(By.id("nav-cart-count"));
        if(noofproduct.equals(noofproduct)) {
        	System.out.println("count is correct");
        }
        else {
        	System.out.println("count is wrong");
        }
        System.out.println("Total No.of products:" + noofproduct.getText());
       
        driver.close();
	}
}