package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameUse {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement findElement2 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        //first frame
        driver.switchTo().frame(findElement2);
        driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("ANIMALS WORLD");
        //switch to innerframe
        WebElement findElement3 = driver.findElement(By.id("frame3"));
        driver.switchTo().frame(findElement3);
        driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
        Thread.sleep(3000);
        //driver.switchTo().frame("frame2");
        driver.switchTo().defaultContent();
        WebElement findElement4 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
        driver.switchTo().frame(findElement4);
        WebElement findElement = driver.findElement(By.id("animals"));
	      Select Ani=new Select(findElement);
	      Ani.selectByVisibleText("Baby Cat");
	      Thread.sleep(3000);
	}

}