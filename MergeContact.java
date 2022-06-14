package Week4Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
 WebElement eleusername = driver.findElement(By.id("username"));
 eleusername.sendKeys("Demosalesmanager");
 driver.findElement(By.id("password")).sendKeys("crmsfa");
 driver.findElement(By.className("decorativeSubmit")).click();
 driver.findElement(By.linkText("CRM/SFA")).click();
 driver.findElement(By.linkText("Contacts")).click();
 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
 // Handling the first window
 Set<String> Window= driver.getWindowHandles();
 //convert set to list
 List<String> List=new ArrayList<String>(Window);
 driver.switchTo().window(List.get(1));
 driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
 driver.switchTo().window(List.get(0));
 Thread.sleep(3000);
 driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
//Handling the second window
 Set<String> windowHandles = driver.getWindowHandles();
 //covert set to list
 List<String> List1=new ArrayList<String>(windowHandles);
 driver.switchTo().window(List1.get(1));
 Thread.sleep(3000);
 driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
 driver.switchTo().window(List1.get(0));
 
 driver.findElement(By.linkText("Merge")).click();
 //switch to alert
 Alert alert = driver.switchTo().alert();
 Thread.sleep(3000);
 System.out.println(alert.getText());
 alert.accept();
 System.out.println(driver.getTitle());
	}

}