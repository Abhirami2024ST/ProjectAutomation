package Testpackage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pagepackage.Loginpage;

public class Testpage 
{
 WebDriver driver;
 @BeforeTest
 public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Index.html");
	}
  @Test(priority = 1)
  public void Logintest()
  {
	  Loginpage l=new Loginpage(driver);
	  l.loginmail("sachin16294@gmail.com");
	  l.LoginClick();
	  System.out.println("Test1 Passed Successfully");
  }
  @Test(priority = 2)
  public void Registerdetails() throws InterruptedException 
  {
	Loginpage l1=new Loginpage(driver);
	l1.EnterDetails("Abhirami", "Aravind", "Prayaga,Street 1,Gandhi Nagar, Kochi", "abhi@gmail.com", "8541236547");
	l1.radioclick();
	Thread.sleep(2000);
	l1.movieClick();
	System.out.println("Test2 passed successfully");
  }
  @Test(priority = 3)
  public void Dropdown() 
  {
	  Select obj=new Select(driver.findElement(By.id("yearbox")));
	  obj.selectByValue("1994");
	  Select obj1= new Select(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[11]/div[2]/select")));
	  obj1.selectByValue("November");
	  Select obj2=new Select(driver.findElement(By.id("daybox")));
	  obj2.selectByValue("30");
	  Select sk= new Select(driver.findElement(By.id("Skills")));
	  sk.selectByValue("Java");
	  System.out.println("Test3 passed successfully");
  }
  @Test(priority = 4)
  public void passwordEnter()
  {
	    String actualtitle=driver.getTitle();
		String exptitle="Register";
		System.out.println("Title is:"+actualtitle);
		Assert.assertEquals(actualtitle, exptitle);
		System.out.println("Title verified");
		Loginpage l2=new Loginpage(driver);
		List<WebElement> li=driver.findElements(By.tagName("a"));
		int explinkcount=50;
		int actlinkcount=li.size();
		if(explinkcount==actlinkcount)
		{
			System.out.println("Link count matches");
		}
		else
		{
			System.out.println("Link count not matches");
		}
		System.out.println("Total link count:"+li.size());
		l2.passwordSection("abhi1234", "abhi1234");
	    l2.Submit();
	    System.out.println("Test4 passed successfully");
  }
  @Test(priority = 5)
  public void fileuploadMenu() 
  {
	  Loginpage ob=new Loginpage(driver);
	  WebElement f=driver.findElement(By.xpath("//*[@id=\"imagesrc\"]"));
	  f.sendKeys("C:\\Users\\sachin\\Desktop\\Keralaproperty_Bugreport.xlsx");
	  System.out.println("Test5 passed successfully");
  }
  @Test(priority = 6)
  public void switchTo() throws InterruptedException, IOException
  {
	  Loginpage l3= new Loginpage(driver);
	  WebElement switchto= driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a[1]"));
	  Actions action= new Actions(driver);
	  action.moveToElement(switchto);
	  WebElement alert=driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[1]/a[1]"));
	  action.moveToElement(alert);
	  action.click().build().perform();
	  l3.Alertpage();
	  Alert alertpopup= driver.switchTo().alert();
	  Thread.sleep(3000);
	  alertpopup.accept();
	  File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(ss, new File("C:\\Users\\sachin\\Desktop\\Abhirami\\screenshot.png"));
	  System.out.println("Test6 passed successfully");
	  driver.navigate().back();
	  driver.close();
  }
 }
	

