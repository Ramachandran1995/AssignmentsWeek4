package Week4Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      ChromeDriver driver=new ChromeDriver();
      driver.get("http://www.leafground.com/pages/Window.html");
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
      Set<String> handles = driver.getWindowHandles();
      //convert set to list
      List<String> window1=new ArrayList<String>(handles);
      driver.switchTo().window(window1.get(1));
      System.out.println(driver.getTitle());
      driver.close();
      driver.switchTo().window(window1.get(0));
      //String windowHandle = driver.getWindowHandle();
      //driver.switchTo().window(windowHandle); 
      //driver.switchTo().window(window1.get(0));
      Thread.sleep(3000);
      driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
      Set<String> handles2 = driver.getWindowHandles();
      System.out.println(handles2.size());
      
      //convert to set to list
      List<String> window2= new ArrayList<String>(handles2);
      driver.switchTo().window(window2.get(1));
      System.out.println(driver.getTitle());
      driver.close();
      driver.switchTo().window(window2.get(2));
      System.out.println(driver.getTitle());
      driver.close();
      
      Thread.sleep(3000);
      driver.switchTo().window(window1.get(0));
      //String windowHandle = driver.getWindowHandle();
      //driver.switchTo().window(windowHandle);
      driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
      Set<String> handles3 = driver.getWindowHandles();
      // convert to List
      List<String> window3=new ArrayList<String>(handles3);
      driver.switchTo().window(window3.get(2));
      System.out.println(driver.getTitle());
      }
      }